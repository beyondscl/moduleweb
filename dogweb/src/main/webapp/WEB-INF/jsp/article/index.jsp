<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    request.setAttribute("basePath", basePath);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>文章列表</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
</head>
<body>
<table>
    <tr>
        <th>选择</th>
        <th>标题</th>
        <th>内容</th>
        <th>创建时间</th>
    </tr>
    <c:forEach items="${data}" var="item">
        <tr>
            <td><input type="checkbox" value="${item.id}"></td>
            <td>${item.title}</td>
            <td>${item.content}</td>
            <td>${item.createTime}</td>
        </tr>
    </c:forEach>
</table>
<div>
    <a href="?">上一页</a>
    当前第${page.currentPage}页，共${page.pageCount}页，共${page.rowCount}条数据
    <a href="?">下一页</a>
</div>
</body>
</html>