package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.common.FacilityProductStatusEnum;
import com.example.happy_fitness.common.OrderStatusEnum;
import com.example.happy_fitness.custom_repository.OrderCustomRepository;
import com.example.happy_fitness.dto.OrderDetailDto;
import com.example.happy_fitness.dto.OrderDto;
import com.example.happy_fitness.entity.Cart;
import com.example.happy_fitness.entity.Order;
import com.example.happy_fitness.entity.OrderProduct;
import com.example.happy_fitness.entity.Voucher;
import com.example.happy_fitness.repository.CartRepository;
import com.example.happy_fitness.repository.FacilityProductRepository;
import com.example.happy_fitness.repository.OrderRepository;
import com.example.happy_fitness.repository.VoucherRepository;
import com.example.happy_fitness.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private VoucherRepository voucherRepo;

    @Autowired
    private FacilityProductRepository facilityProductRepo;

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private OrderCustomRepository orderCustomRepo;

    @Override
    public String create(UserDetails userDetails, Order order) {
        return null;
    }

    @Override
    public String update(Order order, Long id, UserDetails userDetails) {
        return null;
    }

    @Override
    public void delete(List<Long> id) {

    }

    @Override
    @Transactional
    public String order(List<Long> cartIds, String voucherCode) {
        if (CollectionUtils.isEmpty(cartIds)) {
            throw new RuntimeException(ErrorMessageEnum.ORDER_EMPTY.getCode());
        }
        Voucher voucher = null;
        if (StringUtils.hasText(voucherCode)) {
            voucher = voucherRepo.findByCode(voucherCode)
                    .orElseThrow(() -> new RuntimeException(ErrorMessageEnum.VOUCHER_NOT_EXIST.getCode()));
            Date now = new Date();
            if (voucher.getStartDate().after(now) || voucher.getEndDate().before(now)) {
                throw new RuntimeException(ErrorMessageEnum.VOUCHER_NOT_VALID.getCode());
            }
        }
        List<Cart> carts = cartRepo.findAllById(cartIds);
        Order order = new Order();
        order.setOrderProducts(carts.stream().map(x -> {
            if (!FacilityProductStatusEnum.ACTIVE.name().equals(x.getFacilityProduct().getStatus())) {
                throw new RuntimeException(ErrorMessageEnum.PRODUCT_NOT_ACTIVE.getCode());
            }
            if (x.getQuantity() > x.getFacilityProduct().getStockQuantity()) {
                throw new RuntimeException(ErrorMessageEnum.PRODUCT_NOT_ENOUGH.getCode());
            }
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setOrder(order);
            orderProduct.setFacilityProduct(x.getFacilityProduct());
            x.getFacilityProduct().setStockQuantity(x.getFacilityProduct().getStockQuantity() - x.getQuantity());
            orderProduct.setQuantity(x.getQuantity());
            orderProduct.setUnitPrice(x.getFacilityProduct().getPrice());
            return orderProduct;
        }).toList());
        order.setVoucher(voucher);
        order.setStatus(OrderStatusEnum.PROCESSING.name());
        Float orderPrice = Float.parseFloat(String.valueOf(
                order.getOrderProducts().stream().mapToDouble(x -> x.getUnitPrice() * x.getQuantity()).sum()));
        if (voucher != null) {
            Float discount = orderPrice * voucher.getPercentAmount() / 100;
            order.setPrice(discount > voucher.getMaxMoneyAmount()
                    ? orderPrice - voucher.getMaxMoneyAmount()
                    : orderPrice - discount);
        } else {
            order.setPrice(orderPrice);
        }
        orderRepo.save(order);
        cartRepo.deleteAllById(cartIds);
        return HttpStatus.OK.getReasonPhrase();
    }

    @Override
    public List<OrderDto> findOrders(UserDetails userDetails) {
        return orderCustomRepo.findAll(userDetails.getUsername(),
                userDetails.getAuthorities().stream().findFirst().get().getAuthority()).stream().map(x -> {
                    x.setStatus(OrderStatusEnum.typeOf(x.getStatus()).getValue());
                    return x;
        }).toList();
    }

    @Override
    public List<OrderDetailDto> findOrderDetail(Long id, UserDetails userDetails) {
        return orderCustomRepo.findOrderDetail(id, userDetails.getUsername(),
                userDetails.getAuthorities().stream().findFirst().get().getAuthority());
    }
}
