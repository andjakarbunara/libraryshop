package com.shop.library.service;


import com.shop.library.model.dto.AuthorDto;
import com.shop.library.model.entity.Author;
import com.shop.library.model.entity.Book;
import com.shop.library.model.entity.BookAuthor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface BookAuthorServirce {

//    Set<BookAuthor> createBookAuthor(Set<AuthorDto> authors, BookDto bookDto);

    @Transactional
    Set<BookAuthor> createBookAuthor(Set<AuthorDto> authorDto, Book bookEntity);
}
