<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="/css/upload.css" rel="stylesheet" type="text/css" />
<script src="/js/jquery2.2.min.js"></script>
<script src="/js/app.js"></script>
<ul id="menu">

	<li><a href="./SortServlet?action=newsAdd">添加新闻</a></li>
	<li><a href="./NewsServlet?action=selectAll">新闻管理</a></li>
	<li><a href="./SortServlet?action=selectAll">分类管理</a></li>
	<li><a href="./UserServlet?action=selectAll">用户管理</a></li>


	<li style="float: right; padding-right: 0;"><a
		href="/login?exit=1">登出</a></li>
	<li style="float: right;"><a target="_blank" href="./">首页</a></li>
	<!-- <li style="float: right;"><a href="">密码更改</a></li> -->
	<%@ include file="../login_checked.jsp"%>
</ul>