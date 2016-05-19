<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hx.bean.Sort"%>
<!doctype html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>新闻添加</title>
<link href="./css/reset.css" rel="stylesheet" type="text/css" />
<link href="./css/base.css" rel="stylesheet" type="text/css" />
<link href="./css/menu.css" rel="stylesheet" type="text/css" />
<link href="./css/applyEdit.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<%@ include file="inc/menu.jsp"%>

	<table border="1">

		<tbody>
			<form method="post" action="NewsServlet?action=insertNews">
				<tr>
					<td>分类</td>
					<td><select name="newsClassId">
							<%
								ArrayList<Sort> listSort = (ArrayList<Sort>) request.getAttribute("listSort");
								for (int i = 0; i < listSort.size(); i++) {
									Sort sort = listSort.get(i);
							%>
							<option name="newsClassId" value="<%=sort.getId()%>"><%=sort.getSortName()%></option>
							<%
								}
							%>
					</select></td>
				</tr>
				<tr>
					<td>标题</td>
					<td><input type="hidden" class="imgs" name="imgs" /><input name="title"
						type="text" value="" /></td>
				</tr>
				<tr>
					<td>内容</td>
					<td><textarea style="width: 400px; height: 300px;"
							name="content" type="text" value="" /> </textarea></td>
				</tr>
			<tr>
				<td>属性</td>
				<td><select name="newsType">
						<option value="0">普通新闻</option>
						<option value="1">热点新闻</option>
						<option value="2">公告新闻</option>
				</select></td>
			</tr>
			<tr>
				<td>操作</td>
				<td><input type="submit" value="提交" /></td>

			</tr>
			</form>
			<tr data-file-upload data-imgs-input=".imgs">
				<td>图片</td>
				<td>
					<div data-previews></div> <input type="file" />
				</td>
			</tr>
		</tbody>
	</table>

</body>
</html>
