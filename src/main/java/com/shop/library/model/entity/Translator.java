package com.shop.library.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="translator")
public class Translator {
    @Id
    @GeneratedValue
    private int translaterId;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @OneToMany(mappedBy = "translator")
    Set<BookTranslator> booktranslators;
}
