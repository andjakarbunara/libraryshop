package com.shop.library.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue
    private int clientid;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="score")
    private int score;

}
