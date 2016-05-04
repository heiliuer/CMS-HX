package com.hx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ServletBase extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void toPage(String jsp, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void toErrotPage(String msg, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("error_msg", msg);
		toPage("error.jsp", request, response);
	}

	protected void toErrotPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		toErrotPage("操作失败", request, response);
	}

	public static void log(Object... strs) {
		StringBuilder sBuilder = new StringBuilder();
		if (strs != null) {
			for (Object o : strs) {
				sBuilder.append(o == null ? "null" : o.toString());
			}
		}
		sBuilder.append('\n');
		System.out.println(sBuilder.toString());
	}

	public static void main(String[] args) {
		log("dd", 23);
		log();
	}

}
