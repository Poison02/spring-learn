/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80028
Source Host           : localhost:3306
Source Database       : mybatis-new

Target Server Type    : MYSQL
Target Server Version : 80028
File Encoding         : 65001

Date: 2023-06-15 16:19:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_car
-- ----------------------------
DROP TABLE IF EXISTS `t_car`;
CREATE TABLE `t_car` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `car_num` varchar(255) DEFAULT NULL COMMENT '汽车编号',
  `brand` varchar(255) DEFAULT NULL COMMENT '汽车品牌',
  `guide_price` decimal(10,2) DEFAULT NULL COMMENT '厂家指导价',
  `produce_time` char(10) DEFAULT NULL COMMENT '生产日期',
  `car_type` varchar(255) DEFAULT NULL COMMENT '汽车类型，燃油车，电车，氢能源',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of t_car
-- ----------------------------
INSERT INTO `t_car` VALUES ('1', '1001', '宝马x7', '30.00', '2022-6-15', '燃油车');
INSERT INTO `t_car` VALUES ('2', '1002', '奔驰AMG', '100.00', '2022-6-15', '氢能源');
INSERT INTO `t_car` VALUES ('4', '1003', '丰田霸道', '30.00', '2000-10-11', '燃油车');
INSERT INTO `t_car` VALUES ('5', '1003', '丰田霸道', '30.00', '2000-10-11', '燃油车');
INSERT INTO `t_car` VALUES ('6', '1003', '丰田霸道', '30.00', '2000-10-11', '燃油车');
