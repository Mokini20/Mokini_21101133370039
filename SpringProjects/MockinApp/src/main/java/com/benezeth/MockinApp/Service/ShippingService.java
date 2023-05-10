package com.benezeth.MockinApp.Service;

import com.benezeth.MockinApp.entity.ShippingEntity;

import java.util.List;

@SuppressWarnings("ALL")
public interface ShippingService {
    ShippingEntity addUser(ShippingEntity shippingEntity);
    List<ShippingEntity> getAllUser();
    ShippingEntity getUserById(Long id);
    ShippingEntity updateUser(Long id, ShippingEntity shippingEntity);

    @SuppressWarnings("UnnecessaryLocalVariable")

    void  deleteUser(Long id);
}


