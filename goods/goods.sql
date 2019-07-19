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
-- Table structure for lz_goods
-- ----------------------------
DROP TABLE IF EXISTS `lz_goods`;
CREATE TABLE `lz_goods` (
  `GOOD_ID` varchar(32) NOT NULL COMMENT '商品编号',
  `GOOD_NAME` varchar(32) DEFAULT NULL COMMENT '商品名称',
  `GOOD_PRICE` decimal(10,4) DEFAULT NULL COMMENT '商品价格',
  `GOOD_STOCK` int(11) DEFAULT NULL COMMENT '商品库存',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` varchar(20) DEFAULT NULL COMMENT '修改时间',
  `STATUS` char(1) NOT NULL COMMENT '状态\r\n            1、正常状态\r\n            2、下架状态',
  PRIMARY KEY (`GOOD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of lz_goods
-- ----------------------------
INSERT INTO `lz_goods` VALUES ('a48d34e35c7744f19e564a471a6a2c66', '牛仔裤', '99.0000', '100', '2019-07-15 15:30:14', null, '0');
