package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.common.RoleEnum;
import com.example.happy_fitness.entity.FacilityProduct;
import com.example.happy_fitness.entity.User;
import com.example.happy_fitness.repository.FacilityProductRepository;
import com.example.happy_fitness.repository.UserRepository;
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

    @Autowired
    private UserRepository userRepo;

    @Override
    public String create(UserDetails userDetails, FacilityProduct facilityProduct) {
        return null;
    }

    @Override
    public String update(FacilityProduct facilityProduct, Long id, UserDetails userDetails) {
        User requester = userRepo.findByUsername(userDetails.getUsername());
        if (RoleEnum.ROLE_MANAGER.getId().equals(requester.getRole().getId())
            && !facilityProduct.getFacility().getId().equals(requester.getFacility().getId())) {
            throw new RuntimeException(ErrorMessageEnum.ERROR_UPDATE_FACILITY_PRODUCT.getCode());
        }
        FacilityProduct facilityProductOrigin = facilityProductRepo.findById(id)
                .orElseThrow(() -> new RuntimeException(ErrorMessageEnum.PRODUCT_NOT_EXIST.getCode()));
        facilityProductOrigin.setStockQuantity(facilityProduct.getStockQuantity());
        facilityProductOrigin.setStatus(facilityProduct.getStatus());
        facilityProductOrigin.setPrice(facilityProduct.getPrice());
        facilityProductRepo.save(facilityProductOrigin);
        return HttpStatus.OK.getReasonPhrase();
    }

    @Override
    public void delete(List<Long> ids) {

    }

    @Override
    public String updateCustom(FacilityProduct facilityProduct, Long productId, Long facilityId, UserDetails userDetails) {
        User requester = userRepo.findByUsername(userDetails.getUsername());
        if (RoleEnum.ROLE_MANAGER.getId().equals(requester.getRole().getId())
                && !facilityProduct.getFacility().getId().equals(requester.getFacility().getId())) {
            throw new RuntimeException(ErrorMessageEnum.ERROR_UPDATE_FACILITY_PRODUCT.getCode());
        }
        FacilityProduct facilityProductOrigin = facilityProductRepo.findByFacility_IdAndProduct_Id(facilityId, productId);
        facilityProductOrigin.setStockQuantity(facilityProduct.getStockQuantity());
        facilityProductOrigin.setStatus(facilityProduct.getStatus());
        facilityProductOrigin.setPrice(facilityProduct.getPrice());
        facilityProductRepo.save(facilityProductOrigin);
        return HttpStatus.OK.getReasonPhrase();
    }
}
