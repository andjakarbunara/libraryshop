package com.shop.library.model.mapper;

import com.shop.library.model.dto.AuthorDto;
import com.shop.library.model.entity.Author;
import com.shop.library.model.entity.Book;
import com.shop.library.model.entity.BookAuthor;
import org.mapstruct.Mapper;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public interface BookAuthorMapper {

//        BookAuthor toEntity (Set<Author> authors, Book book) ;
        BookAuthor toDto (Author author, Book book);
        BookAuthor toEntity(AuthorDto author, Book book);

        default Set<BookAuthor> toEntity(Set<AuthorDto> authors, Book book) {
                if (authors == null) return new HashSet<>();

                return authors.stream()
                        .map(author -> toEntity(author, book))
                        .collect(Collectors.toSet());
        }


}
