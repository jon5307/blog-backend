package com.jon5307.blog.post;

import com.jon5307.blog.EntityNotFoundException;
import com.jon5307.blog.post.dto.PostListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.jon5307.blog.util.MarkdownUtil.toPlainText;

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

    public Page<PostListResponse> getPostList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createdDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return postRepository.findAllPostList(pageable);
    }

    public void createPost(String title, String content) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        String plainContent = toPlainText(content);
        String summary = plainContent.length() <= 100 ? plainContent : plainContent.substring(0, 100);
        post.setSummary(summary);
        post.setCreatedDate(LocalDateTime.now());
        postRepository.save(post);
    }
}
