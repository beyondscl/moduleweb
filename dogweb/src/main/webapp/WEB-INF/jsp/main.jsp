<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/11
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<html>
<head>
    <script type="text/javascript">
    </script>
</head>
<body>
main.jsp
<h5>传送门</h5>
<a href="/articleAction/toAdd?token=${token}">添加博客</a><br>
<a href="/articleAction/index?token=${token}">博客首页</a>
</body>
</html>
