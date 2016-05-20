package com.hx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.hx.bean.News;

public class NewsDao extends BaseDao {

	public ArrayList<News> getNewsAll() {
		return query("select * from news order by id desc");
	}

	public ArrayList<News> query(String sql) {
		Connection conn = getConnection();
		ArrayList<News> al = new ArrayList<News>();
		try {
			Statement s = getConnection().createStatement();
			ResultSet rs = s.executeQuery(sql);
			conn.prepareStatement(sql);
			while (rs.next()) {
				al.add(new News().setFromResultSet(rs));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return al;
	}

	public ArrayList<News> getNewsBySortName(int newsClassId) {
		return query("select * from news  where newsClassId=" + newsClassId + " order by id desc ");
	}

	public ArrayList<News> getNewsBySearch(int newsClassId, String title) {
		return query("select * from news where newsClassId=" + newsClassId);
	}

	public boolean insertNews(News news) {
		Connection conn = getConnection();
		String sql = "insert into news (id, newsClassId, title, content, author, newsType, createTime,imgs) values (?, ?, ?, ?, ? ,? ,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
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
		}
		return false;
	}

	public boolean updateNews(News news) {
		Connection conn = getConnection();
		String sql = "update news set newsClassId = ?, title= ?, content = ?,  newsType=? ,imgs=?  where id =? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, news.getNewsClassId());
			ps.setString(2, news.getTitle());
			ps.setString(3, news.getContent());
			ps.setInt(4, news.getNewsType());
			ps.setString(5, news.getImgs());
			ps.setInt(6, news.getId());
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteNews(int newsid) {
		Connection conn = getConnection();
		String sql = "delete from news where id =? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, newsid);
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public News getNewsById(int newsid) {
		String sql = "select * from news where id = " + newsid;
		try {
			Statement s = getConnection().createStatement();
			ResultSet rs = s.executeQuery(sql);
			News news = new News();
			if (rs.next()) {
				news.setFromResultSet(rs);
			}
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
