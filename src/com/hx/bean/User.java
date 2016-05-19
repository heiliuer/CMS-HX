package com.hx.bean;

public class User extends BaseEntity {
	private int id;
	private String name;
	private String pass;
	private int logTime;
	private int privileges;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getLogTime() {
		return logTime;
	}

	public void setLogTime(int logTime) {
		this.logTime = logTime;
	}

	public int getPrivileges() {
		return privileges;
	}

	public void setPrivileges(int privileges) {
		this.privileges = privileges;
	}

	@Override
	public String getCreateSql() {
		return "CREATE TABLE IF NOT EXISTS `user` (" + 
				"  `id` int(11) NOT NULL AUTO_INCREMENT," + 
				"  `name` varchar(20) NOT NULL COMMENT '用户名'," + 
				"  `pass` varchar(100) NOT NULL COMMENT '密码'," + 
				"  `logTime` int(5) NOT NULL DEFAULT '0'," + 
				"  `privileges` int(11) NOT NULL DEFAULT '0'," + 
				"  PRIMARY KEY (`id`)," + 
				"  UNIQUE KEY `id` (`id`)" + 
				") ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;";
	}

}
