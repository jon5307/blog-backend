package com.jon5307.blog.post;

import com.jon5307.blog.EntityNotFoundException;
import com.jon5307.blog.category.Category;
import com.jon5307.blog.category.CategoryRepository;
import com.jon5307.blog.post.dto.PostCreateRequest;
import com.jon5307.blog.post.dto.PostDetailResponse;
import com.jon5307.blog.post.dto.PostListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.jon5307.blog.util.MarkdownUtil.toPlainText;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;

    public PostDetailResponse getPost(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            return PostDetailResponse.from(post.get());
        } else {
            throw new EntityNotFoundException("Post not found");
        }
    }

    public Page<PostListResponse> getPostList(Long categoryId, Pageable pageable) {
        Page<Post> postPage;
        if (categoryId == null) {
            postPage = postRepository.findAll(pageable);
        } else {
            postPage = postRepository.findAllByCategoryId(categoryId, pageable);
        }
        return postPage.map(PostListResponse::from);
    }

    public void createPost(PostCreateRequest request) {
        Post post = new Post();
        // 제목, 내용, 생성일 설정
        post.setTitle(request.title());
        post.setContent(request.content());
        post.setCreatedDate(LocalDateTime.now());
        // 요약 설정
        String plainContent = toPlainText(request.content());
        String summary = plainContent.length() <= 100 ? plainContent : plainContent.substring(0, 100);
        post.setSummary(summary);
        // 카테고리 설정
        Optional<Category> category = categoryRepository.findById(request.categoryId());
        if (category.isPresent()) {
            post.setCategory(category.get());
        } else {
            throw new EntityNotFoundException("Category not found");
        }
        postRepository.save(post);
    }
}
