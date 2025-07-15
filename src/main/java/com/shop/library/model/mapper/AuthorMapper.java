package com.shop.library.model.mapper;

import com.shop.library.model.dto.AuthorDto;
import com.shop.library.model.entity.Author;
import org.mapstruct.Mapper;

import java.util.Set;


@Mapper(componentModel = "spring")
public interface AuthorMapper {
//    AuthorMapper  INSTANCE = Mappers.getMapper(AuthorMapper.class);

//    @Mapping(source = "surname", target = "surname")
    AuthorDto toDto(Author author);
    AuthorDto toEntity(AuthorDto authorDto);
}
