package com.shop.library.service.impl;

import com.shop.library.model.dto.AuthorDto;
import com.shop.library.model.entity.Author;
import com.shop.library.model.entity.Book;
import com.shop.library.model.entity.BookAuthor;
import com.shop.library.model.mapper.AuthorMapper;
import com.shop.library.model.mapper.BookAuthorMapper;
import com.shop.library.model.mapper.BookMapper;
import com.shop.library.repo.BookAuthorRepository;
import com.shop.library.service.AuthorService;
import com.shop.library.service.BookAuthorServirce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Set;

@Service
public class BookAuthorServiceImpl implements BookAuthorServirce {
    @Autowired
    private AuthorMapper authorMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookAuthorMapper bookAuthorMapper;

    @Autowired
    private BookAuthorRepository bookAuthorRepository;


    @Override
    @Transactional
    public Set<BookAuthor> createBookAuthor(Set<AuthorDto> authorDto, Book bookEntity) {
            Author author = authorMapper.toEntity((AuthorDto) authorDto);
            BookAuthor bookAuthor = new BookAuthor();
            bookAuthor.setBook(bookEntity);
            bookAuthor.setAuthor(author);
            return Collections.singleton(bookAuthorRepository.save(bookAuthor));
        }

}

