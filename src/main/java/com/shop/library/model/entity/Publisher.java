package com.shop.library.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="publisher")
public class Publisher {
    @Id
    @GeneratedValue
    private int pubid;

    @Column(name="name")
    private String  name;

    @OneToMany(mappedBy = "publisher")
    Set<BookPublisher> bookpublishers;

}
