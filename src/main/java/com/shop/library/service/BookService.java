package com.shop.library.service;


import com.shop.library.model.dto.AuthorDto;
import com.shop.library.model.dto.BookDto;
import com.shop.library.model.entity.BookAuthor;

import java.util.List;
import java.util.Set;

public interface BookService {

    BookDto getBookById(Integer bookId);
    List<BookDto> getAllBooks();
    BookDto createBook(BookDto newbook);

}
