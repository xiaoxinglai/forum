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


-- ----------------------------
--  Records of `course`
-- ----------------------------
BEGIN;
INSERT INTO `course` VALUES ('1', 'test', '测试测试');
COMMIT;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', '软件学院', '男', '1', '2018-03-19 19:30:56.000000', '1', '赖晓星', '14202116', '赖晓星软件学院21班', '123456');
COMMIT;



-- ----------------------------
--  Records of `question`
-- ----------------------------
BEGIN;
INSERT INTO `question` VALUES ('1','1','测试测试问题1','1','12','1','1','1','初级','1','赖晓星','测试问题1','1','赖晓星','2018-03-13 19:52:12','测试问题1','12','c语言');
INSERT INTO `question` VALUES ('2','1','测试测试问题2','1','12','1','1','1','初级','1','赖晓星','测试问题2','1','赖晓星','2018-03-14 19:52:12','测试问题2','123','c语言');
INSERT INTO `question` VALUES ('3','1','测试测试问题3','1','12','1','1','1','初级','1','赖晓星','测试问题3','1','赖晓星','2018-03-15 19:52:12','测试问题3','1233','c语言');

COMMIT;
-- ----------------------------
--  Records of `comment`
-- ----------------------------
BEGIN;
INSERT INTO `comment` VALUES ('1', '0', '好评好评', '1', '10', '1', '赖晓星', '1', '2018-03-21 11:58:35');
COMMIT;


