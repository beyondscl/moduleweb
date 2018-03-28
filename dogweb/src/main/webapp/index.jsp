<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>牛虻的博客</title>
    <link rel="stylesheet" href="assets/plug/skipper/skippr.css">
    <link rel="stylesheet"
          href="assets/plug/font-awesome-4.7.0/css/font-awesome.min.css">
    <link href="assets/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/layout.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="assets/css/common.css">

    <script src="assets/js/jquery-1.10.2.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>

    <script src="assets/plug/skipper/skippr.min.js"></script>
    <script src="assets/js/common.js"></script>


</head>
<body>

<!--導航欄-->
<nav class="navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed"
                    data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1"
                    aria-expanded="false">
                <span class="sr-only">請選擇</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">GADFLY.SITE</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">首頁<span
                        class="sr-only">(current)</span></a></li>
                <!--<li><a href="#">咨詢</a></li>-->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"
                       role="button" aria-haspopup="true" aria-expanded="false">關於我們
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">光輝歲月</a></li>
                        <li><a href="#">故鄉</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">一生所愛</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">海闊天空</a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control"
                           placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">查詢</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">費用管理</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"
                       role="button" aria-haspopup="true" aria-expanded="false">用戶管理
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#"></a></li>
                        <li><a href="/user/toLogin">登录</a></li>
                        <li><a href="/user/jumpToMain">去主页</a></li>
                        <li><a href="#">基本信息</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">安全退出</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div class="container">
    <div id="div-skippr" class="div-skippr">
        <div style="background-image: url(assets/images/test2.jpg)"></div>
        <div style="background-image: url(assets/images/test3.jpg)"></div>
        <div style="background-image: url(assets/images/test4.jpg)"></div>
        <div style="background-image: url(assets/images/test5.jpg)"></div>
    </div>

</div>
<div class="footer">
    <div class="tag">
        <a href="javascript:;">简体</a>
        <a href="javascript:;">繁体</a>
        <a href="javascript:;">English</a>
        <a href="javascript:;">常见问题</a>
    </div>
    <div class="cop">
        <p>Copyright © 2017-2018 gadfly.site 版权所有</p>
    </div>
</div>
<!--模态框-->
<div class="b-modal-con" id="b-modal-con">
</div>
<div class="b-modal" id="b-modal">
    <div class="b-modal-data">听说你喜欢模态框?
    </div>
    <div class="b-button">
        <input type="button" value="确定" class="button radius b-modal-btn"
               id="b-cancel"/>
    </div>
</div>
</body>
</html>