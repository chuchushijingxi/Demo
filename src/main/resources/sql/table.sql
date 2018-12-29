/*
 Navicat Premium Data Transfer

 Source Server         : myself
 Source Server Type    : MySQL
 Source Server Version : 50642
 Source Host           : 45.77.134.105:3306
 Source Schema         : mySelf

 Target Server Type    : MySQL
 Target Server Version : 50642
 File Encoding         : 65001

 Date: 29/12/2018 15:01:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tJobConfig
-- ----------------------------
DROP TABLE IF EXISTS `tJobConfig`;
CREATE TABLE `tJobConfig`  (
  `sID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sThirdID` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sDesc` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sFullEntity` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sGroupName` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sCronTime` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dLastTime` datetime(0) NOT NULL,
  `nLastNumber` decimal(20, 0) NOT NULL,
  `sStatusID` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dCreateTime` datetime(0) NOT NULL,
  `sCreateUser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dLastUpdateTime` datetime(0) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `lastLoginTime` datetime(0) DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
