package com.shop.library.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue
    private int orderid;

    @Column(name="clientid")
    private int clientid;

    @Column(name="shopid")
    private int shopid;

    @Column(name="seller")
    private String seller;

    @Column(name="score")
    private int score;

    @OneToMany(mappedBy = "order")
    Set<OrderItem> orderitems;

}
