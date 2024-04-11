package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.FacilityProduct;
import org.springframework.security.core.userdetails.UserDetails;

public interface FacilityProductService extends BaseService<FacilityProduct> {

    String updateCustom(FacilityProduct facilityProduct, Long productId, Long facilityId, UserDetails userDetails);
}
