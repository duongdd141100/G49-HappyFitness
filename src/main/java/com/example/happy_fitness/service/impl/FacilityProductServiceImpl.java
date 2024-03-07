package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.entity.FacilityProduct;
import com.example.happy_fitness.repository.FacilityProductRepository;
import com.example.happy_fitness.service.FacilityProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityProductServiceImpl implements FacilityProductService {
    @Autowired
    private FacilityProductRepository facilityProductRepo;

    @Override
    public FacilityProduct create(UserDetails userDetails, FacilityProduct facilityProduct) {
        return null;
    }

    @Override
    public String update(FacilityProduct facilityProduct, Float id) {
        FacilityProduct facilityProductOrigin = facilityProductRepo.findById(id)
                .orElseThrow(() -> new RuntimeException(ErrorMessageEnum.PRODUCT_NOT_EXIST.getCode()));
        facilityProductOrigin.setStockQuantity(facilityProduct.getStockQuantity());
        facilityProductOrigin.setStatus(facilityProduct.getStatus());
        facilityProductOrigin.setPrice(facilityProduct.getPrice());
        facilityProductRepo.save(facilityProductOrigin);
        return HttpStatus.OK.getReasonPhrase();
    }

    @Override
    public void delete(List<Float> ids) {

    }
}
