/*
 Navicat Premium Data Transfer

 Source Server         : WMS
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : rm-bp1fzd1242pyngli0uo.mysql.rds.aliyuncs.com
 Source Database       : db_b2b

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 03/19/2018 17:27:20 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` bigint(20) NOT NULL  auto_increment,
  `img_path` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `college` varchar(255) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `permission` int(2) DEFAULT NULL,
  `sign_date` datetime(6) DEFAULT NULL,
  `tag` int(2) DEFAULT NULL,
  `u_name` varchar(255) DEFAULT NULL,
  `u_no` bigint(20) DEFAULT NULL,
  `detail` text,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;


-- ----------------------------
--  Table structure for `question`
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `question_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bad_num` bigint(10) DEFAULT 0,
  `content` text,
  `course_id` bigint(20) DEFAULT NULL,
  `good_num` bigint(10) DEFAULT 0,
  `is_cream` tinyint(1) DEFAULT 0,
  `is_resource` tinyint(1) DEFAULT 0,
  `level` bigint(2) DEFAULT 1,
  `level_desc` varchar(255) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  `person_name` varchar(255) DEFAULT NULL,
  `question_desc` text,
  `techer_id` bigint(20) DEFAULT NULL,
  `techer_name` varchar(255) DEFAULT '暂未回复',
  `time` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `visit_num` bigint(20) DEFAULT 0,
  `course_name` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;


-- ----------------------------
--  Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bad_num` bigint(20) DEFAULT '0',
  `content` text,
  `course_id` bigint(20) DEFAULT NULL,
  `good_num` bigint(20) DEFAULT '0',
  `person_id` bigint(20) DEFAULT NULL,
  `person_name` varchar(255) DEFAULT NULL,
  `question_id` bigint(20) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;





