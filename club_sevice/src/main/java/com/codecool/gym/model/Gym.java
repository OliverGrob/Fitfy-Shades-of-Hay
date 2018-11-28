package com.codecool.gym.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Gym {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String city;

    @Column(name = "zip_code", nullable = false)
    String zipCode;

    @Column(nullable = false)
    String address;

    @Column(nullable = false)
    String url;

    public Gym(String city, String zipCode, String name, String address, String url) {
        this.city = city;
        this.zipCode = zipCode;
        this.name = name;
        this.address = address;
        this.url = url;
    }
}
