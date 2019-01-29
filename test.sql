/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 29/01/2019 17:58:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_banner
-- ----------------------------
DROP TABLE IF EXISTS `tb_banner`;
CREATE TABLE `tb_banner` (
  `id`          bigint(255)  NOT NULL,
  `banner_url`  varchar(255) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `banner_name` varchar(255) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime(0)  NULL DEFAULT NULL,
  `status`      smallint(1)  NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
)
  ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_information
-- ----------------------------
DROP TABLE IF EXISTS `tb_information`;
CREATE TABLE `tb_information` (
  `id`            bigint(255) NOT NULL,
  `welcome_words` varchar(255) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci  NULL DEFAULT NULL,
  `address`       varchar(255) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci  NULL DEFAULT NULL,
  `telephone`     varchar(255) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci  NULL DEFAULT NULL,
  `slogan_CN`     varchar(255) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci  NULL DEFAULT NULL,
  `slogan_EN`     varchar(255) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci  NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
)
  ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_login
-- ----------------------------
DROP TABLE IF EXISTS `tb_login`;
CREATE TABLE `tb_login` (
  `id`       int(11)         NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_login
-- ----------------------------
INSERT INTO `tb_login`
VALUES (1,
        'e9e326d5f3b4741fe5967b5f9f3997e6275331ba18567ef9ef9e0e3a00e78371',
        '0661068b5223e423f7ce1e8e20202b5c320c5257d179e6e80cb5403b483fc2ec');

-- ----------------------------
-- Table structure for tb_logo
-- ----------------------------
DROP TABLE IF EXISTS `tb_logo`;
CREATE TABLE `tb_logo` (
  `id`           bigint(255) NOT NULL,
  `logo_name`    varchar(255) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `logo_uri`     varchar(255) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `company_name` varchar(255) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time`  datetime(0) NULL DEFAULT NULL,
  `status`       smallint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
)
  ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_sku
-- ----------------------------
DROP TABLE IF EXISTS `tb_sku`;
CREATE TABLE `tb_sku` (
  `id`          bigint(255)    NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `price`       decimal(10, 2) NULL     DEFAULT NULL
  COMMENT '价格',
  `sku_url`     varchar(255) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci   NULL     DEFAULT NULL
  COMMENT '路径',
  `sku_name`    varchar(255) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci   NULL     DEFAULT NULL
  COMMENT '名字',
  `sku_descr`   varchar(255) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci   NULL     DEFAULT NULL
  COMMENT '描述',
  `sku_type`    varchar(255) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci   NULL     DEFAULT NULL
  COMMENT '类型',
  `sku_size`    varchar(255) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci   NULL     DEFAULT NULL
  COMMENT '尺寸',
  `create_time` datetime(0)    NULL     DEFAULT NULL
  COMMENT '创建时间',
  `status`      smallint(1)    NULL     DEFAULT NULL
  COMMENT '状态：0下架：1上架',
  `sku_id`      varchar(255) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci   NULL     DEFAULT NULL
  COMMENT 'id',
  `cover`       int(1)         NULL     DEFAULT NULL
  COMMENT '是否为封面：0否：1是',
  PRIMARY KEY (`id`) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 24
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_sku
-- ----------------------------
INSERT INTO `tb_sku`
VALUES (1, 100.00, '/加工流程图.png', '测试', '仅供测试', '1', '100*200', '2019-01-29 10:23:18', 1, '10000', 1);
INSERT INTO `tb_sku`
VALUES (2, 100.00, '../static/temp/200x150.jpg', '测试', '仅供测试', '1', '100*200', '2019-01-16 13:45:34', 1, '10000', 0);
INSERT INTO `tb_sku`
VALUES (3, 100.00, '../static/temp/200x150.jpg', '测试', '仅供测试', '1', '100*200', '2019-01-16 13:45:34', 1, '10000', 0);
INSERT INTO `tb_sku`
VALUES (4, 100.00, '../static/temp/200x150.jpg', '测试', '仅供测试', '1', '100*200', '2019-01-16 13:45:34', 1, '10000', 0);
INSERT INTO `tb_sku`
VALUES (5, 100.00, '../static/temp/200x150.jpg', '测试', '仅供测试', '1', '100*200', '2019-01-16 13:45:34', 1, '10000', 0);
INSERT INTO `tb_sku`
VALUES (6, 100.00, '../static/temp/200x150.jpg', '测试', '仅供测试', '1', '100*200', '2019-01-16 13:45:34', 1, '10000', 0);
INSERT INTO `tb_sku`
VALUES (7, 100.00, '../static/temp/200x150.jpg', '测试', '仅供测试', '1', '100*200', '2019-01-16 13:45:34', 1, '10000', 0);
INSERT INTO `tb_sku`
VALUES (8, 100.00, '../static/temp/200x150.jpg', '测试', '仅供测试', '1', '100*200', '2019-01-16 13:45:34', 1, '10000', 0);
INSERT INTO `tb_sku`
VALUES (9, 100.00, '../static/temp/200x150.jpg', '测试', '仅供测试', '1', '100*200', '2019-01-16 13:45:34', 1, '10000', 0);
INSERT INTO `tb_sku`
VALUES (10, 100.00, '../static/temp/200x150.jpg', '测试', '仅供测试', '1', '100*200', '2019-01-16 13:45:34', 1, '10000', 0);
INSERT INTO `tb_sku`
VALUES (11, 100.00, '../static/temp/200x150.jpg', '测试', '仅供测试', '1', '100*200', '2019-01-16 13:45:34', 1, '10000', 0);
INSERT INTO `tb_sku`
VALUES (14, 100.00, '/加工流程图.png', '测试', '仅供测试', '1', '100*200', '2019-01-16 13:45:34', 1, '10000', 0);
INSERT INTO `tb_sku`
VALUES (24,
        12.00,
        '/加工配置流程.jpg',
        'ss',
        'aa',
        '12',
        'w',
        '2019-01-29 11:07:04',
        1,
        '572f5a8c0b1d44fda87999297eb0eda3',
        1);
INSERT INTO `tb_sku`
VALUES (25,
        12.00,
        '/加工配置流程.jpg',
        'ss',
        'aa',
        '12',
        'w',
        '2019-01-29 11:07:04',
        1,
        '572f5a8c0b1d44fda87999297eb0eda3',
        0);

-- ----------------------------
-- Table structure for tb_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_type`;
CREATE TABLE `tb_type` (
  `id`          bigint(255)  NOT NULL,
  `type_name`   varchar(255) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type_id`     int(255)     NULL DEFAULT NULL,
  `type_level`  int(255)     NULL DEFAULT NULL,
  `create_time` datetime(0)  NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
)
  ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
