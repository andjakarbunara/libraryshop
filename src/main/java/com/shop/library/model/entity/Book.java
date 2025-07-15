package com.shop.library.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@Table(name="book")
@EqualsAndHashCode(of = {"bookid"})
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer bookid;

    @Column(name="title")
    private String title;

    @Column(name="cost")
    private int cost;

    @Column(name="retail")
    private int retail;

    @Column(name="quantity")
    private int quantity;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "book", orphanRemoval = true)
    Set<BookAuthor> bookauthors;

    @OneToMany(mappedBy = "book")
    Set<BookPublisher> bookpublishers;

    @OneToMany(mappedBy = "book")
    Set<BookTranslator> booktranslators;

    @OneToMany(mappedBy = "book")
    Set<OrderItem> orderitems;

    @OneToMany(mappedBy = "book")
    Set<Distribution> distributions;




}
