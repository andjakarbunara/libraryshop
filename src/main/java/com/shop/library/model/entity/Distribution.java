package com.shop.library.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="distribution")
public class Distribution {
    @EmbeddedId
    private DistributionId distributionId;

    @ManyToOne
    @JoinColumn(name = "shopid")
    @MapsId("shopid")
    Shop shop;

    @ManyToOne
    @JoinColumn(name = "bookid")
    @MapsId("bookid")
    Book book;

    @Column(name="sasia")
    private int sasia;
}
