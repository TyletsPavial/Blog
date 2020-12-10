
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <div>
        <% String result = (String) request.getAttribute("result");
        if(result != null) {%>
        <%= result %> <br>
         <% } %>
        <form action="/registration" method="post">
            firstname<input type="text" name="firstName"><br>
            lastname<input type="text" name="lastName"><br>
            sign<input type="text" name="sign"><br>
            login<input type="text" name="login"><br>
            password<input type="password" name="password"><br>
            <input type="submit" value="submit">
        </form>
    </div>
</body>
</html>
