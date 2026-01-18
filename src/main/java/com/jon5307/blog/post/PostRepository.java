package com.jon5307.blog.post;

import com.jon5307.blog.post.dto.PostListResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {
    List<PostListResponse> findAllBy();
}
