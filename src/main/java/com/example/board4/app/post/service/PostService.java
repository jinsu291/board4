package com.example.board4.app.post.service;

import com.example.board4.app.post.entity.Post;
import com.example.board4.app.post.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    @Autowired
    private final PostMapper postMapper;

    @Transactional
    public Long write(Post post) {
        postMapper.save(post);
        return post.getId();
    }
}
