package com.shop.library.model.mapper;

import com.shop.library.model.dto.AuthorDto;
import com.shop.library.model.dto.BookDto;
import com.shop.library.model.entity.Book;
import com.shop.library.model.entity.BookAuthor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring", uses = {AuthorMapper.class})
public abstract class BookMapper {
//    BookMapper  INSTANCE = Mappers.getMapper(BookMapper.class);

    @Autowired
    private AuthorMapper authorMapper;

    @Mapping(target = "authors", expression = "java(getAuthorDtoFromBookAuthor(book.getBookauthors()))")
    public abstract BookDto toDto(Book book);

    public abstract Book toEntity(BookDto bookDto);

    public Set<AuthorDto> getAuthorDtoFromBookAuthor(Set<BookAuthor> bookauthors){
        if(CollectionUtils.isEmpty(bookauthors)) return Set.of();
        return bookauthors.stream().map(ba -> authorMapper.toDto(ba.getAuthor())).collect(Collectors.toSet());
    }
}
