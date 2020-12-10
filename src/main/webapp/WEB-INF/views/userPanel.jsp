<%@ page import="java.util.List" %>
<%@ page import="com.blog.model.Post" %>
<%@ page import="com.blog.model.User" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panel</title>
</head>
<body>
    <div>
        <%User user = (User) request.getAttribute("user");%>
        <%= user.getSign()%>
    </div>
    <div> Posts</div>
    <div> <% List<Post> posts = (List<Post>) request.getAttribute("posts");
    for(Post post : posts){%>
        <div><a href="/post/<%=post.getId()%>"><%= post.getTitle() %></a></div>
    <% }%>
    </div>
    <div> Posts with my comment(s)</div>
    <div> <% Set<Post> comPosts = (Set<Post>) request.getAttribute("comPosts");
        for(Post post : comPosts){%>
        <div><a href="/post/<%=post.getId()%>"><%= post.getTitle() %></a></div>
        <% }%>
    </div>
    <div>
        <form action="/deleteUser/<%=user.getId()%>" name="deleteUser" method="post">
            <input type="submit">
        </form>
    </div>
</body>
</html>
