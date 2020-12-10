<%@ page import="com.blog.model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserList</title>
</head>
<body>
    <% List<User> users = (List<User>) request.getAttribute("users");%>
    <% for(User user : users) {%>
        <div> <a href="/AdminPanel/Users/<%= user.getId() %>/"><%= user.getSign() %></a></div>
    <% } %>
</body>
</html>
