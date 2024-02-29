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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

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

    @Override
    public List<ProductDto> findProducts(Float facilityId, String status, Float categoryId, Float supplierId, Float minPrice, Float maxPrice) {
        return productCustomRepo.findProduct(facilityId, status, categoryId, supplierId, minPrice, maxPrice)
                .stream().map(x -> {
                    x.setStatus(FacilityProductStatusEnum.typeOf(x.getStatus()).getValue());
                    return x;
                }).toList();
    }

    @Override
    public ProductDto findProductDetail(Float facilityId, String code) {
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
    public Product create(UserDetails userDetails, Product product) {
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
        facilityProductRepo.saveAll(facilities.stream().map(x -> new FacilityProduct(x, finalProduct, 0, 0.0F,
                FacilityProductStatusEnum.COMING_SOON.name()))
                .toList());
        return finalProduct;
    }

    @Override
    public Product update(Product product, Float id) {
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
        return productRepo.save(finalProduct);
    }

    @Override
    @Transactional
    public void delete(List<Float> ids) {
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
