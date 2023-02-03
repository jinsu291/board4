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

    private long author;

    public Post(String subject, String content, String contentHtml, long author) {
        this.subject = subject;
        this.content = content;
        this.contentHtml = contentHtml;
        this.author = author;
    }

}
