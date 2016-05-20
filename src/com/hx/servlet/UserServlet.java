package com.hx.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hx.bean.User;
import com.hx.dao.UserDao;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UserDao userdao = new UserDao();

	@Override
	public void destroy() {
		super.destroy();
		userdao.release();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");

		if ("insertUser".equals(action)) {
			User user = new User();
			String name = request.getParameter("name");
			String pass = request.getParameter("pass");
			int privileges = Integer.parseInt(request.getParameter("privileges"));
			user.setName(name);
			user.setPass(pass);
			user.setPrivileges(privileges);
			userdao.insertUser(user);
			request.getRequestDispatcher("UserServlet?action=selectAll").forward(request, response);
		} else if ("deleteUser".equals(action)) {
			int userid = Integer.parseInt(request.getParameter("userid"));
			userdao.deleteUser(userid);
			request.getRequestDispatcher("UserServlet?action=selectAll").forward(request, response);
		} else if ("updateUser".equals(action)) {
			User user = new User();
			int userid = Integer.parseInt(request.getParameter("userid"));
			String name = request.getParameter("name");
			String pass = request.getParameter("pass");
			int logTime = Integer.parseInt(request.getParameter("logTime"));
			int privileges = Integer.parseInt(request.getParameter("privileges"));
			user.setId(userid);
			user.setName(name);
			user.setPass(pass);
			user.setLogTime(logTime);
			user.setPrivileges(privileges);
			userdao.updateUser(user);
			request.getRequestDispatcher("UserServlet?action=selectAll").forward(request, response);
		} else if ("selectAll".equals(action)) {
			ArrayList<User> listUser = new ArrayList<User>();
			listUser = userdao.getAllUser();
			request.setAttribute("listUser", listUser);
			request.getRequestDispatcher("admin/userMgr.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
