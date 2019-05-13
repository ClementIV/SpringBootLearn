package com.example.lesson9.pojo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Author {
    @Setter(AccessLevel.PUBLIC)
    private Long id;
    private String realName;
    private String nickName;

}
