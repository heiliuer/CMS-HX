package com.hx.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

public class News extends BaseEntity {
	private int id;
	private int newsClassId;
	private String title;
	private String content;
	private String author;
	private String imgs;
	private String files;
	private int newsType;

	public List<String> getImgList() {
		if (!Strings.isNullOrEmpty(imgs)) {
			return Lists.newArrayList(imgs.split(","));
		}
		return Lists.newArrayList();
	}

	public List<String> getImgUrlList() {
		if (!Strings.isNullOrEmpty(imgs)) {
			imgs = imgs.replace('\\', '/');
			return Lists.newArrayList(imgs.split(","));
		}
		return Lists.newArrayList();
	}

	public String getImgs() {
		return imgs;
	}

	public void setImgs(String imgs) {
		this.imgs = imgs;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	String createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNewsClassId() {
		return newsClassId;
	}

	public void setNewsClassId(int newsClassId) {
		this.newsClassId = newsClassId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNewsType() {
		return newsType;
	}

	public void setNewsType(int newsType) {
		this.newsType = newsType;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String getCreateSql() {
		return "CREATE TABLE IF NOT EXISTS  `news` (" + "  `id` int(11) NOT NULL AUTO_INCREMENT,"
				+ "  `newsClassId` int(11) NOT NULL," + "  `title` varchar(50) DEFAULT NULL," + "  `content` text,"
				+ "  `imgs` text," + "  `author` varchar(20) DEFAULT NULL COMMENT 'admin',"
				+ "  `newsType` int(1) NOT NULL DEFAULT '0'," + "  `createTime` varchar(50) DEFAULT NULL,"
				+ "  PRIMARY KEY (`id`)," + "  UNIQUE KEY `id` (`id`)"
				+ ") ENGINE=MyISAM AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;";
	}

	@Override
	public News setFromResultSet(ResultSet rs) throws SQLException {
		this.setId(rs.getInt("id"));
		this.setAuthor(rs.getString("author"));
		this.setContent(rs.getString("content"));
		this.setCreateTime(rs.getString("createTime"));
		this.setNewsType(rs.getInt("newsType"));
		this.setNewsClassId(rs.getInt("newsClassId"));
		this.setTitle(rs.getString("title"));
		this.setImgs(rs.getString("imgs"));
		return this;
	}

}
