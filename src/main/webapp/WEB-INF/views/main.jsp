<%@ taglib prefix="security" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="com.blog.model.Post" %>
<%@ page import="java.util.Collection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Blog</title>
</head>
<body>
    <div>
        <% Collection<String> auth = (Collection<String>) request.getAttribute("auth");
            if(auth.contains("ADMIN")) {%>
            <a href="/AdminPanel/">Admin Panel</a>
        <%}
        else {
            if(auth.contains("USER")){ %>
                <a href="/account/">Account Panel</a>
            <% }
            else {%>
                <security:form action="/" method="POST">
                    <input class="input-style" type="text" name="login" placeholder="Логин"/>
                    <br>
                    <input class="input-style" type="password" name="password" placeholder="Пароль"/>
                    <br>
                    <input name="submit" class="myButton" type="submit" value="Войти"/>
                </security:form>
                <a href="/registration">Registration</a>
            <%}%>
        <%}%>

    </div>
    <div>
        <% List<Post> posts =(List<Post>) request.getAttribute("posts"); %>
        <% if(posts != null){ %>
        <% for(Post post : posts){ %>
            <div>
                <a href="/post/<%=post.getId()%>"><%= post.getTitle()%></a><br>
                <%= post.getUser().getSign()%>
            </div>
        <%}%>
        <%}%>
    </div>
</body>
</html>
