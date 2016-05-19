<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hx.bean.Sort"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>分类管理</title>
<link href="./css/reset.css" rel="stylesheet" type="text/css" />
<link href="./css/base.css" rel="stylesheet" type="text/css" />
<link href="./css/menu.css" rel="stylesheet" type="text/css" />
<link href="./css/applyEdit.css" rel="stylesheet" type="text/css" />

</head>
<body>

	<%@ include file="inc/menu.jsp"%>

	<table border="1">
		<thead>
			<th>分类名称</th>
			<th>父级分类</th>
			<th>权重</th>
			<th>操作</th>
		</thead>
		<tbody>

			<c:forEach items="${listSort }" var="sort">
				<tr>
					<form method="post" action="SortServlet?action=updateSort">
						<input name="sortid" type="hidden" value="${sort.id }" />
						<td><input name="sortName" type="text"
							value="${sort.sortName }" /></td>

						<td><select name="sortLevel">
								<option value="0" ${sort.sortLevel!=0?"":"selected='selected'"}>无父级</option>
								<c:forEach items="${listSort }" var="psort">
									<c:if test="${psort.sortLevel==0&&psort.id!=sort.id}">
									<option value="${psort.id }"
										${sort.sortLevel!=psort.id?"":"selected='selected'"}>${psort.sortName }</option>
									</c:if>
								</c:forEach>
						</select></td>
						<td><input name="weight" type="number"
							value="${sort.weight }" /></td>
						<td><input name="submit" type="submit" value="修改" /> | <a
							href="SortServlet?action=deleteSort&sortid=${sort.id }">删除</a></td>
					</form>
				</tr>

			</c:forEach>


			<tr>
				<form method="post" action="SortServlet?action=insertSort">

					<td><input name="sortName" type="text" value="" /></td>
					<td><select name="sortLevel">
							<option value="0">无父级</option>
							<c:forEach items="${listSort }" var="sort">
								<c:if test="${sort.sortLevel==0}">
									<option value="${sort.id }">${sort.sortName }</option>
								</c:if>
							</c:forEach>
					</select></td>
					<td><input name="weight" type="number" value="0" /></td>
					<td><input name="submit" type="submit" value="添加" /></td>
				</form>
			</tr>

		</tbody>
	</table>

</body>

</html>
