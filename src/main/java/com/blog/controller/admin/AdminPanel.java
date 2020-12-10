package com.blog.controller.admin;

import com.blog.model.Comment;
import com.blog.model.Post;
import com.blog.service.comment.CommentService;
import com.blog.service.post.PostService;
import com.blog.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/AdminPanel")
public class AdminPanel {

    @Autowired
    UserService userService;
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;

    @GetMapping("/")
    public String userList(Model model){
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @GetMapping("/Users/{userId}")
    public String userDetails(Model model, @PathVariable int userId){
        List<Post> posts = postService.getByUserId(userId);
        model.addAttribute("user", userService.findById(userId));
        model.addAttribute("posts", posts);
        Set<Post> comPosts = new HashSet<>();
        for(Comment comment : commentService.getByUserId(userId)){
            comPosts.add(comment.getPost());
        }
        model.addAttribute("comPosts", comPosts);
        return "userPanel";
    }
}
