package com.blog.service.comment;

import com.blog.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAll();
    List<Comment> getByUserId(int id);
    List<Comment> getByPostId(int id);
    Comment getById(int id);
    void save(Comment comment);

    void delete(int commentId);
}
