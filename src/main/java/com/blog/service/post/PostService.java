package com.blog.service.post;

import com.blog.model.Post;
import java.util.List;

public interface PostService {
    List<Post> getAll();
    void save(Post post);
    void update(Post post);
    Post getById(int id);
    List<Post> getByUserId(int id);
}
