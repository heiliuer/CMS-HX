package com.hx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hx.bean.Sort;

public class SortDao {
	private Connection conn;
	private Statement s;
	private ResultSet rs = null;
	private PreparedStatement ps;
	private DbConn dbconn = new DbConn();

	private void setSort(Sort sort) {
		try {
			sort.setId(rs.getInt("id"));
			sort.setSortName(rs.getString("sortName"));
			sort.setSortLevel(rs.getInt("sortLevel"));
			sort.setWeight(rs.getInt("weight"));
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public ArrayList<Sort> getAllSortOrderByWeightDesc() {
		conn = dbconn.getConn();
		String sql = "select * from sort order by weight desc ";
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			ArrayList<Sort> listSort = new ArrayList<Sort>();

			while (rs.next()) {
				Sort sort = new Sort();
				setSort(sort);
				listSort.add(sort);
			}
			return listSort;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<Sort> getAllSort() {
		conn = dbconn.getConn();
		String sql = "select * from sort order by id ";
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			ArrayList<Sort> listSort = new ArrayList<Sort>();

			while (rs.next()) {
				Sort sort = new Sort();
				setSort(sort);
				listSort.add(sort);
			}
			return listSort;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<Sort> getAllTopSort() {
		conn = dbconn.getConn();
		String sql = "select * from sort where sortLevel=0";
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			ArrayList<Sort> listSort = new ArrayList<Sort>();

			while (rs.next()) {
				Sort sort = new Sort();
				setSort(sort);
				listSort.add(sort);
			}
			return listSort;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<Sort> getSortById(int newsClassId) {
		conn = dbconn.getConn();
		String sql = "select * from sort where id=" + newsClassId;
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			ArrayList<Sort> listSort = new ArrayList<Sort>();

			while (rs.next()) {
				Sort sort = new Sort();
				setSort(sort);
				listSort.add(sort);
			}
			return listSort;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<Sort> getSubSortById(int newsClassId) {
		conn = dbconn.getConn();
		// String sql = "select id, sortName, sortLevel from sort order by id ";
		String sql = "select * from sort where sortLevel=" + newsClassId;
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			ArrayList<Sort> listSort = new ArrayList<Sort>();

			while (rs.next()) {
				Sort sort = new Sort();
				setSort(sort);
				listSort.add(sort);
			}
			return listSort;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	public boolean insertSort(Sort sort) {
		conn = dbconn.getConn();

		String sql = "insert into sort ( id ,sortName, sortLevel,weight) values (?, ?, ?,?)";
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, sort.getId());
			ps.setString(2, sort.getSortName());
			ps.setInt(3, sort.getSortLevel());
			ps.setInt(4, sort.getWeight());

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

	public boolean updateSort(Sort sort) {
		conn = dbconn.getConn();
		String sql = "update sort set sortName = ?, sortLevel= ? ,weight= ? where id =? ";
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, sort.getSortName());
			ps.setInt(2, sort.getSortLevel());
			ps.setInt(3, sort.getWeight());
			ps.setInt(4, sort.getId());

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

	public boolean deleteSort(int sortid) {
		conn = dbconn.getConn();
		String sql = "delete from sort where id = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sortid);
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
}
