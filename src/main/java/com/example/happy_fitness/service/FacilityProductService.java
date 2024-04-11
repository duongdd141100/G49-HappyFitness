package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.FacilityProduct;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigInteger;

public interface FacilityProductService extends BaseService<FacilityProduct> {

    String updateCustom(FacilityProduct facilityProduct, BigInteger productId, BigInteger facilityId, UserDetails userDetails);
}
