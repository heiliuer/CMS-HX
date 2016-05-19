<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hx.bean.News"%>
<%@page import="com.hx.bean.Sort"%>
<div id="leftMenu">
	<c:forEach items="${listSubSort }" var="subSort">
		<ul class="menuList">
			<li><a
				href="/NewsServlet?action=selectNewsList&newsClassId=${subSort.id }">${subSort.sortName}</a></li>
		</ul>
	</c:forEach>
	<%-- <form class="searchBox" method="post"
		action="NewsServlet?action=selectNewsListSearch">
		<select style="width: 100px;" name="newsClassId">
			<option value="">请选择</option>
			<c:forEach items="${listSort }" var="sort">
				<option value="${sort.id}">${sort.sortName}</option>
			</c:forEach>
		</select> <input style="width: 100px;" name="newsTitle" type="text" /> <input
			type="submit" value="搜索" />
	</form> --%>
</div>