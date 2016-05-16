package com.hx.servlet;

import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.hx.bean.User;
import com.hx.dao.UserDao;

@WebListener
public class CmsListener implements ServletContextListener {
	public CmsListener() {
	}

	public void contextInitialized(ServletContextEvent arg0) {
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
	}

	public void contextDestroyed(ServletContextEvent arg0) {
	}

}
