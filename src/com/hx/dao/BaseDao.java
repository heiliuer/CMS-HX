package com.hx.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.hx.utils.JdbcConnectionUtils;

public abstract class BaseDao {

	private Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public BaseDao() {
		connection = JdbcConnectionUtils.getConnection();
	}

	public void release() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
