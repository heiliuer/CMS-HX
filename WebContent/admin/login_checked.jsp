<%@page import="com.hx.utils.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Boolean isLogined = (Boolean) session.getAttribute(Constants.SESSION_BOOL_LOGINED);
	if (isLogined == null || !isLogined) {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
%>