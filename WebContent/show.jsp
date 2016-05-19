<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hx.bean.News"%>
<%@page import="com.hx.bean.Sort"%>
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>${news.title}</title>
<link rel="stylesheet" type="text/css" href="/static/list.css" />
</head>
<body>

	<%@include file="inc/top.jsp"%>

	<div id="main">
		<div class="wrap">
			<%@include file="inc/menu.jsp"%>
			<div id="rightList">
				<div id="path">
					当前的位置：<a
						href="NewsServlet?action=selectNewsList&newsClassId=${newsClassId }">${thisSortName }</a>
				</div>
				<div id="listBox">
					<h3 id="title">${news.title}</h3>
					<div id="info">作者：${news.author} 发布时间：${news.createTime}</div>
					<div id="content">
						<div>
							<c:forEach items="${news.imgUrlList}" var="img">
								<img width="100%" style="padding: 0.5em 0;" src="/${img }" />
							</c:forEach>
						</div>
						<p>${news.content}</p>
					</div>
				</div>

			</div>
			<div class="clear"></div>
		</div>
	</div>

	<%@include file="inc/bottom.jsp"%>
</body>
</html>
