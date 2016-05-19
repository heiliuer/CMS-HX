<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hx.bean.News"%>
<%@page import="com.hx.bean.Sort"%>
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>新闻管理</title>
<link href="./css/reset.css" rel="stylesheet" type="text/css" />
<link href="./css/base.css" rel="stylesheet" type="text/css" />
<link href="./css/menu.css" rel="stylesheet" type="text/css" />
<link href="./css/applyEdit.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<%@ include file="inc/menu.jsp"%>
	<%
		/*获得分类集*/ ArrayList<Sort> listSort = (ArrayList<Sort>) request.getAttribute("listSort");
	%>
	<div style="width: 950px; margin: 10px auto;">
		<form id="formSelectCls" method="post" action="NewsServlet?action=selectNewsBySortName">
			<select name="newsClassId">
				<%
					int newsClassId = (Integer) request.getAttribute("newsClassId");

					for (int i = 0; i < listSort.size(); i++) {
						Sort sort = listSort.get(i);
				%>

				<%
					if ((newsClassId == -1) || (sort.getId() != newsClassId)) {
				%>
				<option name="newsClassId" value="<%=sort.getId()%>"><%=sort.getSortName()%></option>
				<%
					} else {
				%>
				<option name="newsClassId" value="<%=sort.getId()%>" selected><%=sort.getSortName()%></option>
				<%
					}
				%>

				<%
					}
				%>
			</select>
		</form>
	</div>
	
	<script type="text/javascript">
		$("#formSelectCls").change(function(){
			$(this).submit();
		})
	</script>

	<table border="1">
		<thead>
			<th>新闻分类</th>
			<th>新闻标题</th>
			<th>作者</th>
			<th>创建时间</th>
			<th>新闻属性</th>
			<th>操作</th>
		</thead>
		<tbody>

			<%
				ArrayList<News> listNews = (ArrayList<News>) request.getAttribute("listNews");
				for (int i = 0; i < listNews.size(); i++) {
					News news = listNews.get(i);
			%>
			<tr>
				<input name="sortid" type="hidden" value="<%=news.getId()%>" />
				<td>
					<%
						//=news.getNewsClassId()
					%> <%
 	for (int j = 0; j < listSort.size(); j++) {
 			Sort sort = listSort.get(j);
 			if (sort.getId() == news.getNewsClassId()) {
 %>
					<p><%=sort.getSortName()%></p> <%
 	}
 		}
 %>


				</td>
				<td><%=news.getTitle()%></td>

				<td><%=news.getAuthor()%></td>
				<td><%=news.getCreateTime()%></td>
				<td>
					<%
						if (news.getNewsType() == 0) {
					%> 普通新闻 <%
						}
					%> <%
 	if (news.getNewsType() == 1) {
 %> <span style="color: #A86918;">焦点新闻</span> <%
 	}
 %> <%
 	if (news.getNewsType() == 2) {
 %> <span style="color: red;">公告新闻</span> <%
 	}
 %>

				</td>


				<td><a
					href="NewsServlet?action=updateNewsPage&newsid=<%=news.getId()%>">修改</a>
					| <a href="NewsServlet?action=deleteNews&newsid=<%=news.getId()%>">删除</a></td>

			</tr>
			<%
				}
			%>


		</tbody>
	</table>



</body>

</html>
