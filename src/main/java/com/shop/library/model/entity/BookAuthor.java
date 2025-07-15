package com.shop.library.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name="bookauthor")
public class BookAuthor {
    @EmbeddedId
    private BookAuthorId bookAuthorId = new BookAuthorId();

    @ManyToOne
    @JoinColumn(name = "authorid", referencedColumnName = "authorid" )
    @MapsId("authorid")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "bookid", referencedColumnName = "bookid")
    @MapsId("bookid")
    private Book book;

}

