package com.example.board4.app.post.entity;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Post {
    private long id;
    private String subject;
    private String content;
    private String contentHtml;

    public Post(String subject, String content, String contentHtml) {
        this.subject = subject;
        this.content = content;
        this.contentHtml = contentHtml;
    }
}
