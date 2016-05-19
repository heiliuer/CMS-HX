package com.hx.bean;

public class Sort extends BaseEntity {
	private int id;
	private String sortName;
	private int sortLevel;

	// 权重
	private int weight;

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public int getSortLevel() {
		return sortLevel;
	}

	public void setSortLevel(int sortLevel) {
		this.sortLevel = sortLevel;
	}

	public String getCreateTableSql() {
		return "";
	}

	@Override
	public String getCreateSql() {
		return "CREATE TABLE IF NOT EXISTS `sort` (" + "  `id` int(11) NOT NULL AUTO_INCREMENT,"
				+ "  `sortName` varchar(50) DEFAULT NULL,"+ "  `weight` int(11) NOT NULL DEFAULT '0',"
				+ "  `sortLevel` int(11) NOT NULL DEFAULT '0' COMMENT '0 为一级分类，其他为各个分类id'," + "  PRIMARY KEY (`id`),"
				+ "  UNIQUE KEY `id` (`id`)" + ") ENGINE=MyISAM AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;";
	}

}
