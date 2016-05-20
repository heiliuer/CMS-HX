package com.hx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hx.dao.NewsDao;
import com.hx.dao.SortDao;
import com.hx.dao.UserDao;
import com.hx.utils.Status;

public abstract class BaseServlet extends HttpServlet {

	public static class DAOS {
		public static UserDao USERDAO = new UserDao();
		public static SortDao SORTDAO = new SortDao();
		public static NewsDao NEWSDAO = new NewsDao();
	}

	private static final long serialVersionUID = 1L;

	protected void toPage(String jsp, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void toJson(HttpServletResponse response, Status status) {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(new Gson().toJson(status));
		} catch (IOException e) {
			e.printStackTrace();
		}
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

}
