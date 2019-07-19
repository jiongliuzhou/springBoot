/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : lz

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-07-19 15:04:21
*/

SET FOREIGN_KEY_CHECKS=0;


-- ----------------------------
-- Table structure for lz_member
-- ----------------------------
DROP TABLE IF EXISTS `lz_member`;
CREATE TABLE `lz_member` (
  `MEMBER_ID` varchar(32) NOT NULL COMMENT '会员编号',
  `MEMBER_NAME` varchar(32) DEFAULT NULL COMMENT '会员名称',
  `PHONE` char(11) DEFAULT NULL COMMENT '手机号',
  `EMAIL` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `MEMBER_PASSWORD` varchar(20) DEFAULT NULL COMMENT '密码',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` varchar(20) DEFAULT NULL COMMENT '修改时间',
  `STATUS` char(1) NOT NULL COMMENT '状态\r\n            1、正常状态\r\n            2、删除状态',
  PRIMARY KEY (`MEMBER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员表';

-- ----------------------------
-- Records of lz_member
-- ----------------------------
INSERT INTO `lz_member` VALUES ('611a9d0c92c94fb1b68714a905368fbf', '会员', '18512451457', '6325147@qq.com', null, '2019-07-15 14:46:55', '2019-07-15 14:49:23', '0');
