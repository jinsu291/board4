package com.example.board4.app.post.mapper;

import com.example.board4.app.post.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PostMapper {
    Long save(Post post);

    Post findById(Long id);

    Long update(Post post);

    void delete(Long id);
}
