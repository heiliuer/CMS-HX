package com.hx.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hx.bean.Sort;
import com.hx.dao.SortDao;
import com.hx.servlet.BaseServlet.DAOS;

@WebServlet("/SortServlet")
public class SortServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		System.out.println(action);

		SortDao sortdao = DAOS.SORTDAO;
		if ("insertSort".equals(action)) {
			Sort sort = new Sort();
			String sortName = request.getParameter("sortName");
			int sortLevel = Integer.parseInt(request.getParameter("sortLevel"));
			sort.setSortLevel(sortLevel);
			sort.setSortName(sortName);
			sort.setWeight(Integer.parseInt(request.getParameter("weight")));

			sortdao.insertSort(sort);

			response.sendRedirect("SortServlet?action=selectAll");

		} else if ("deleteSort".equals(action)) {
			int sortid = Integer.parseInt(request.getParameter("sortid"));
			sortdao.deleteSort(sortid);
			response.sendRedirect("SortServlet?action=selectAll");

		} else if ("updateSort".equals(action)) {
			Sort sort = new Sort();
			int sortid = Integer.parseInt(request.getParameter("sortid"));
			int sortLevel = Integer.parseInt(request.getParameter("sortLevel"));
			String sortName = request.getParameter("sortName");

			sort.setId(sortid);
			sort.setSortLevel(sortLevel);
			sort.setSortName(sortName);
			sort.setWeight(Integer.parseInt(request.getParameter("weight")));

			sortdao.updateSort(sort);

			response.sendRedirect("SortServlet?action=selectAll");
		} else if ("selectAll".equals(action)) {
			// Sort sort = null;

			ArrayList<Sort> listSort = new ArrayList<Sort>();
			listSort = sortdao.getAllSort();
			request.setAttribute("listSort", listSort);
			// request.RequestDispatcher("/admin/sortMgr.jsp").forward(request,
			// response);
			request.getRequestDispatcher("admin/sortMgr.jsp").forward(request, response);
		} else if ("newsAdd".equals(action)) {
			// Sort sort = null;

			ArrayList<Sort> listSort = new ArrayList<Sort>();
			listSort = sortdao.getAllSort();
			request.setAttribute("listSort", listSort);
			// request.RequestDispatcher("/admin/sortMgr.jsp").forward(request,
			// response);
			request.getRequestDispatcher("admin/newsAdd.jsp").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
