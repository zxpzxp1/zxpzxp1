/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : sjyz

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2022-03-02 17:05:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(20) DEFAULT NULL COMMENT '用户姓名',
  `email` varchar(60) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(60) DEFAULT NULL,
  `auth_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '认证状态（0：未认证 1：认证中 2：认证成功 -1：认证失败）',
  `status` tinyint(3) NOT NULL DEFAULT '1' COMMENT '状态（0：锁定 1：正常）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0' COMMENT '逻辑删除(1:已删除，0:未删除)',
  PRIMARY KEY (`id`),
  KEY `uk_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';
