<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hx.bean.News"%>
<%@page import="com.hx.bean.Sort"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>操作失败</title>
</head>
<body>
	<h5 align="center"><%=request.getAttribute("error_msg") %></h5>
	<h6 align="center"> <a href="/">回到首页</a></h6>
</body>
</html>
