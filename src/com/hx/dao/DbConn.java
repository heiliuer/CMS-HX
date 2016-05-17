package com.hx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hx.utils.DbConfig;

public class DbConn {
	public Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			try {
				conn = DriverManager.getConnection(DbConfig.url, DbConfig.user, DbConfig.password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void freeConn(Connection conn, Statement s, ResultSet rs) {
		try {
			if (conn != null) {

				conn.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (s != null) {
				s.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
