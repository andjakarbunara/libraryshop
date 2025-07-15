package com.shop.library.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="booktranslator")
public class BookTranslator {
    @EmbeddedId
    private BookTranslatorId bookTranslatorId;

    @ManyToOne
    @JoinColumn(name = "translaterId")
    @MapsId("translaterId")
    Translator translator;

    @ManyToOne
    @JoinColumn(name = "bookid")
    @MapsId("bookid")
    Book book;

}
