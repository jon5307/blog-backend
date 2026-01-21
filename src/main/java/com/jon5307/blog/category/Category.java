package com.jon5307.blog.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jon5307.blog.post.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy="category")
    @JsonIgnore
    private List<Post> posts = new ArrayList<>();
}
