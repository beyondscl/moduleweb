<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    request.setAttribute("basePath", basePath);
%>
<html>
<header>
    <style>
        * {
            text-align: center;
        }
    </style>
</header>
<body>
<a href="/user/jumpToMain"> go main </a>
<br>
<a href="/user/toLogin"> 请登录</a>
<br>
<div>
    <label>这是首页免登陆展示页面</label>
</div>
</body>
</html>