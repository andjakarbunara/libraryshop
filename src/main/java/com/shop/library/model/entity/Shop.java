package com.shop.library.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="shop")
public class Shop {
    @Id
    @GeneratedValue
    private int shopid;

    @Column(name="name")
    private String name;

    @Column(name="place")
    private int place;

    @Column(name="startingdate")
    private Date startingdate;

    @OneToMany(mappedBy = "shop")
    Set<Distribution> distributions;
}
