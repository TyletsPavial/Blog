package com.blog.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postId")
    Integer id;
    String text;
    String title;

    @ManyToOne
    @JoinColumn(name = "userId")
    User user;

    public Post() {
    }

    public Post(Integer id, String text, String title, User user) {
        this.id = id;
        this.text = text;
        this.title = title;
        this.user = user;
    }

    public Post(String text, String title) {
        this.text = text;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id.equals(post.id) &&
                text.equals(post.text) &&
                title.equals(post.title) &&
                user.equals(post.user);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, title, user);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }




}
