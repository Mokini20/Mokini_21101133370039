package com.benezeth.MockinApp.ServiceImpl;

import com.benezeth.MockinApp.Service.ShippingService;
import com.benezeth.MockinApp.entity.ShippingEntity;
import com.benezeth.MockinApp.exception.ShippingException;
import com.benezeth.MockinApp.repository.ShippingRepository;

import java.util.List;


    @SuppressWarnings({"unchecked", "unused", "RedundantSuppression", "FieldMayBeFinal"})
    public abstract class ShippingServiceImpl implements ShippingService {
        private ShippingRepository shippingRepository;

        public ShippingServiceImpl(ShippingRepository shippingRepository) {
            this.shippingRepository = shippingRepository;
        }

        public ShippingEntity addUser(ShippingEntity shippingEntity) {
            return shippingRepository.save(shippingEntity);
        }

        @Override
        public List<ShippingEntity> getAllUser() {
            return shippingRepository.findAll();
        }

        @SuppressWarnings("UnnecessaryLocalVariable")
        @Override
        public ShippingEntity getUserById(Long id) {
            ShippingEntity shippingEntity=shippingRepository.findById(id).orElseThrow(()-> new ShippingException("user does not exist"));

            return shippingEntity;
        }

        @SuppressWarnings("UnnecessaryLocalVariable")
        @Override
        public ShippingEntity updateUser(Long id, ShippingEntity shippingEntity) {
            ShippingEntity existingUser=shippingRepository.findById(id)
                    .orElseThrow(()->new ShippingException("user Does not exist"));
            existingUser.setUserId(shippingEntity.getUserId());
            existingUser.setCustomerName(shippingEntity.getCustomerName());
            existingUser.setDestinationAddress(shippingEntity.getDestinationAddress());

            ShippingEntity updateUser=shippingRepository.save(existingUser);
            return updateUser ;
        }

        @Override
        public void deleteUser(Long id) {
            ShippingEntity deleteUser=shippingRepository.findById(id)
                    .orElseThrow(()->new ShippingException("User Not found"));
            shippingRepository.delete(deleteUser);
}}
