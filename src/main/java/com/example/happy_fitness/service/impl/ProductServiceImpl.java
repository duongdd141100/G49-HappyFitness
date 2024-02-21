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
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
        return productCustomRepo.findProduct(facilityId, status, categoryId, supplierId, minPrice, maxPrice);
    }

    @Override
    public Product create(Product product) {
        if (!StringUtils.hasText(product.getName())
            || product.getCategory() == null
            || product.getCategory().getId() == null
            || product.getSupplier() == null
            || product.getSupplier().getId() == null) {
            throw new RuntimeException(ErrorMessageEnum.LACK_OF_INFORMATION.getCode());
        }
        SimpleDateFormat formatter = new SimpleDateFormat(Constants.DATETIME_YYYY_MM_DD_HH_MM_SS_SSS);
        product.setCode("P_" + formatter.format(new Date()));
        Product finalProduct = productRepo.save(product);
        List<Facility> facilities = facilityRepo.findAll();
        facilityProductRepo.saveAll(facilities.stream().map(x -> new FacilityProduct(x, finalProduct, 0, 0.0F,
                FacilityProductStatusEnum.COMING_SOON.name()))
                .toList());
        return finalProduct;
    }

    @Override
    public Product update(Product product, Float id) {
        return null;
    }

    @Override
    public void delete(Float id) {

    }
}
