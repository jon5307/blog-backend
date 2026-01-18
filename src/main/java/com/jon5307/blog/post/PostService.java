package com.jon5307.blog.post;

import com.jon5307.blog.EntityNotFoundException;
import com.jon5307.blog.post.dto.PostListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public Post getPost(int id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            return post.get();
        } else {
            throw new EntityNotFoundException("Post not found");
        }
    }

    public List<PostListResponse> getPostList() {
        return postRepository.findAllBy();
    }

    public void createPost(String title, String content) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        String summary = content.length() <= 50 ? content : content.substring(0, 50);
        post.setSummary(summary);
        post.setCreatedDate(LocalDateTime.now());
        postRepository.save(post);
    }
}
