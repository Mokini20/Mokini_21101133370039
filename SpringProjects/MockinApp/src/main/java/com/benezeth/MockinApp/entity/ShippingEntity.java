package com.benezeth.MockinApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="User_info")
public class ShippingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name="UserId")
    int UserId;
    @Column(name="DestinationAddress")
    String DestinationAddress;
    @Column(name="CustomerName")
    String CustomerName;
}
