package com.benezeth.MockinApp;

import com.benezeth.MockinApp.entity.ShippingEntity;
import com.benezeth.MockinApp.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SuppressWarnings("resource")
@SpringBootApplication
public class MockinAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MockinAppApplication.class, args);
	}

	@Autowired
	private ShippingRepository shippingRepository;

	@Override
	public void run(String... args) {
		ShippingEntity shippingEntity = new ShippingEntity();
		shippingEntity.setUserId(123);
		shippingEntity.setDestinationAddress("Ikuti");
		shippingEntity.setCustomerName("Mockin");


	}
}
