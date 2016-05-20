package com.hx.servlet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.hx.bean.News;
import com.hx.bean.Sort;
import com.hx.bean.User;
import com.hx.dao.UserDao;
import com.hx.utils.JdbcConnectionUtils;

@WebListener
public class CmsListener implements ServletContextListener {
	public CmsListener() {
	}

	public void contextInitialized(ServletContextEvent arg0) {
		initTables();
		initAdminUser();
	}

	private void initTables() {
		Connection connection = JdbcConnectionUtils.getConnection();
		System.out.println("检查新建表");
		try {
			String createSql = new News().getCreateSql();
			System.out.println(createSql);
			connection.createStatement().execute(createSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			String createSql = new Sort().getCreateSql();
			System.out.println(createSql);
			connection.createStatement().execute(createSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			String createSql = new User().getCreateSql();
			System.out.println(createSql);
			connection.createStatement().execute(createSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void initAdminUser() {
		UserDao userdao = new UserDao();
		ArrayList<User> allUser = userdao.getAllUser();
		System.out.println("检查账户列表");
		if (allUser == null || allUser.size() == 0) {
			System.out.println("新建默认账户admin,admin");
			User user = new User();
			user.setName("admin");
			user.setPass("admin");
			user.setId((int) System.currentTimeMillis());
			userdao.insertUser(user);
		}
		userdao.release();
	}

	public void contextDestroyed(ServletContextEvent arg0) {
	}

}
