package com.example.board4.app.post.service;

import com.example.board4.app.post.entity.Post;
import com.example.board4.app.post.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public Post findById(Long id) {
        return postMapper.findById(id);
    }

    @Transactional
    public Long update(Post post) {
        return postMapper.update(post);
    }

    public void deleteById(Long id) {
        postMapper.delete(id);
    }

    public List<Post> postList(){
        return postMapper.findAll();
    }
}
