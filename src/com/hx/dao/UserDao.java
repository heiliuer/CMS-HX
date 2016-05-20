package com.hx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hx.bean.User;

public class UserDao extends BaseDao {

	public ArrayList<User> query(String sql) {
		Connection conn = getConnection();
		ArrayList<User> al = new ArrayList<User>();
		try {
			Statement s = getConnection().createStatement();
			ResultSet rs = s.executeQuery(sql);
			conn.prepareStatement(sql);
			while (rs.next()) {
				al.add(new User().setFromResultSet(rs));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return al;
	}

	public ArrayList<User> getAllUser() {
		return query("select * from user");
	}

	public boolean insertUser(User user) {
		Connection conn = getConnection();
		String sql = "insert into user ( id ,name, pass, privileges ,logTime) values (?, ?, ?, ?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPass());
			ps.setInt(4, user.getPrivileges());
			ps.setInt(5, user.getLogTime());
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateUser(User user) {
		Connection conn = getConnection();
		String sql = "update user set name = ?, pass= ?,logTime=?,privileges=? where id =? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPass());
			ps.setInt(3, user.getLogTime());
			ps.setInt(4, user.getPrivileges());
			ps.setInt(5, user.getId());
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteUser(int userid) {
		Connection conn = getConnection();
		String sql = "delete from user where id = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkUser(String name, String pass) {
		Connection conn = getConnection();
		String sql = "select * from user where name = ? and pass = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pass);
			if (ps.executeQuery().first()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
