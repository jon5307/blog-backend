package com.jon5307.blog;

import com.jon5307.blog.post.PostController;
import com.jon5307.blog.post.PostRepository;
import com.jon5307.blog.post.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    private PostService ps;

    @Test
    void test() {
        ps.createPost("첫번째 글","첫번째 내용");
    }
}
