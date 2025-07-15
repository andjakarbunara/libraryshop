package com.shop.library.service;

import com.shop.library.model.dto.AuthorDto;


public interface AuthorService {
    AuthorDto getAuthorById(Integer authorId);
    AuthorDto createAuthor(AuthorDto newauthor);
}
