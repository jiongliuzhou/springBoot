/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : base

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-07-19 15:00:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for oauth_access_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(250) NOT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(128) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('GoodsSystem', null, '123456', 'user_info', 'authorization_code', 'http://127.0.0.1:8081/good/login', null, null, null, null, 'user_info');
INSERT INTO `oauth_client_details` VALUES ('MemberSystem', null, '123456', 'user_info', 'authorization_code,password', 'http://127.0.0.1:8080/member/login', null, null, null, null, 'user_info');

-- ----------------------------
-- Table structure for oauth_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `PERMISSION_ID` varchar(32) NOT NULL COMMENT '权限编号',
  `PERMISSION_NAME` varchar(32) DEFAULT NULL COMMENT '权限名称',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` varchar(20) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`PERMISSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统权限表';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', 'MEMBER', null, null);

-- ----------------------------
-- Table structure for sys_permission_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission_resource`;
CREATE TABLE `sys_permission_resource` (
  `ID` varchar(32) NOT NULL COMMENT '编号',
  `RESOURCE_ID` varchar(32) NOT NULL COMMENT '资源编号',
  `PERMISSION_ID` varchar(32) NOT NULL COMMENT '权限编号',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` varchar(20) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源关系表';

-- ----------------------------
-- Records of sys_permission_resource
-- ----------------------------

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `RESOURCE_ID` varchar(32) NOT NULL,
  `RESOURCE_NAME` varchar(32) DEFAULT NULL,
  `URL` varchar(256) DEFAULT NULL,
  `PARENT_RESOURCE_ID` varchar(32) DEFAULT NULL,
  `CREATE_TIME` varchar(20) DEFAULT NULL,
  `UPDATE_TIME` varchar(20) DEFAULT NULL,
  `STATUS` char(1) NOT NULL,
  PRIMARY KEY (`RESOURCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统资源表';

-- ----------------------------
-- Records of sys_resource
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ROLE_ID` varchar(32) NOT NULL COMMENT '角色编号',
  `ROLE_NAME` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` varchar(20) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'ADMIN', null, null);

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `ID` varchar(32) NOT NULL COMMENT '编号',
  `ROLE_ID` varchar(32) NOT NULL COMMENT '角色编号',
  `PERMISSION_ID` varchar(32) NOT NULL COMMENT '权限编号',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` varchar(20) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关系表';

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1', '1', null, null);
INSERT INTO `sys_role_permission` VALUES ('2', '1', '2', null, null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `USER_ID` varchar(32) NOT NULL COMMENT '编号',
  `USERNAME` varchar(32) DEFAULT NULL COMMENT '用户名',
  `PASSWORD` varchar(32) DEFAULT NULL COMMENT '密码',
  `PHONE` varchar(11) DEFAULT NULL COMMENT '手机号',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` varchar(20) DEFAULT NULL COMMENT '修改时间',
  `STATUS` char(1) NOT NULL COMMENT '状态',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'admin', '18512451452', null, null, '0');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `ID` varchar(32) NOT NULL COMMENT '编号',
  `USER_ID` varchar(32) NOT NULL COMMENT '用户编号',
  `ROLE_ID` varchar(32) NOT NULL COMMENT '角色编号',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` varchar(20) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1', null, null);
