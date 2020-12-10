package com.blog.service.comment;

import com.blog.model.Comment;
import com.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentService{
    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> getByUserId(int id) {
        return commentRepository.getByUserId(id);
    }

    @Override
    public List<Comment> getByPostId(int id) {
        return commentRepository.getByPostId(id);
    }

    @Override
    public Comment getById(int id) {
        return commentRepository.getById(id);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void delete(int commentId) {
        commentRepository.deleteById(commentId);
    }
}
