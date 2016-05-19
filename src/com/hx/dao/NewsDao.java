package com.hx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hx.bean.BaseEntity;
import com.hx.bean.News;

public class NewsDao {
	private Connection conn;
	private Statement s;
	private ResultSet rs = null;
	private PreparedStatement ps;
	private DbConn dbconn = new DbConn();

	public ArrayList<News> getNewsAll() {
		conn = dbconn.getConn();
		String sql = "select * from news order by id desc  ";
		ArrayList<News> al = new ArrayList<News>();
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			ps = conn.prepareStatement(sql);
			News news = null;
			while (rs.next()) {
				news = new News();
				setNews(news);
				al.add(news);
			}
			return al;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<News> getNewsBySortName(int newsClassId) {
		conn = dbconn.getConn();
		String sql = "select * from news  where newsClassId=" + newsClassId + " order by id desc ";
		ArrayList<News> al = new ArrayList<News>();
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		try {
			ps = conn.prepareStatement(sql);
			News news = null;
			while (rs.next()) {

				news = new News();
				setNews(news);
				news.setImgs(rs.getString("imgs"));
				al.add(news);

			}
			return al;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<News> getNewsBySearch(int newsClassId, String title) {
		conn = dbconn.getConn();
		String sql = "select * from news where newsClassId=" + newsClassId;
		ArrayList<News> al = new ArrayList<News>();
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		try {
			ps = conn.prepareStatement(sql);
			News news = null;
			while (rs.next()) {

				news = new News();
				setNews(news);
				news.setImgs(rs.getString("imgs"));
				al.add(news);

			}
			return al;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	public boolean insertNews(News news) {
		conn = dbconn.getConn();

		String sql = "insert into news (id, newsClassId, title, content, author, newsType, createTime,imgs) values (?, ?, ?, ?, ? ,? ,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, news.getId());
			ps.setInt(2, news.getNewsClassId());
			ps.setString(3, news.getTitle());
			ps.setString(4, news.getContent());
			ps.setString(5, news.getAuthor());
			ps.setInt(6, news.getNewsType());
			ps.setString(7, news.getCreateTime());
			ps.setString(8, news.getImgs());

			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			dbconn.freeConn(conn, ps, null);
		}
		return false;
	}

	public boolean updateNews(News news) {
		conn = dbconn.getConn();

		String sql = "update news set newsClassId = ?, title= ?, content = ?,  newsType=? ,imgs=?  where id =? ";
		try {

			ps = conn.prepareStatement(sql);

			ps.setInt(1, news.getNewsClassId());
			ps.setString(2, news.getTitle());
			ps.setString(3, news.getContent());
			// ps.setString(4, news.getAuthor());
			ps.setInt(4, news.getNewsType());

			ps.setString(5, news.getImgs());
			ps.setInt(6, news.getId());

			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			dbconn.freeConn(conn, ps, null);
		}
		return false;
	}

	public boolean deleteNews(int newsid) {
		conn = dbconn.getConn();

		String sql = "delete from news where id =? ";
		try {

			ps = conn.prepareStatement(sql);

			ps.setInt(1, newsid);

			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			dbconn.freeConn(conn, ps, null);
		}
		return false;
	}

	public BaseEntity getNewsById(int newsid) {
		conn = dbconn.getConn();
		String sql = "select * from news where id = " + newsid;
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			News news = new News();
			if (rs.next()) {
				setNews(news);
			}
			return news;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	private void setNews(News news) throws SQLException {
		news.setId(rs.getInt("id"));
		news.setAuthor(rs.getString("author"));
		news.setContent(rs.getString("content"));
		news.setCreateTime(rs.getString("createTime"));
		news.setNewsType(rs.getInt("newsType"));
		news.setNewsClassId(rs.getInt("newsClassId"));
		news.setTitle(rs.getString("title"));
		news.setImgs(rs.getString("imgs"));
	}
}
