package com.hx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hx.dao.UserDao;
import com.hx.utils.Constants;
import com.hx.utils.StringUtils;

@WebServlet("/login")
public class LoginServlet extends ServletBase {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String exit = request.getParameter("exit");
		if (!StringUtils.isEmpty(exit)) {
			request.getSession().removeAttribute(Constants.SESSION_BOOL_LOGINED);
			response.sendRedirect("/");
			return;
		}

		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		if (StringUtils.isEmpty(name) || StringUtils.isEmpty(pass)) {
			System.err.print("账户或者密码为空");
			toErrotPage("账户或者密码为空", request, response);
			return;
		}

		UserDao userdao = new UserDao();
		if (userdao.checkUser(name, pass)) {
			request.getSession().setAttribute(Constants.SESSION_BOOL_LOGINED, true);
			response.sendRedirect("NewsServlet?action=selectAll");
		} else {
			toErrotPage("账户或者密码不正确", request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
