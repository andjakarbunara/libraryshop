package com.shop.library.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Data
public class AuthorDto {
    private Integer authorid;
    private String name;
    private String surname;
}
