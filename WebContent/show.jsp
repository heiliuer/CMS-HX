<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hx.bean.News"%>
<%@page import="com.hx.bean.Sort"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>新闻展示</title>
<link rel="stylesheet" type="text/css" href="/static/list.css" />
</head>
<body>

	<%@include file="inc/top.jsp"%>

	<div id="main">
		<div class="wrap">
			<%@include file="inc/menu.jsp"%>
			<div id="rightList">
				<div id="path">
					您现在的位置：<a href="NewsServlet?action=selectNewsIndex">网站首页</a> > <a
						href="NewsServlet?action=selectNewsList&newsClassId=${newsClassId }">${thisSortName }</a>
					&gt; ${news.title}
				</div>
				<div id="listBox">
					<h1 id="title">${news.title}</h1>
					<div id="info">作者：${news.author} 发布时间：${news.createTime}</div>
					<div id="content">${news.content}</div>
				</div>

			</div>
			<div class="clear"></div>
		</div>
	</div>

	<%@include file="inc/bottom.jsp"%>
</body>
</html>
