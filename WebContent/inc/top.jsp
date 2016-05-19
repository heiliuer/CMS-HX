<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.hx.bean.Sort"%>
<link href="static/index.css" rel="stylesheet">
<link href="static/body.css" rel="stylesheet">
<link href="_sitegray/_sitegray_d.css" rel="stylesheet" type="text/css">
<link href="static/index.vsb.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/static/xinwen.css">
<link rel="stylesheet" type="text/css" href="/static/_sitegray_d.css" />
<link rel="stylesheet" type="text/css" href="/static/xinwenwang.vsb.css" />
<link href="static/imagechangenews.css" rel="stylesheet" type="text/css">
<div id="top" class="top x_all">
	<div class="x_center">
		<div class="top_left"></div>
		<div class="top_right"></div>
	</div>
	<div style="background: #f1f1f1; height: 1px; width: 100%;"></div>
	<div class="daohang_bac">
		<div class="x_center">
			<div class="daohang">
				<ul>
					<li id="xygk"><a href="/">首页</a></li>
					<c:forEach items="${listSort}" var="sort">
						<li id="xygk"><a
							href="NewsServlet?action=selectNewsList&newsClassId=${sort.id }">${sort.sortName }</a>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>