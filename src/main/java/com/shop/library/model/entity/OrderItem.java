package com.shop.library.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="orderitem")
public class OrderItem {
    @EmbeddedId
    private OrderItemId orderItemId;

    @ManyToOne
    @JoinColumn(name = "orderid")
    @MapsId("orderid")
    Order order;

    @ManyToOne
    @JoinColumn(name = "bookid")
    @MapsId("bookid")
    Book book;
}
