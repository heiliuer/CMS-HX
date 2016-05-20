<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hx.bean.Sort"%>
<%@page import="com.hx.bean.News"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>新闻修改</title>
<link href="./css/reset.css" rel="stylesheet" type="text/css" />
<link href="./css/base.css" rel="stylesheet" type="text/css" />
<link href="./css/menu.css" rel="stylesheet" type="text/css" />
<link href="./css/applyEdit.css" rel="stylesheet" type="text/css" />

</head>
<body>

	<%@ include file="inc/menu.jsp"%>

	<table border="1">

		<tbody>
			<%
				News news = (News) request.getAttribute("news");
			%>
			<form method="post" action="NewsServlet?action=updateNews">
				<input name="newsid" type="hidden" value="<%=news.getId()%>" />
				<tr>
					<td>分类</td>
					<td><select name="newsClassId">
							<%
								ArrayList<Sort> listSort = (ArrayList<Sort>) request.getAttribute("listSort");
								for (int i = 0; i < listSort.size(); i++) {
									Sort sort = listSort.get(i);
							%>
							<%
								//如果分类的id 和读取出来的id一致， 则优先显示它
									if (sort.getId() == news.getNewsClassId()) {
							%>
							<option name="newsClassId" value="<%=sort.getId()%>" selected><%=sort.getSortName()%></option>
							<%
								//先生剩余的分类
									} else {
							%>
							<option name="newsClassId" value="<%=sort.getId()%>"><%=sort.getSortName()%></option>
							<%
								}
							%>


							<%
								}
							%>
					</select></td>
				</tr>
				<tr>
					<td>标题</td>
					<td><input type="hidden" class="imgs" name="imgs" /><input
						name="title" type="text" value="<%=news.getTitle()%>" /></td>
				</tr>
				<tr>
					<td>内容</td>
					<td><textarea style="width: 400px; height: 300px;"
							name="content" type="text" /><%=news.getContent()%></textarea>
				</tr>
				<tr>
					<td>属性</td>
					<td><select name="newsType">
							<%
								//如果新闻类型为0
								if (news.getNewsType() == 0) {
							%>
							<option value="0" selected>普通新闻</option>
							<option value="1">热点新闻</option>
							<option value="2">公告新闻</option>
							<%
								}
							%>

							<%
								//如果新闻类型为1
								if (news.getNewsType() == 1) {
							%>
							<option value="0">普通新闻</option>
							<option value="1" selected>热点新闻</option>
							<option value="2">公告新闻</option>
							<%
								}
							%>

							<%
								//如果新闻类型为2
								if (news.getNewsType() == 2) {
							%>
							<option value="0">普通新闻</option>
							<option value="1">热点新闻</option>
							<option value="2" selected>公告新闻</option>
							<%
								}
							%>


					</select></td>
				</tr>
				<tr>
					<td>操作</td>
					<td><input type="submit" value="保存修改" /></td>

				</tr>
			</form>
			<tr data-file-upload data-imgs-input=".imgs">
				<td>图片</td>
				<td>
					<div data-previews>
						<c:forEach items="${news.imgUrlList}" var="img">
							<div data-img="${img }">
								<img src="${img }" class="preview"><span class="del">x</span>
							</div>
						</c:forEach>

					</div> <input type="file" />
				</td>
			</tr>


		</tbody>
	</table>

</body>

</html>
