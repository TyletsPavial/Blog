package com.blog.service.post;

import com.blog.model.Post;
import com.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostService{
    @Autowired
    PostRepository postRepository;
    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void update(Post post) {
        
    }

    @Override
    public Post getById(int id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> getByUserId(int id) {
        return postRepository.findByUserId(id);
    }

}
