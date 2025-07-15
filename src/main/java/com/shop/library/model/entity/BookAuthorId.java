package com.shop.library.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BookAuthorId implements Serializable {
    @Column(name = "authorid", insertable = false, updatable = false)
    private Integer authorid;

    @Column(name = "bookid", insertable = false, updatable = false)
    private Integer bookid;

}
