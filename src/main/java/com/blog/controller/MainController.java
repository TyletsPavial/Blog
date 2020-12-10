package com.blog.controller;

import com.blog.model.Comment;
import com.blog.model.Post;
import com.blog.model.User;
import com.blog.service.comment.CommentService;
import com.blog.service.post.PostService;
import com.blog.service.role.RoleService;
import com.blog.service.user.UserDetailServiceImpl;
import com.blog.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    RoleService roleService;
    @Autowired
    UserDetailServiceImpl userDetailService;
    @Autowired
    UserService userService;
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;

    @GetMapping("/")
    public String main(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> collect = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        model.addAttribute("auth", collect);
        model.addAttribute("posts", postService.getAll());
        return "main";
    }

    @GetMapping("/post/{postId}")
    public String getPost(@PathVariable int postId, Model model, Principal principal){
        if(principal != null){
            User user = userService.findByLogin(principal.getName());
            model.addAttribute("user", user);
        }
        model.addAttribute("post", postService.getById(postId));
        model.addAttribute("comments",commentService.getByPostId(postId));
        return "post";
    }

    @PostMapping("/post/{postId}/addComment")
    public String addComment(@ModelAttribute("commentForm") Comment comment, Principal principal,
                             @PathVariable int postId, Model model){
        Post post = postService.getById(postId);
        User user = userService.findByLogin(principal.getName());
        comment.setUser(user);
        comment.setPost(post);
        commentService.save(comment);
        model.addAttribute("user", user);
        model.addAttribute("post", post);
        model.addAttribute("comments",commentService.getByPostId(postId));
        return "post";
    }

    @PostMapping("/post/{postId}/deleteComment/{commentId}")
    public String deleteComment(@PathVariable int postId, @PathVariable int commentId, Model model, Principal principal){
        commentService.delete(commentId);
        Post post = postService.getById(postId);
        if(principal != null){
            User user = userService.findByLogin(principal.getName());
            model.addAttribute("user", user);
        }
        model.addAttribute("post", post);
        model.addAttribute("comments",commentService.getByPostId(postId));
        return "post";
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute User user, Model model){
        user.setRole(roleService.getById(2));
        if(userDetailService.save(user)){
            model.addAttribute("result","You are registered");
        }
        else{
            model.addAttribute("result","This login has already existed, change login");
        }
        return "registration";
    }
}
