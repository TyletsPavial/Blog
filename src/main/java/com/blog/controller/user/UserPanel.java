package com.blog.controller.user;

import com.blog.model.Comment;
import com.blog.model.Post;
import com.blog.model.User;
import com.blog.service.comment.CommentService;
import com.blog.service.post.PostService;
import com.blog.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/account")
public class UserPanel {

    @Autowired
    UserService userService;
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;

    @GetMapping("/")
    public String userPanel(Model model, Principal principal){
        User user = userService.findByLogin(principal.getName());

        model.addAttribute("user", user);
        model.addAttribute("posts",postService.getByUserId(user.getId()));
        Set<Post> comPosts = new HashSet<>();
        for(Comment comment : commentService.getByUserId(user.getId())){
            comPosts.add(comment.getPost());
        }
        model.addAttribute("comPosts", comPosts);
        return "userPanel";
    }

    @PostMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable int userId, Principal principal, Model model){
        boolean flag = principal.getName().equals(userService.findById(userId).getLogin());
        userService.delete(userId);
        if(flag){
            return "redirect:logout";
        }
        User user = userService.findByLogin(principal.getName());

        model.addAttribute("user", user);
        model.addAttribute("posts",postService.getByUserId(user.getId()));
        Set<Post> comPosts = new HashSet<>();
        for(Comment comment : commentService.getByUserId(user.getId())){
            comPosts.add(comment.getPost());
        }
        model.addAttribute("comPosts", comPosts);
        return "userPanel";
    }
}
