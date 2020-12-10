package com.blog.repository;

import com.blog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> getByUserId(int id);
    List<Comment> getByPostId(int id);
    Comment getById(int id);
}
