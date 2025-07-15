package com.shop.library.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"authorid"})
@Table(name="author")
public class Author {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Integer authorid;

        @Column(name="name")
        private String  name;

        @Column(name="surname")
        private String surname;

        @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "author", orphanRemoval = true)
        Set<BookAuthor> bookauthors;


}
