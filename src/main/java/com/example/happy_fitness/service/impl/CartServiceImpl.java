package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.common.FacilityProductStatusEnum;
import com.example.happy_fitness.custom_repository.CartCustomRepository;
import com.example.happy_fitness.dto.CartDto;
import com.example.happy_fitness.entity.Cart;
import com.example.happy_fitness.entity.FacilityProduct;
import com.example.happy_fitness.repository.CartRepository;
import com.example.happy_fitness.repository.FacilityProductRepository;
import com.example.happy_fitness.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private CartCustomRepository cartCustomRepo;

    @Autowired
    private FacilityProductRepository facilityProductRepo;

    @Override
    public String create(UserDetails userDetails, Cart cart) {
        return null;
    }

    @Override
    public String update(Cart cart, Long id, UserDetails userDetails) {
        return null;
    }

    @Override
    public void delete(List<Long> ids) {
        cartRepo.deleteAllById(ids);
    }

    @Override
    public List<CartDto> findAllByUser(String username) {
        return cartCustomRepo.findAllByUser(username);
    }

    @Override
    public String addToCart(String username, Cart cart) {
        FacilityProduct facilityProduct = facilityProductRepo.findById(cart.getFacilityProduct().getId())
                .orElseThrow(() -> new RuntimeException(ErrorMessageEnum.PRODUCT_NOT_EXIST.getCode()));
        if (!FacilityProductStatusEnum.ACTIVE.name().equals(facilityProduct.getStatus())) {
            throw new RuntimeException(ErrorMessageEnum.PRODUCT_NOT_ACTIVE.getCode());
        }
        Cart cartExist = cartRepo.findByCreatedByAndFacilityProduct_Id(username, cart.getFacilityProduct().getId());
        if (cartExist != null) {
            Integer cartQuantity = cartExist.getQuantity() + cart.getQuantity();
            cartExist.setQuantity(cartQuantity <= facilityProduct.getStockQuantity()
                    ? cartQuantity
                    : facilityProduct.getStockQuantity());
            cartRepo.save(cartExist);
        } else {
            cart.setQuantity(cart.getQuantity() < facilityProduct.getStockQuantity()
                    ? cart.getQuantity()
                    : facilityProduct.getStockQuantity());
            cartRepo.save(cart);
        }
        return HttpStatus.OK.getReasonPhrase();
    }

    @Override
    public String changeQuantity(List<CartDto> cartDtos) {
        List<Cart> carts = cartRepo.findAllById(cartDtos.stream().map(CartDto::getId).toList());
        carts.forEach(x -> {
            CartDto cart = cartDtos.stream()
                    .filter(cartDto -> x.getId().equals(cartDto.getId())).findFirst().get();
            if (cart.getQuantity() > x.getFacilityProduct().getStockQuantity()) {
                throw new RuntimeException(String.format("Sản phẩm %s chỉ còn lại tối đa %d",
                        x.getFacilityProduct().getProduct().getName(),
                        x.getFacilityProduct().getStockQuantity()));
            }
            x.setQuantity(cart.getQuantity());
        });
        cartRepo.saveAll(carts);
        return HttpStatus.OK.getReasonPhrase();
    }
}
