/*
Navicat MySQL Data Transfer

Source Server         : mysql-local-root
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : hx-cms

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2016-05-19 23:25:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `newsClassId` int(11) NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `content` text,
  `imgs` text,
  `author` varchar(20) DEFAULT NULL COMMENT 'admin',
  `newsType` int(1) NOT NULL DEFAULT '0',
  `createTime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('67', '55', '我院将举行篮球比赛', ' 我院将举行篮球比赛，地点在东门小操场', 'files\\d8468202-a630-4e78-93bb-642147b58bc4.jpg', 'admin', '0', '2016-5-19');

-- ----------------------------
-- Table structure for sort
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sortName` varchar(50) DEFAULT NULL,
  `weight` int(11) NOT NULL DEFAULT '0',
  `sortLevel` int(11) NOT NULL DEFAULT '0' COMMENT '0 为一级分类，其他为各个分类id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sort
-- ----------------------------
INSERT INTO `sort` VALUES ('55', '学院首页', '4', '0');
INSERT INTO `sort` VALUES ('56', '学院概况', '0', '0');
INSERT INTO `sort` VALUES ('57', '师资队伍', '0', '0');
INSERT INTO `sort` VALUES ('58', '科学研究', '0', '0');
INSERT INTO `sort` VALUES ('59', '学生工作', '0', '0');
INSERT INTO `sort` VALUES ('60', '通知通告', '0', '55');
INSERT INTO `sort` VALUES ('61', '新闻', '1', '55');
INSERT INTO `sort` VALUES ('62', '学术动态', '0', '55');
INSERT INTO `sort` VALUES ('63', '学院简介', '0', '56');
INSERT INTO `sort` VALUES ('64', '领导班子', '0', '55');
INSERT INTO `sort` VALUES ('65', '机构设置', '0', '55');
INSERT INTO `sort` VALUES ('66', '队伍概况', '0', '57');
INSERT INTO `sort` VALUES ('67', '导师简介', '0', '57');
INSERT INTO `sort` VALUES ('68', '文章', '2', '58');
INSERT INTO `sort` VALUES ('69', '课题', '0', '58');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '用户名',
  `pass` varchar(100) NOT NULL COMMENT '密码',
  `logTime` int(5) NOT NULL DEFAULT '0',
  `privileges` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('-921014763', 'admin', 'admin', '0', '0');
