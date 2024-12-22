<%--
  Created by IntelliJ IDEA.
  User: JasonYell
  Date: 2024/9/5
  Time: 2:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <title>Title</title>
</head>
<body>
    ${tips}
    <h3>登录页面</h3>
    <form action="user/login" method="post">
        <p>账号：<input type="text" name="userName"/> </p>
        <p>密码：<input type="password" name="userPwd"/> </p>
        <p><input type="submit" value="submit"></p>
    </form>
</body>
</html>
