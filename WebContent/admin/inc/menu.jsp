<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<script src="/static/jquery-1.7.1.min.js"></script>
<script src="/js/app.js"></script>
<ul id="menu">

    <li><a href="./SortServlet?action=newsAdd">添加新闻</a></li>
    <li><a href="./NewsServlet?action=selectAll">新闻管理</a></li>

    <li><a href="./SortServlet?action=selectAll">分类管理</a></li>

    <li><a href="./UserServlet?action=selectAll">用户管理</a></li>
    <li style="float: right; padding-right: 0;"><a href="./">首页</a></li>
    <li style="float: right;"><a href="/login?exit=1">退出</a></li>
    <li style="float: right;"><a href="">密码更改</a></li>
    <li style="float: right;"></li>
    <%@ include file="../login_checked.jsp" %>
</ul>