package com.shop.library.service.impl;

import com.shop.library.model.dto.AuthorDto;
import com.shop.library.model.entity.Author;
import com.shop.library.model.mapper.AuthorMapper;
import com.shop.library.repo.AuthorRepository;
import com.shop.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorMapper authorMapper;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public AuthorDto getAuthorById(Integer authorId) {
        Optional<Author> author = authorRepository.findById(authorId);

        if (author.isPresent()) {
            return authorMapper.toDto(author.get());
        }
        throw new RuntimeException("Author with ID " + authorId + " not found.");
    }


    @Override
    @Transactional
    public AuthorDto createAuthor(AuthorDto authordto) {
        Author author = authorMapper.toEntity(authordto);
        Author savedAuthor = authorRepository.save(author);
        return authorMapper.toDto(savedAuthor);
    }

}
