<%--
Created by IntelliJ IDEA.
User: leng tingxue
Date: 2017/5/9
Time: 9:38
To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    request.setAttribute("basePath", basePath);
    request.setAttribute("path", path);
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
    <base href="${basePath}">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <%--<link rel="shortcut icon" href="images/erlang.ico" type="image/x-icon"/>--%>
    <link rel="stylesheet" type="text/css" href="assets/css/style.css"/>
    <script src="assets/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        Cufon.replace('h1', {textShadow: '1px 1px #fff'});
        Cufon.replace('h2', {textShadow: '1px 1px #fff'});
        Cufon.replace('h3', {textShadow: '1px 1px #000'});
        Cufon.replace('.back');
    </script>
</head>
<body>
<div class="wrapper">
    <div class="">
        <div id="form_wrapper" class="form_wrapper">
            <form class="login active"
                  action="/user/login"
                  method="post"
                  enctype="application/x-www-form-urlencoded">
                <h3>Login</h3>
                <div>
                    <label>用户名:</label>
                    <input type="text" name="name"/>
                    <span class="error">This is an error</span>
                </div>
                <div>
                    <label>密&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
                    <input type="password" name="password"/>
                    <span class="error">This is an error</span>
                </div>
                <div class="bottom">
                    <input type="submit" value="Login"/>
                    <div class="clear"></div>
                </div>
            </form>
        </div>
        <div class="clear"></div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        var $form_wrapper = $('#form_wrapper'),
                $currentForm = $form_wrapper.children('form.active'),
                $linkform = $form_wrapper.find('.linkform');

        $form_wrapper.children('form').each(function (i) {
            var $theForm = $(this);
            if (!$theForm.hasClass('active'))
                $theForm.hide();
            $theForm.data({
                width: $theForm.width(),
                height: $theForm.height()
            });
        });

        setWrapperWidth();
        $linkform.bind('click', function (e) {
            var $link = $(this);
            var target = $link.attr('rel');
            $currentForm.fadeOut(400, function () {
                $currentForm.removeClass('active');
                $currentForm = $form_wrapper.children('form.' + target);
                $form_wrapper.stop()
                        .animate({
                            width: $currentForm.data('width') + 'px',
                            height: $currentForm.data('height') + 'px'
                        }, 500, function () {
                            $currentForm.addClass('active');
                            $currentForm.fadeIn(400);
                        });
            });
            e.preventDefault();
        });

        function setWrapperWidth() {
            $form_wrapper.css({
                width: $currentForm.data('width') + 'px',
                height: $currentForm.data('height') + 'px'
            });
        }
    });
</script>
</body>
</html>