<%@ page import="com.blog.model.Post" %>
<%@ page import="com.blog.model.Comment" %>
<%@ page import="java.util.List" %>
<%@ page import="com.blog.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post</title>
</head>
<body>
    <% Post post = (Post) request.getAttribute("post");%>
    <% List<Comment> comments = (List<Comment>) request.getAttribute("comments");%>
<div>
    <%= post.getTitle()%><br>
    <%= post.getText()%><br>
    <%= post.getUser().getSign()%><br>
    <%User user = (User) request.getAttribute("user"); %>

    <% if(user != null && (user.getId() == post.getUser().getId() || user.getRole().getRole().equals("ADMIN"))){ %>
        <form action="/deletePost/<%=post.getId()%>" method="post">
            <input type="submit" value="delete post">
        </form>
    <% } %>
</div>
    <div>
        <% for(Comment comment : comments) { %>
            <%= comment.getUser().getSign() %><br>
            <%= comment.getText() %><br>
            <% if(user != null && (user.getId() == comment.getUser().getId() || user.getRole().getRole().equals("ADMIN"))){ %>
                <form action="/post/<%= post.getId()%>/deleteComment/<%=comment.getId()%>" method="post">
                    <input type="submit" value="delete comment">
                </form>
            <% } %>
        <% } %>
    </div>
    <div>
        <% if (request.getUserPrincipal() != null){%>
        <form action="/post/<%= post.getId()%>/addComment" method="post" name="commentForm">
            <input type="text" name="text">
            <input type="submit" value="comment">
        </form>
        <% } %>
    </div>

</body>
</html>
