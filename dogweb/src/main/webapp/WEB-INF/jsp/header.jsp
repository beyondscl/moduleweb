<%@ page import="com.bird.Util.MySeesion" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/19 0019
  Time: 下午 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    request.setAttribute("basePath", basePath);
    MySeesion.setToken(request);

%>
<base href="${basePath}">
<link rel="stylesheet" href="/assets/css/theme.css">
<!--公共的js记住顺序和相互依赖关系-->
<!--自定义js在页尾加载-->
<script type="text/javascript"
        src="/assets/js/jquery-3.2.1.min.js"></script>
