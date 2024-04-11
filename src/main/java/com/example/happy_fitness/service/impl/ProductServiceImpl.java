package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.common.FacilityProductStatusEnum;
import com.example.happy_fitness.constants.Constants;
import com.example.happy_fitness.custom_repository.ProductCustomRepository;
import com.example.happy_fitness.dto.ProductDto;
import com.example.happy_fitness.entity.Facility;
import com.example.happy_fitness.entity.FacilityProduct;
import com.example.happy_fitness.entity.Product;
import com.example.happy_fitness.repository.FacilityProductRepository;
import com.example.happy_fitness.repository.FacilityRepository;
import com.example.happy_fitness.repository.ProductRepository;
import com.example.happy_fitness.service.ProductService;
import com.example.happy_fitness.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductCustomRepository productCustomRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private FacilityRepository facilityRepo;

    @Autowired
    private FacilityProductRepository facilityProductRepo;

    public static final String PRODUCT_IMG_FOLDER = "image/product/";
    public static final String IMAGE_PATH = "/image/";

    @Override
    public List<ProductDto> findProducts(Long facilityId, String status, Long categoryId, Long supplierId, Float minPrice, Float maxPrice) {
        return productCustomRepo.findProduct(facilityId, status, categoryId, supplierId, minPrice, maxPrice)
                .stream().map(x -> {
                    x.setStatus(FacilityProductStatusEnum.typeOf(x.getStatus()).getValue());
                    return x;
                }).toList();
    }

    @Override
    public ProductDto findProductDetail(Long facilityId, String code) {
        if (!StringUtils.hasText(code)) {
            throw new RuntimeException(ErrorMessageEnum.PRODUCT_CODE_NULL.getCode());
        }
        ProductDto product = productCustomRepo.findProductDetail(facilityId, code);
        if (product == null) {
            throw new RuntimeException(ErrorMessageEnum.PRODUCT_NOT_EXIST.getCode());
        }
        return Optional.of(product).map(x -> {
                    x.setStatus(FacilityProductStatusEnum.typeOf(x.getStatus()).getValue());
                    return x;
                }).get();
    }

    @Override
    public String createCustom(UserDetails userDetails, Product product, MultipartFile image) throws IOException {
        if (!StringUtils.hasText(product.getName())
                || product.getCategory() == null
                || product.getCategory().getId() == null
                || product.getSupplier() == null
                || product.getSupplier().getId() == null) {
            throw new RuntimeException(ErrorMessageEnum.LACK_OF_INFORMATION.getCode());
        }
        SimpleDateFormat formatter = new SimpleDateFormat(Constants.DATETIME_YYYY_MM_DD_HH_MM_SS_SSS);
        product.setCode("P_" + formatter.format(new Date()));
        product.setIsActive(true);
        Product finalProduct = productRepo.save(product);
        List<Facility> facilities = facilityRepo.findAll();
        if (image != null) {
            String fileName = product.getCode() + "_" + image.getOriginalFilename();
            FileUploadUtil.saveFile(PRODUCT_IMG_FOLDER, fileName, image);
            product.setImagePath(IMAGE_PATH + fileName);
        } else {
            product.setImagePath("");
        }
        facilityProductRepo.saveAll(facilities.stream().map(x -> new FacilityProduct(x, finalProduct, 0, 0.0F,
                        FacilityProductStatusEnum.COMING_SOON.name()))
                .toList());
        return HttpStatus.OK.getReasonPhrase();
    }

    @Override
    public String updateCustom(Product product, Long id, MultipartFile image) throws IOException {
        if (!StringUtils.hasText(product.getName())
                || product.getCategory() == null
                || product.getCategory().getId() == null
                || product.getSupplier() == null
                || product.getSupplier().getId() == null) {
            throw new RuntimeException(ErrorMessageEnum.LACK_OF_INFORMATION.getCode());
        }
        Product finalProduct = productRepo.findById(id).orElseThrow(() -> new RuntimeException(ErrorMessageEnum.PRODUCT_NOT_EXIST.getCode()));
        finalProduct.setName(product.getName());
        finalProduct.setCategory(product.getCategory());
        finalProduct.setSupplier(product.getSupplier());
        finalProduct.setDescription(product.getDescription());
        if (image != null) {
            String fileName = product.getCode() + "_" + image.getOriginalFilename();
            FileUploadUtil.saveFile(PRODUCT_IMG_FOLDER, fileName, image);
            finalProduct.setImagePath(IMAGE_PATH + fileName);
        } else {
            finalProduct.setImagePath("");
        }
        productRepo.save(finalProduct);
        return HttpStatus.OK.getReasonPhrase();
    }

    @Override
    public void active(Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException(ErrorMessageEnum.PRODUCT_NOT_EXIST.getCode()));
        if (product.getIsActive()) {
            throw new RuntimeException(ErrorMessageEnum.PRODUCT_ACTIVE.getCode());
        }
        product.setIsActive(true);
        product.getFacilityProducts().forEach(x -> {
            x.setStatus(FacilityProductStatusEnum.COMING_SOON.name());
        });
        productRepo.save(product);
    }

    @Override
    public Product create(UserDetails userDetails, Product product) {
        return null;
    }

    @Override
    public String update(Product product, Long id, UserDetails userDetails) {
        if (!StringUtils.hasText(product.getName())
                || product.getCategory() == null
                || product.getCategory().getId() == null
                || product.getSupplier() == null
                || product.getSupplier().getId() == null) {
            throw new RuntimeException(ErrorMessageEnum.LACK_OF_INFORMATION.getCode());
        }
        Product finalProduct = productRepo.findById(id).orElseThrow(() -> new RuntimeException(ErrorMessageEnum.PRODUCT_NOT_EXIST.getCode()));
        finalProduct.setName(product.getName());
        finalProduct.setCategory(product.getCategory());
        finalProduct.setSupplier(product.getSupplier());
        finalProduct.setDescription(product.getDescription());
        productRepo.save(finalProduct);
        return HttpStatus.OK.getReasonPhrase();
    }

    @Override
    @Transactional
    public void delete(List<Long> ids) {
        List<Product> products = productRepo.findAllById(ids);
        if (CollectionUtils.isEmpty(products)) {
            throw new RuntimeException(ErrorMessageEnum.PRODUCT_NOT_EXIST.getCode());
        }
        products.forEach(x -> {
            x.setIsActive(false);
            x.getFacilityProducts().forEach(f -> {
                f.setStatus(FacilityProductStatusEnum.DEACTIVATE.name());
            });
        });
        productRepo.saveAll(products);
    }
}
