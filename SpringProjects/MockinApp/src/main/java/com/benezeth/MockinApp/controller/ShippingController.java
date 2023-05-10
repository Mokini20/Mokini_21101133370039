package com.benezeth.MockinApp.controller;

import com.benezeth.MockinApp.entity.ShippingEntity;
import com.benezeth.MockinApp.exception.ShippingException;
import com.benezeth.MockinApp.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/g/manifest_info")
public class ShippingController {

    @Autowired
    private ShippingRepository shippingRepository;

    //code for getting all user info
    @GetMapping
    public List<ShippingEntity> getAllUser(){
        return shippingRepository.findAll();
    }

    //code for creating user
    @PostMapping
    public ShippingEntity createUser(@RequestBody ShippingEntity shippingEntity){
        return shippingRepository.save(shippingEntity);
    }
    //code for getting user by id
    @GetMapping("{id}")
    public ResponseEntity<ShippingEntity> getUserById(@PathVariable Long id){
        ShippingEntity getUser =shippingRepository.findById(id)
                .orElseThrow(()->new ShippingException("User does not exist"));

        return ResponseEntity.ok(getUser);
    }
    //code for updating user
    @PutMapping("{id}")
    public ResponseEntity<ShippingEntity> updateUser(@PathVariable long id,@RequestBody ShippingEntity userDetails ){
        ShippingEntity updateUser = shippingRepository.findById(id)
                .orElseThrow(()->new ShippingException("User does not exist"));

        updateUser.setDestinationAddress(userDetails.getDestinationAddress());
        updateUser.setCustomerName(userDetails.getCustomerName());
        updateUser.setUserId(userDetails.getUserId());


        shippingRepository.save(updateUser);

        return ResponseEntity.ok(updateUser);
    }

    //code for deleting
    @DeleteMapping("{id}")

    public ResponseEntity<ShippingEntity> deleteUser(long id){
        ShippingEntity user = shippingRepository.findById(id)
                .orElseThrow(()->new ShippingException("User does not exist"));

        shippingRepository.delete(user);
        return ResponseEntity.ok(user);
    }
}


