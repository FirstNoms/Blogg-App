package com.blogApp.blog.data.dto;

import lombok.Data;

@Data
public class PostUpdateDto {
    private String title;
    private String postBody;
    private String author;

}
