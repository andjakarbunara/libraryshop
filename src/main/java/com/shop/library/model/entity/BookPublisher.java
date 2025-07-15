package com.shop.library.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="bookpublisher")
public class BookPublisher {
    @EmbeddedId
    private BookPublisherId bookPublisherId;

    @ManyToOne
    @JoinColumn(name = "pubid")
    @MapsId("pubid")
    Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "bookid")
    @MapsId("bookid")
    Book book;
}
