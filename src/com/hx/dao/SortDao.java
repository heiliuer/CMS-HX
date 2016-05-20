package com.hx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hx.bean.Sort;

public class SortDao extends BaseDao {

	public ArrayList<Sort> query(String sql) {
		Connection conn = getConnection();
		ArrayList<Sort> al = new ArrayList<Sort>();
		try {
			Statement s = getConnection().createStatement();
			ResultSet rs = s.executeQuery(sql);
			conn.prepareStatement(sql);
			while (rs.next()) {
				al.add(new Sort().setFromResultSet(rs));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return al;
	}

	public ArrayList<Sort> getAllSortOrderByWeightDesc() {
		return query("select * from sort order by weight desc ");
	}

	public ArrayList<Sort> getAllSort() {
		return query("select * from sort order by id ");
	}

	public ArrayList<Sort> getAllTopSort() {
		return query("select * from sort where sortLevel=0");
	}

	public Sort getSortById(int newsClassId) {
		String sql = "select * from sort where id=" + newsClassId;
		try {
			Statement s = getConnection().createStatement();
			ResultSet rs = s.executeQuery(sql);
			Sort sort = new Sort();
			if (rs.next()) {
				sort.setFromResultSet(rs);
			}
			return sort;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Sort> getSubSortById(int newsClassId) {
		return query("select * from sort where sortLevel=" + newsClassId);
	}

	public boolean insertSort(Sort sort) {
		String sql = "insert into sort ( id ,sortName, sortLevel,weight) values (?, ?, ?,?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, sort.getId());
			ps.setString(2, sort.getSortName());
			ps.setInt(3, sort.getSortLevel());
			ps.setInt(4, sort.getWeight());
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateSort(Sort sort) {
		String sql = "update sort set sortName = ?, sortLevel= ? ,weight= ? where id =? ";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, sort.getSortName());
			ps.setInt(2, sort.getSortLevel());
			ps.setInt(3, sort.getWeight());
			ps.setInt(4, sort.getId());
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteSort(int sortid) {
		String sql = "delete from sort where id = ? ";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, sortid);
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
