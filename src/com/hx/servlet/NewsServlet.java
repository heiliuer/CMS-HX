package com.hx.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hx.bean.BaseEntity;
import com.hx.bean.News;
import com.hx.bean.Sort;
import com.hx.dao.NewsDao;
import com.hx.dao.SortDao;
import com.hx.utils.Constants;
import com.hx.utils.StringUtils;

@WebServlet("/NewsServlet")
public class NewsServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		if (StringUtils.isEmpty(action)) {
			action = "selectNewsIndex";
		}

		NewsDao newsdao = DAOS.NEWSDAO;
		SortDao sortdao = DAOS.SORTDAO;

		if ("selectAll".equals(action)) {
			log("selectAll");
			// 所有新闻的集合
			ArrayList<News> listNews = new ArrayList<News>();
			listNews = newsdao.getNewsAll();
			request.setAttribute("listNews", listNews);

			// 所以分类的集合
			ArrayList<Sort> listSort = new ArrayList<Sort>();
			listSort = sortdao.getAllSort();
			request.setAttribute("listSort", listSort);

			// 没有新闻分类id传过去，直接设置为-1；
			request.setAttribute("newsClassId", -1);
			toPage("admin/newsMgr.jsp", request, response);
		} else if ("selectNewsBySortName".equals(action)) {
			log("selectNewsBySortName");
			int newsClassId = Integer.parseInt(request.getParameter("newsClassId"));
			// 所有新闻的集合
			ArrayList<News> listNews = new ArrayList<News>();
			listNews = newsdao.getNewsBySortName(newsClassId);
			request.setAttribute("listNews", listNews);

			// 所以分类的集合

			ArrayList<Sort> listSort = new ArrayList<Sort>();
			listSort = sortdao.getAllSort();
			request.setAttribute("listSort", listSort);

			// 传递新闻分类id，改进前台用户体验
			request.setAttribute("newsClassId", newsClassId);
			request.getRequestDispatcher("admin/newsMgr.jsp").forward(request, response);
		}
		// 首页新闻显示页面
		else if ("selectNewsIndex".equals(action)) {
			log("selectNewsIndex");
			// 所有新闻的集合

			// 所以分类的集合
			ArrayList<Sort> listSort = sortdao.getAllTopSort();
			request.setAttribute("listSort", listSort);

			// 权重分新闻
			listSort = sortdao.getAllSortOrderByWeightDesc();
			List<Map<String, Object>> sortNewsList = Lists.newArrayList();
			for (Sort sort : listSort) {
				ArrayList<News> listNews = newsdao.getNewsBySortName(sort.getId());
				Map<String, Object> map = Maps.newHashMap();
				map.put("sort", sort);
				map.put("news", listNews);
				sortNewsList.add(map);
				request.setAttribute("listNews", listNews);
			}

			request.setAttribute("sortNewsList", sortNewsList);

			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		// 新闻列表页面
		else if ("selectNewsList".equals(action)) {
			log("selectNewsList");
			int newsClassId = Integer.parseInt(request.getParameter("newsClassId"));
			// 所有新闻的集合
			ArrayList<News> listNews = new ArrayList<News>();
			listNews = newsdao.getNewsBySortName(newsClassId);
			request.setAttribute("listNews", listNews);

			// 所以分类的集合
			ArrayList<Sort> listSort = sortdao.getAllTopSort();
			request.setAttribute("listSort", listSort);

			// 所以子分类的集合
			// int newsClassId
			ArrayList<Sort> listSubSort = new ArrayList<Sort>();
			listSubSort = sortdao.getSubSortById(newsClassId);

			request.setAttribute("listSubSort", listSubSort);

			String thisSortName = sortdao.getSortById(newsClassId).getSortName();
			request.setAttribute("thisSortName", thisSortName);

			request.getRequestDispatcher("list.jsp").forward(request, response);
		}
		// 新闻列表页面
		else if ("selectNewsListSearch".equals(action)) {
			log("selectNewsListSearch");
			String newsClassIdStr = request.getParameter("newsClassId");
			if (StringUtils.isEmpty(newsClassIdStr)) {
				toErrotPage("缺少参数", request, response);
				return;
			}
			int newsClassId = Integer.parseInt(newsClassIdStr);
			String title = request.getParameter("title");

			// 所有新闻的集合
			ArrayList<News> listNews = new ArrayList<News>();
			listNews = newsdao.getNewsBySearch(newsClassId, title);
			request.setAttribute("listNews", listNews);

			// 所以分类的集合
			ArrayList<Sort> listSort = new ArrayList<Sort>();
			listSort = sortdao.getAllSort();
			request.setAttribute("listSort", listSort);

			// 所以子分类的集合
			// int newsClassId
			ArrayList<Sort> listSubSort = new ArrayList<Sort>();
			listSubSort = sortdao.getSubSortById(newsClassId);

			request.setAttribute("listSubSort", listSubSort);

			String thisSortName = sortdao.getSortById(newsClassId).getSortName();
			request.setAttribute("thisSortName", thisSortName);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} else if ("selectNewsShow".equals(action)) {
			log("selectNewsShow");
			int newsClassId = Integer.parseInt(request.getParameter("newsClassId"));
			request.setAttribute("newsClassId", newsClassId);
			int newsid = Integer.parseInt(request.getParameter("newsid"));
			// 获取指定id的新闻
			BaseEntity news = null;
			news = newsdao.getNewsById(newsid);
			request.setAttribute("news", news);

			// 所以分类的集合
			ArrayList<Sort> listSort = sortdao.getAllTopSort();
			request.setAttribute("listSort", listSort);

			// 所以子分类的集合
			// int newsClassId
			ArrayList<Sort> listSubSort = new ArrayList<Sort>();
			listSubSort = sortdao.getSubSortById(newsClassId);

			request.setAttribute("listSubSort", listSubSort);

			String thisSortName = sortdao.getSortById(newsClassId).getSortName();
			request.setAttribute("thisSortName", thisSortName);

			request.getRequestDispatcher("show.jsp").forward(request, response);
		} else if ("insertNews".equals(action)) {
			log("insertNews");
			News news = new News();
			int newsClassId = Integer.parseInt(request.getParameter("newsClassId"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String imgs = request.getParameter("imgs");
			// String author = request.getParameter("author");

			int newsType = Integer.parseInt(request.getParameter("newsType"));
			Date now = new Date();
			DateFormat df = DateFormat.getDateInstance();
			String nowtimes = df.format(now);
			news.setNewsClassId(newsClassId);
			news.setTitle(title);
			news.setContent(content);
			news.setNewsType(newsType);
			news.setCreateTime(nowtimes);
			news.setImgs(imgs);
			news.setAuthor((String) request.getSession().getAttribute(Constants.SESSION_STRING_USER_NAME));
			newsdao.insertNews(news);

			response.sendRedirect("SortServlet?action=newsAdd");

		} else if ("deleteNews".equals(action)) {
			log("deleteNews");
			int newsid = Integer.parseInt(request.getParameter("newsid"));
			newsdao.deleteNews(newsid);
			response.sendRedirect("NewsServlet?action=selectAll");
		} else if ("updateNews".equals(action)) {
			log("updateNews");
			int newsid = Integer.parseInt(request.getParameter("newsid"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int newsType = Integer.parseInt(request.getParameter("newsType"));
			int newsClassId = Integer.parseInt(request.getParameter("newsClassId"));

			News news = new News();
			news.setId(newsid);
			news.setTitle(title);
			news.setContent(content);
			news.setNewsType(newsType);
			news.setNewsClassId(newsClassId);
			news.setImgs(request.getParameter("imgs"));

			newsdao.updateNews(news);

			request.getRequestDispatcher("NewsServlet?action=selectAll").forward(request, response);

		}
		// 修改数据的静态页面
		else if ("updateNewsPage".equals(action)) {
			log("updateNewsPage");
			// 所以分类的集合
			ArrayList<Sort> listSort = new ArrayList<Sort>();
			listSort = sortdao.getAllSort();
			request.setAttribute("listSort", listSort);

			int newsid = Integer.parseInt(request.getParameter("newsid"));
			BaseEntity news = null;// = new News();
			news = newsdao.getNewsById(newsid);
			request.setAttribute("news", news);
			request.getRequestDispatcher("admin/newsMod.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
