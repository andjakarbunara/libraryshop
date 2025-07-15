package com.shop.library.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter @Setter @NoArgsConstructor
@Data
public class BookDto {
    private String title;
    private int cost;
    private int retail;
    private int quantity;
    private Set<AuthorDto> authors;

}
