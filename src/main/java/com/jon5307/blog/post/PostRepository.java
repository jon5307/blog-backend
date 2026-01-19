package com.jon5307.blog.post;

import com.jon5307.blog.post.dto.PostListResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {
    @Query("SELECT new com.jon5307.blog.post.dto.PostListResponse(p.id, p.title, p.summary, p.createdDate) FROM Post p")
    Page<PostListResponse> findAllPostList(Pageable pageable);
}
