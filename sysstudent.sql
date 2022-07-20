/*
 Navicat MySQL Data Transfer

 Source Server         : lh
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : sysstudent

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 29/12/2021 18:26:07
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admininfo
-- ----------------------------
DROP TABLE IF EXISTS `admininfo`;
CREATE TABLE `admininfo`  (
  `aid` int NOT NULL,
  `aname` varchar(4) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `apwd` varchar(12) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `aage` int NOT NULL,
  `asex` varchar(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `agrade` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `amajor` varchar(8) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `aclass` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`aid`) 
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admininfo
-- ----------------------------
INSERT INTO `admininfo` VALUES (1, '张三', 'admin', 30, '男', '2019级', '软件工程', '1班');

-- ----------------------------
-- Table structure for computerroom
-- ----------------------------
DROP TABLE IF EXISTS `computerroom`;
CREATE TABLE `computerroom`  (
  `crname` varchar(4) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `craddress` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `crtype` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`crname`) 
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of computerroom
-- ----------------------------
INSERT INTO `computerroom` VALUES ('A308', '格致楼3楼靠南', '上课机房');
INSERT INTO `computerroom` VALUES ('A310', '格致楼3楼靠南', '上课机房');
INSERT INTO `computerroom` VALUES ('A312', '格致楼3楼靠南', '上课机房');
INSERT INTO `computerroom` VALUES ('A315', '格致楼3楼靠南', '上课机房');
INSERT INTO `computerroom` VALUES ('A317', '格致楼3楼靠南', '上课机房');
INSERT INTO `computerroom` VALUES ('A401', '格致楼4楼靠南', '上课机房');
INSERT INTO `computerroom` VALUES ('B301', '格致楼3楼靠西', '值班室');
INSERT INTO `computerroom` VALUES ('C205', '格致楼2楼靠北', '上课机房');
INSERT INTO `computerroom` VALUES ('C301', '格致楼3楼靠北', '上课机房');
INSERT INTO `computerroom` VALUES ('C302', '格致楼3楼靠东', '值班室');
INSERT INTO `computerroom` VALUES ('C303', '格致楼3楼靠北', '上课机房');
INSERT INTO `computerroom` VALUES ('C305', '格致楼3楼靠北', '上课机房');
INSERT INTO `computerroom` VALUES ('C307', '格致楼3楼靠北', '上课机房');
INSERT INTO `computerroom` VALUES ('C309', '格致楼3楼靠北', '上课机房');
INSERT INTO `computerroom` VALUES ('C403', '格致楼4楼靠北', '上课机房');
INSERT INTO `computerroom` VALUES ('C407', '格致楼4楼靠北', '上课机房');
INSERT INTO `computerroom` VALUES ('C409', '格致楼4楼靠北', '值班室');
INSERT INTO `computerroom` VALUES ('C414', '格致楼4楼靠北', '上课机房');

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment`  (
  `eid` int NOT NULL AUTO_INCREMENT,
  `ename` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `emoney` int NOT NULL,
  `ecomputerroom` varchar(4) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `enumber` int NOT NULL,
  PRIMARY KEY (`eid`) 
) ENGINE = InnoDB AUTO_INCREMENT = 76 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES (1, '空调', 2000, 'A317', 2);
INSERT INTO `equipment` VALUES (2, '空调', 2000, 'A310', 2);
INSERT INTO `equipment` VALUES (3, '空调', 2000, 'A312', 2);
INSERT INTO `equipment` VALUES (4, '空调', 2000, 'A315', 2);
INSERT INTO `equipment` VALUES (5, '空调', 2000, 'A308', 2);
INSERT INTO `equipment` VALUES (6, '电脑主机', 2000, 'A317', 60);
INSERT INTO `equipment` VALUES (7, '电脑主机', 2000, 'A310', 60);
INSERT INTO `equipment` VALUES (8, '电脑主机', 2000, 'A312', 60);
INSERT INTO `equipment` VALUES (9, '电脑主机', 2000, 'A315', 60);
INSERT INTO `equipment` VALUES (10, '电脑主机', 2000, 'A308', 60);
INSERT INTO `equipment` VALUES (11, '键盘鼠标', 50, 'A317', 60);
INSERT INTO `equipment` VALUES (12, '键盘鼠标', 50, 'A310', 60);
INSERT INTO `equipment` VALUES (13, '键盘鼠标', 50, 'A312', 60);
INSERT INTO `equipment` VALUES (14, '键盘鼠标', 50, 'A315', 60);
INSERT INTO `equipment` VALUES (15, '键盘鼠标', 50, 'A308', 60);
INSERT INTO `equipment` VALUES (16, '桌椅', 200, 'A317', 60);
INSERT INTO `equipment` VALUES (17, '桌椅', 200, 'A310', 60);
INSERT INTO `equipment` VALUES (18, '桌椅', 200, 'A312', 60);
INSERT INTO `equipment` VALUES (19, '桌椅', 200, 'A315', 60);
INSERT INTO `equipment` VALUES (20, '桌椅', 200, 'A308', 60);
INSERT INTO `equipment` VALUES (21, '多媒体', 2000, 'A317', 1);
INSERT INTO `equipment` VALUES (22, '多媒体', 2000, 'A310', 1);
INSERT INTO `equipment` VALUES (23, '多媒体', 2000, 'A312', 1);
INSERT INTO `equipment` VALUES (24, '多媒体', 2000, 'A315', 1);
INSERT INTO `equipment` VALUES (25, '多媒体', 2000, 'A308', 1);
INSERT INTO `equipment` VALUES (26, '空调', 2000, 'C301', 2);
INSERT INTO `equipment` VALUES (27, '空调', 2000, 'C303', 2);
INSERT INTO `equipment` VALUES (28, '空调', 2000, 'C305', 2);
INSERT INTO `equipment` VALUES (29, '空调', 2000, 'C307', 2);
INSERT INTO `equipment` VALUES (30, '空调', 2000, 'C309', 2);
INSERT INTO `equipment` VALUES (31, '电脑主机', 2000, 'C301', 60);
INSERT INTO `equipment` VALUES (32, '电脑主机', 2000, 'C303', 60);
INSERT INTO `equipment` VALUES (33, '电脑主机', 2000, 'C305', 60);
INSERT INTO `equipment` VALUES (34, '电脑主机', 2000, 'C307', 60);
INSERT INTO `equipment` VALUES (35, '电脑主机', 2000, 'C309', 60);
INSERT INTO `equipment` VALUES (36, '键盘鼠标', 50, 'C301', 60);
INSERT INTO `equipment` VALUES (37, '键盘鼠标', 50, 'C303', 60);
INSERT INTO `equipment` VALUES (38, '键盘鼠标', 50, 'C305', 60);
INSERT INTO `equipment` VALUES (39, '键盘鼠标', 50, 'C307', 60);
INSERT INTO `equipment` VALUES (40, '键盘鼠标', 50, 'C309', 60);
INSERT INTO `equipment` VALUES (41, '桌椅', 200, 'C301', 60);
INSERT INTO `equipment` VALUES (42, '桌椅', 200, 'C303', 60);
INSERT INTO `equipment` VALUES (43, '桌椅', 200, 'C305', 60);
INSERT INTO `equipment` VALUES (44, '桌椅', 200, 'C307', 60);
INSERT INTO `equipment` VALUES (45, '桌椅', 200, 'C309', 60);
INSERT INTO `equipment` VALUES (46, '多媒体', 2000, 'C301', 1);
INSERT INTO `equipment` VALUES (47, '多媒体', 2000, 'C303', 1);
INSERT INTO `equipment` VALUES (48, '多媒体', 2000, 'C305', 1);
INSERT INTO `equipment` VALUES (49, '多媒体', 2000, 'C307', 1);
INSERT INTO `equipment` VALUES (50, '多媒体', 2000, 'C309', 1);
INSERT INTO `equipment` VALUES (51, '空调', 2000, 'C414', 2);
INSERT INTO `equipment` VALUES (52, '空调', 2000, 'A401', 2);
INSERT INTO `equipment` VALUES (53, '空调', 2000, 'C403', 2);
INSERT INTO `equipment` VALUES (54, '空调', 2000, 'C205', 2);
INSERT INTO `equipment` VALUES (55, '空调', 2000, 'C407', 2);
INSERT INTO `equipment` VALUES (56, '电脑主机', 2000, 'C414', 60);
INSERT INTO `equipment` VALUES (57, '电脑主机', 2000, 'A401', 60);
INSERT INTO `equipment` VALUES (58, '电脑主机', 2000, 'C403', 60);
INSERT INTO `equipment` VALUES (59, '电脑主机', 2000, 'C205', 60);
INSERT INTO `equipment` VALUES (60, '电脑主机', 2000, 'C407', 60);
INSERT INTO `equipment` VALUES (61, '键盘鼠标', 50, 'C414', 60);
INSERT INTO `equipment` VALUES (62, '键盘鼠标', 50, 'A401', 60);
INSERT INTO `equipment` VALUES (63, '键盘鼠标', 50, 'C403', 60);
INSERT INTO `equipment` VALUES (64, '键盘鼠标', 50, 'C205', 60);
INSERT INTO `equipment` VALUES (65, '键盘鼠标', 50, 'C407', 60);
INSERT INTO `equipment` VALUES (66, '桌椅', 200, 'C414', 60);
INSERT INTO `equipment` VALUES (67, '桌椅', 200, 'A401', 60);
INSERT INTO `equipment` VALUES (68, '桌椅', 200, 'C403', 60);
INSERT INTO `equipment` VALUES (69, '桌椅', 200, 'C205', 60);
INSERT INTO `equipment` VALUES (70, '桌椅', 200, 'C407', 60);
INSERT INTO `equipment` VALUES (71, '多媒体', 2000, 'C414', 1);
INSERT INTO `equipment` VALUES (72, '多媒体', 2000, 'A401', 1);
INSERT INTO `equipment` VALUES (73, '多媒体', 2000, 'C403', 1);
INSERT INTO `equipment` VALUES (74, '多媒体', 2000, 'C205', 1);
INSERT INTO `equipment` VALUES (75, '多媒体', 2000, 'C407', 1);
INSERT INTO `equipment` VALUES (76, '空调', 2000, 'B301', 2);
INSERT INTO `equipment` VALUES (77, '空调', 2000, 'C302', 2);
INSERT INTO `equipment` VALUES (78, '空调', 2000, 'C409', 2);
INSERT INTO `equipment` VALUES (79, '电脑主机', 2000, 'B301', 20);
INSERT INTO `equipment` VALUES (80, '电脑主机', 2000, 'C302', 20);
INSERT INTO `equipment` VALUES (81, '电脑主机', 2000, 'C409', 20);
INSERT INTO `equipment` VALUES (82, '键盘鼠标', 50, 'B301', 20);
INSERT INTO `equipment` VALUES (83, '键盘鼠标', 50, 'C302', 20);
INSERT INTO `equipment` VALUES (84, '键盘鼠标', 50, 'C409', 20);
INSERT INTO `equipment` VALUES (85, '桌椅', 200, 'B301', 20);
INSERT INTO `equipment` VALUES (86, '桌椅', 200, 'C302', 20);
INSERT INTO `equipment` VALUES (87, '桌椅', 200, 'C409', 20);

-- ----------------------------
-- Table structure for moneylog
-- ----------------------------
DROP TABLE IF EXISTS `moneylog`;
CREATE TABLE `moneylog`  (
  `mtime` datetime NOT NULL,
  `mnumber` int NOT NULL,
  `mremarks` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `mtype` varchar(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`mtime`) 
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of moneylog
-- ----------------------------
INSERT INTO `moneylog` VALUES ('2020-12-09 08:54:55', 10000, NULL, '流入');
INSERT INTO `moneylog` VALUES ('2020-12-10 08:54:55', 1000, '购买电脑', '流出');
INSERT INTO `moneylog` VALUES ('2020-12-11 08:54:55', 1000, '购买电脑', '流出');
INSERT INTO `moneylog` VALUES ('2020-12-12 08:54:55', 1000, '购买电脑', '流出');
INSERT INTO `moneylog` VALUES ('2020-12-13 08:54:55', 1000, '购买电脑', '流出');
INSERT INTO `moneylog` VALUES ('2020-12-14 08:54:55', 1000, '购买电脑', '流出');
INSERT INTO `moneylog` VALUES ('2020-12-15 08:54:55', 1000, '购买电脑', '流出');
INSERT INTO `moneylog` VALUES ('2020-12-16 08:54:55', 1000, '购买电脑', '流出');
INSERT INTO `moneylog` VALUES ('2020-12-17 08:54:55', 1000, '购买电脑', '流出');
INSERT INTO `moneylog` VALUES ('2020-12-18 08:54:55', 1000, '购买电脑', '流出');
INSERT INTO `moneylog` VALUES ('2020-12-19 08:54:55', 1000, '购买电脑', '流出');
INSERT INTO `moneylog` VALUES ('2020-12-20 08:54:55', 8000, NULL, '流入');
INSERT INTO `moneylog` VALUES ('2020-12-21 08:54:55', 1000, '购买电脑', '流出');
INSERT INTO `moneylog` VALUES ('2020-12-22 08:54:55', 1000, '购买电脑', '流出');
INSERT INTO `moneylog` VALUES ('2020-12-23 08:54:55', 1000, '购买电脑', '流出');
INSERT INTO `moneylog` VALUES ('2020-12-24 08:54:55', 1000, '购买电脑', '流出');
INSERT INTO `moneylog` VALUES ('2020-12-25 08:54:55', 1000, '购买电脑', '流出');
INSERT INTO `moneylog` VALUES ('2020-12-26 08:54:55', 1000, '购买电脑', '流出');
INSERT INTO `moneylog` VALUES ('2020-12-27 08:54:55', 1000, '购买电脑', '流出');

-- ----------------------------
-- Table structure for onduty
-- ----------------------------
DROP TABLE IF EXISTS `onduty`;
CREATE TABLE `onduty`  (
  `oid` int NOT NULL,
  `oname` varchar(4) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `oweekday` varchar(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `obegintime` time NOT NULL,
  `oendtime` time NOT NULL,
  `oroom` varchar(4) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of onduty
-- ----------------------------
INSERT INTO `onduty` VALUES (2, '小徐', '周一', '08:00:00', '10:00:00', 'B301');
INSERT INTO `onduty` VALUES (3, '小潘', '周一', '10:00:00', '12:00:00', 'B301');
INSERT INTO `onduty` VALUES (4, '小姜', '周一', '14:20:00', '16:10:00', 'B301');
INSERT INTO `onduty` VALUES (5, '小程', '周一', '16:10:00', '18:00:00', 'B301');
INSERT INTO `onduty` VALUES (6, '小冯', '周一', '19:10:00', '22:00:00', 'B301');
INSERT INTO `onduty` VALUES (17, '方山', '周二', '08:00:00', '10:00:00', 'B301');
INSERT INTO `onduty` VALUES (18, '朱文', '周二', '10:00:00', '12:00:00', 'B301');
INSERT INTO `onduty` VALUES (19, '谢雨于', '周二', '14:20:00', '16:10:00', 'B301');
INSERT INTO `onduty` VALUES (20, '黎语', '周二', '16:10:00', '18:00:00', 'B301');
INSERT INTO `onduty` VALUES (21, '庞立', '周二', '19:10:00', '22:00:00', 'B301');
INSERT INTO `onduty` VALUES (22, '杨万与', '周三', '08:00:00', '10:00:00', 'B301');
INSERT INTO `onduty` VALUES (23, '苏语斌', '周三', '10:00:00', '12:00:00', 'B301');
INSERT INTO `onduty` VALUES (24, '简思乐', '周三', '14:20:00', '16:10:00', 'B301');
INSERT INTO `onduty` VALUES (25, '古于', '周三', '16:10:00', '18:00:00', 'B301');
INSERT INTO `onduty` VALUES (26, '孙斌', '周三', '19:10:00', '22:00:00', 'B301');
INSERT INTO `onduty` VALUES (27, '张齐', '周四', '08:00:00', '10:00:00', 'B301');
INSERT INTO `onduty` VALUES (28, '肖杰', '周四', '10:00:00', '12:00:00', 'B301');
INSERT INTO `onduty` VALUES (29, '黄权', '周四', '14:20:00', '16:10:00', 'B301');
INSERT INTO `onduty` VALUES (30, '顾飞', '周四', '16:10:00', '18:00:00', 'B301');
INSERT INTO `onduty` VALUES (31, '周新', '周四', '19:10:00', '22:00:00', 'B301');
INSERT INTO `onduty` VALUES (32, '罗语新', '周五', '08:00:00', '10:00:00', 'B301');
INSERT INTO `onduty` VALUES (33, '张殷', '周五', '10:00:00', '12:00:00', 'B301');
INSERT INTO `onduty` VALUES (34, '蒋心', '周五', '14:20:00', '16:10:00', 'B301');
INSERT INTO `onduty` VALUES (35, '尹明知', '周五', '16:10:00', '18:00:00', 'B301');
INSERT INTO `onduty` VALUES (36, '汪兴运', '周五', '19:10:00', '22:00:00', 'B301');
INSERT INTO `onduty` VALUES (37, '夏成化', '周六', '08:00:00', '10:00:00', 'B301');
INSERT INTO `onduty` VALUES (38, '范泰鸿', '周六', '10:00:00', '12:00:00', 'B301');
INSERT INTO `onduty` VALUES (39, '邵元纬', '周六', '14:20:00', '16:10:00', 'B301');
INSERT INTO `onduty` VALUES (40, '戴勇锐', '周六', '16:10:00', '18:00:00', 'B301');
INSERT INTO `onduty` VALUES (41, '乔经纬', '周六', '19:10:00', '22:00:00', 'B301');
INSERT INTO `onduty` VALUES (42, '史兴德', '周日', '08:00:00', '10:00:00', 'B301');
INSERT INTO `onduty` VALUES (43, '余和惬', '周日', '10:00:00', '12:00:00', 'B301');
INSERT INTO `onduty` VALUES (44, '高智志', '周日', '14:20:00', '16:10:00', 'B301');
INSERT INTO `onduty` VALUES (45, '万朗宁', '周日', '16:10:00', '18:00:00', 'B301');
INSERT INTO `onduty` VALUES (46, '钟莘莘', '周日', '19:10:00', '22:00:00', 'B301');
INSERT INTO `onduty` VALUES (7, '小王', '周一', '08:00:00', '10:00:00', 'C302');
INSERT INTO `onduty` VALUES (8, '小宏', '周一', '10:00:00', '12:00:00', 'C302');
INSERT INTO `onduty` VALUES (9, '小罗', '周一', '14:20:00', '16:10:00', 'C302');
INSERT INTO `onduty` VALUES (10, '小周', '周一', '16:10:00', '18:00:00', 'C302');
INSERT INTO `onduty` VALUES (11, '小苏', '周一', '19:10:00', '22:00:00', 'C302');
INSERT INTO `onduty` VALUES (47, '赵思恩', '周二', '08:00:00', '10:00:00', 'C302');
INSERT INTO `onduty` VALUES (48, '魏淑然', '周二', '10:00:00', '12:00:00', 'C302');
INSERT INTO `onduty` VALUES (49, '袁流逸', '周二', '14:20:00', '16:10:00', 'C302');
INSERT INTO `onduty` VALUES (50, '卢馨欣', '周二', '16:10:00', '18:00:00', 'C302');
INSERT INTO `onduty` VALUES (51, '乔静恬', '周二', '19:10:00', '22:00:00', 'C302');
INSERT INTO `onduty` VALUES (52, '何太文', '周三', '08:00:00', '10:00:00', 'C302');
INSERT INTO `onduty` VALUES (53, '梁笑萍', '周三', '10:00:00', '12:00:00', 'C302');
INSERT INTO `onduty` VALUES (54, '黄融雪', '周三', '14:20:00', '16:10:00', 'C302');
INSERT INTO `onduty` VALUES (55, '邱永', '周三', '16:10:00', '18:00:00', 'C302');
INSERT INTO `onduty` VALUES (56, '冯缨', '周三', '19:10:00', '22:00:00', 'C302');
INSERT INTO `onduty` VALUES (57, '道和韵', '周四', '08:00:00', '10:00:00', 'C302');
INSERT INTO `onduty` VALUES (58, '海天华', '周四', '10:00:00', '12:00:00', 'C302');
INSERT INTO `onduty` VALUES (59, '似翰音', '周四', '14:20:00', '16:10:00', 'C302');
INSERT INTO `onduty` VALUES (60, '鱼弘方', '周四', '16:10:00', '18:00:00', 'C302');
INSERT INTO `onduty` VALUES (61, '台温茂', '周四', '19:10:00', '22:00:00', 'C302');
INSERT INTO `onduty` VALUES (62, '剑安和', '周五', '08:00:00', '10:00:00', 'C302');
INSERT INTO `onduty` VALUES (63, '斐博易', '周五', '10:00:00', '12:00:00', 'C302');
INSERT INTO `onduty` VALUES (64, '汝绍祺', '周五', '14:20:00', '16:10:00', 'C302');
INSERT INTO `onduty` VALUES (65, '任学真', '周五', '16:10:00', '18:00:00', 'C302');
INSERT INTO `onduty` VALUES (66, '桂博雅', '周五', '19:10:00', '22:00:00', 'C302');
INSERT INTO `onduty` VALUES (67, '天鸿信', '周六', '08:00:00', '10:00:00', 'C302');
INSERT INTO `onduty` VALUES (68, '戚君之', '周六', '10:00:00', '12:00:00', 'C302');
INSERT INTO `onduty` VALUES (69, '雪涵映', '周六', '14:20:00', '16:10:00', 'C302');
INSERT INTO `onduty` VALUES (70, '逄乐志', '周六', '16:10:00', '18:00:00', 'C302');
INSERT INTO `onduty` VALUES (71, '星德义', '周六', '19:10:00', '22:00:00', 'C302');
INSERT INTO `onduty` VALUES (72, '空伟茂', '周日', '08:00:00', '10:00:00', 'C302');
INSERT INTO `onduty` VALUES (73, '频晨濡', '周日', '10:00:00', '12:00:00', 'C302');
INSERT INTO `onduty` VALUES (74, '揭烨霖', '周日', '14:20:00', '16:10:00', 'C302');
INSERT INTO `onduty` VALUES (75, '孝兴昌', '周日', '16:10:00', '18:00:00', 'C302');
INSERT INTO `onduty` VALUES (76, '丑鹏海', '周日', '19:10:00', '22:00:00', 'C302');
INSERT INTO `onduty` VALUES (12, '小张', '周一', '08:00:00', '10:00:00', 'C409');
INSERT INTO `onduty` VALUES (13, '小黎', '周一', '10:00:00', '12:00:00', 'C409');
INSERT INTO `onduty` VALUES (14, '小蒋', '周一', '14:20:00', '16:10:00', 'C409');
INSERT INTO `onduty` VALUES (15, '小叶', '周一', '16:10:00', '18:00:00', 'C409');
INSERT INTO `onduty` VALUES (16, '小吴', '周一', '19:10:00', '22:00:00', 'C409');
INSERT INTO `onduty` VALUES (77, '僪凯捷', '周二', '08:00:00', '10:00:00', 'C409');
INSERT INTO `onduty` VALUES (78, '家嘉澍', '周二', '10:00:00', '12:00:00', 'C409');
INSERT INTO `onduty` VALUES (79, '年嘉良', '周二', '14:20:00', '16:10:00', 'C409');
INSERT INTO `onduty` VALUES (80, '连德庸', '周二', '16:10:00', '18:00:00', 'C409');
INSERT INTO `onduty` VALUES (81, '衣飞昂', '周二', '19:10:00', '22:00:00', 'C409');
INSERT INTO `onduty` VALUES (82, '养修筠', '周三', '08:00:00', '10:00:00', 'C409');
INSERT INTO `onduty` VALUES (83, '告和顺', '周三', '10:00:00', '12:00:00', 'C409');
INSERT INTO `onduty` VALUES (84, '尉宏盛', '周三', '14:20:00', '16:10:00', 'C409');
INSERT INTO `onduty` VALUES (85, '郭浩宕', '周三', '16:10:00', '18:00:00', 'C409');
INSERT INTO `onduty` VALUES (86, '系宏伟', '周三', '19:10:00', '22:00:00', 'C409');
INSERT INTO `onduty` VALUES (87, '淦运乾', '周四', '08:00:00', '10:00:00', 'C409');
INSERT INTO `onduty` VALUES (88, '栾令梓', '周四', '10:00:00', '12:00:00', 'C409');
INSERT INTO `onduty` VALUES (89, '汲锐阵', '周四', '14:20:00', '16:10:00', 'C409');
INSERT INTO `onduty` VALUES (90, '旁令秋', '周四', '16:10:00', '18:00:00', 'C409');
INSERT INTO `onduty` VALUES (91, '劳咏德', '周四', '19:10:00', '22:00:00', 'C409');
INSERT INTO `onduty` VALUES (92, '千靖琪', '周五', '08:00:00', '10:00:00', 'C409');
INSERT INTO `onduty` VALUES (93, '野博艺', '周五', '10:00:00', '12:00:00', 'C409');
INSERT INTO `onduty` VALUES (94, '梁骏祥', '周五', '14:20:00', '16:10:00', 'C409');
INSERT INTO `onduty` VALUES (95, '竹玉宇', '周五', '16:10:00', '18:00:00', 'C409');
INSERT INTO `onduty` VALUES (96, '肖宏胜', '周五', '19:10:00', '22:00:00', 'C409');
INSERT INTO `onduty` VALUES (97, '从骏年', '周六', '08:00:00', '10:00:00', 'C409');
INSERT INTO `onduty` VALUES (98, '韦旭尧', '周六', '10:00:00', '12:00:00', 'C409');
INSERT INTO `onduty` VALUES (99, '招浦和', '周六', '14:20:00', '16:10:00', 'C409');
INSERT INTO `onduty` VALUES (100, '堂浩邈', '周六', '16:10:00', '18:00:00', 'C409');
INSERT INTO `onduty` VALUES (101, '窦雨石', '周六', '19:10:00', '22:00:00', 'C409');
INSERT INTO `onduty` VALUES (102, '平煜祺', '周日', '08:00:00', '10:00:00', 'C409');
INSERT INTO `onduty` VALUES (103, '侨越彬', '周日', '10:00:00', '12:00:00', 'C409');
INSERT INTO `onduty` VALUES (104, '说奇正', '周日', '14:20:00', '16:10:00', 'C409');
INSERT INTO `onduty` VALUES (105, '佛坚壁', '周日', '16:10:00', '18:00:00', 'C409');
INSERT INTO `onduty` VALUES (106, '步海荣', '周日', '19:10:00', '22:00:00', 'C409');

-- ----------------------------
-- Table structure for sadmininfo
-- ----------------------------
DROP TABLE IF EXISTS `sadmininfo`;
CREATE TABLE `sadmininfo`  (
  `said` int NOT NULL AUTO_INCREMENT,
  `saname` varchar(4) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `sapwd` varchar(12) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `saage` int NOT NULL,
  `sasex` varchar(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `sagrade` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `samajor` varchar(8) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `saclass` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `saclassroom` varchar(4) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`said`) 
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sadmininfo
-- ----------------------------
INSERT INTO `sadmininfo` VALUES (2, '小徐', 'xu', 20, '女', '2019级', '软件工程', '2班', 'A317');
INSERT INTO `sadmininfo` VALUES (3, '小潘', 'pan', 21, '男', '2019级', '网络工程', '2班', 'A315');
INSERT INTO `sadmininfo` VALUES (4, '小姜', 'jiang', 20, '男', '2019级', '计算机科学与技术', '1班', 'A310');
INSERT INTO `sadmininfo` VALUES (5, '小程', 'cheng', 21, '男', '2019级', '软件工程', '2班', 'A312');
INSERT INTO `sadmininfo` VALUES (6, '小冯', 'feng', 21, '女', '2019级', '软件工程', '1班', 'A308');
INSERT INTO `sadmininfo` VALUES (7, '小王', 'wang', 20, '男', '2019级', '软件工程', '2班', 'C301');
INSERT INTO `sadmininfo` VALUES (8, '小宏', 'hong', 21, '男', '2019级', '网络工程', '1班', 'C303');
INSERT INTO `sadmininfo` VALUES (9, '小罗', 'luo', 20, '女', '2019级', '计算机科学与技术', '2班', 'C305');
INSERT INTO `sadmininfo` VALUES (10, '小周', 'zhou', 21, '男', '2019级', '软件工程', '1班', 'C307');
INSERT INTO `sadmininfo` VALUES (11, '小苏', 'su', 20, '女', '2019级', '软件工程', '2班', 'C309');
INSERT INTO `sadmininfo` VALUES (12, '小张', 'zhang', 21, '女', '2019级', '网络工程', '1班', 'C414');
INSERT INTO `sadmininfo` VALUES (13, '小黎', 'li', 20, '女', '2019级', '计算机科学与技术', '2班', 'A401');
INSERT INTO `sadmininfo` VALUES (14, '小蒋', 'jiang', 21, '男', '2019级', '软件工程', '1班', 'C403');
INSERT INTO `sadmininfo` VALUES (15, '小叶', 'ye', 20, '女', '2019级', '软件工程', '2班', 'C205');
INSERT INTO `sadmininfo` VALUES (16, '小吴', 'wu', 21, '男', '2019级', '网络工程', '1班', 'C407');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `uid` int NOT NULL AUTO_INCREMENT,
  `uname` varchar(4) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `upwd` varchar(12) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `uage` int NOT NULL,
  `usex` varchar(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ugrade` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `umajor` varchar(8) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `uclass` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `uclassroom` varchar(4) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`uid`) 
) ENGINE = InnoDB AUTO_INCREMENT = 113 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (17, '方山', 'fangshan', 20, '男', '2020级', '计算机类', '2班', 'A317');
INSERT INTO `userinfo` VALUES (18, '朱文', 'zhuwen', 19, '男', '2020级', '计算机类', '3班', 'A317');
INSERT INTO `userinfo` VALUES (19, '谢雨于', 'xieyuyu', 20, '女', '2019级', '计算机科学与技术', '1班', 'A317');
INSERT INTO `userinfo` VALUES (20, '黎语', 'liyu', 21, '女', '2019级', '网络工程', '2班', 'A317');
INSERT INTO `userinfo` VALUES (21, '庞立', 'pangli', 21, '男', '2020级', '计算机类', '6班', 'A317');
INSERT INTO `userinfo` VALUES (22, '杨万与', 'yangwanyu', 20, '男', '2019级', '计算机科学与技术', '1班', 'A317');
INSERT INTO `userinfo` VALUES (23, '苏语斌', 'shuyubin', 21, '女', '2019级', '软件工程', '2班', 'A315');
INSERT INTO `userinfo` VALUES (24, '简思乐', 'jiansile', 20, '女', '2020级', '计算机类', '6班', 'A315');
INSERT INTO `userinfo` VALUES (25, '古于', 'guyu', 20, '女', '2019级', '网络工程', '1班', 'A315');
INSERT INTO `userinfo` VALUES (26, '孙斌', 'sunbin', 21, '男', '2019级', '软件工程', '2班', 'A315');
INSERT INTO `userinfo` VALUES (27, '张齐', 'zhangqi', 19, '男', '2020级', '计算机类', '5班', 'A315');
INSERT INTO `userinfo` VALUES (28, '肖杰', 'xiaofei', 20, '男', '2019级', '计算机科学与技术', '1班', 'A315');
INSERT INTO `userinfo` VALUES (29, '黄权', 'huangquan', 21, '男', '2019级', '网络工程', '4班', 'A312');
INSERT INTO `userinfo` VALUES (30, '顾飞', 'gufei', 19, '男', '2020级', '计算机类', '6班', 'A312');
INSERT INTO `userinfo` VALUES (31, '周新', 'zhouxin', 20, '男', '2019级', '网络工程', '1班', 'A312');
INSERT INTO `userinfo` VALUES (32, '罗语新', 'luoyuxin', 21, '女', '2019级', '软件工程', '2班', 'A312');
INSERT INTO `userinfo` VALUES (33, '张殷', 'zhanghuan', 20, '女', '2020级', '计算机类', '4班', 'A312');
INSERT INTO `userinfo` VALUES (34, '蒋心', 'jiangxin', 20, '女', '2020级', '人工智能', '1班', 'A312');
INSERT INTO `userinfo` VALUES (35, '尹明知', 'ymz', 20, '男', '2019级', '网络工程', '1班', 'A308');
INSERT INTO `userinfo` VALUES (36, '汪兴运', 'wxy', 20, '男', '2019级', '软件工程', '2班', 'A308');
INSERT INTO `userinfo` VALUES (37, '夏成化', 'xch', 20, '男', '2020级', '计算机类', '4班', 'A308');
INSERT INTO `userinfo` VALUES (38, '范泰鸿', 'fth', 19, '男', '2020级', '人工智能', '2班', 'A308');
INSERT INTO `userinfo` VALUES (39, '邵元纬', 'syw', 20, '男', '2019级', '计算机科学与技术', '1班', 'A308');
INSERT INTO `userinfo` VALUES (40, '戴勇锐', 'dyr', 19, '男', '2019级', '网络工程', '2班', 'A308');
INSERT INTO `userinfo` VALUES (41, '乔经纬', 'qjw', 20, '男', '2019级', '软件工程', '4班', 'A310');
INSERT INTO `userinfo` VALUES (42, '史兴德', 'sxd', 20, '男', '2020级', '计算机类', '3班', 'A310');
INSERT INTO `userinfo` VALUES (43, '余和惬', 'yhq', 20, '男', '2020级', '人工智能', '1班', 'A310');
INSERT INTO `userinfo` VALUES (44, '高智志', 'gzz', 21, '男', '2019级', '计算机科学与技术', '2班', 'A310');
INSERT INTO `userinfo` VALUES (45, '万朗宁', 'wln', 20, '女', '2019级', '网络工程', '4班', 'A310');
INSERT INTO `userinfo` VALUES (46, '钟莘莘', 'zqq', 21, '女', '2019级', '软件工程', '2班', 'A310');
INSERT INTO `userinfo` VALUES (47, '赵思恩', 'zse', 20, '女', '2020级', '计算机类', '3班', 'C301');
INSERT INTO `userinfo` VALUES (48, '魏淑然', 'qsr', 20, '女', '2020级', '人工智能', '2班', 'C301');
INSERT INTO `userinfo` VALUES (49, '袁流逸', 'yly', 19, '女', '2019级', '计算机科学与技术', '1班', 'C301');
INSERT INTO `userinfo` VALUES (50, '卢馨欣', 'lxx', 20, '女', '2019级', '网络工程', '2班', 'C301');
INSERT INTO `userinfo` VALUES (51, '乔静恬', 'qjt', 21, '女', '2019级', '软件工程', '1班', 'C301');
INSERT INTO `userinfo` VALUES (52, '何太文', 'htw', 20, '女', '2020级', '计算机类', '5班', 'C301');
INSERT INTO `userinfo` VALUES (53, '梁笑萍', 'lxp', 20, '女', '2020级', '人工智能', '1班', 'C303');
INSERT INTO `userinfo` VALUES (54, '黄融雪', 'hrx', 20, '女', '2019级', '计算机科学与技术', '2班', 'C303');
INSERT INTO `userinfo` VALUES (55, '邱永', 'qy', 20, '男', '2019级', '网络工程', '1班', 'C303');
INSERT INTO `userinfo` VALUES (56, '冯缨', 'fy', 20, '女', '2020级', '计算机类', '5班', 'C303');
INSERT INTO `userinfo` VALUES (57, '道和韵', 'dao', 20, '男', '2019级', '计算机科学与技术', '1班', 'C303');
INSERT INTO `userinfo` VALUES (58, '海天华', 'hai', 19, '男', '2019级', '网络工程', '2班', 'C303');
INSERT INTO `userinfo` VALUES (59, '似翰音', 'si', 20, '男', '2019级', '软件工程', '4班', 'C305');
INSERT INTO `userinfo` VALUES (60, '鱼弘方', 'yu', 20, '男', '2020级', '计算机类', '3班', 'C305');
INSERT INTO `userinfo` VALUES (61, '台温茂', 'tai', 20, '男', '2020级', '人工智能', '1班', 'C305');
INSERT INTO `userinfo` VALUES (62, '剑安和', 'jian', 21, '男', '2019级', '计算机科学与技术', '2班', 'C305');
INSERT INTO `userinfo` VALUES (63, '斐博易', 'fei', 20, '女', '2019级', '网络工程', '4班', 'C305');
INSERT INTO `userinfo` VALUES (64, '汝绍祺', 'ru', 21, '女', '2019级', '软件工程', '2班', 'C305');
INSERT INTO `userinfo` VALUES (65, '任学真', 'ren', 20, '女', '2020级', '计算机类', '3班', 'C307');
INSERT INTO `userinfo` VALUES (66, '桂博雅', 'gui', 20, '女', '2020级', '人工智能', '2班', 'C307');
INSERT INTO `userinfo` VALUES (67, '天鸿信', 'tian', 19, '女', '2019级', '计算机科学与技术', '1班', 'C307');
INSERT INTO `userinfo` VALUES (68, '戚君之', 'abc', 20, '女', '2019级', '网络工程', '2班', 'C307');
INSERT INTO `userinfo` VALUES (69, '雪涵映', 'abc', 21, '女', '2019级', '软件工程', '1班', 'C307');
INSERT INTO `userinfo` VALUES (70, '逄乐志', 'abc', 20, '女', '2020级', '计算机类', '5班', 'C307');
INSERT INTO `userinfo` VALUES (71, '星德义', 'abc', 20, '女', '2020级', '人工智能', '1班', 'C309');
INSERT INTO `userinfo` VALUES (72, '空伟茂', 'abc', 20, '女', '2019级', '计算机科学与技术', '2班', 'C309');
INSERT INTO `userinfo` VALUES (73, '频晨濡', 'abc', 20, '男', '2019级', '网络工程', '1班', 'C309');
INSERT INTO `userinfo` VALUES (74, '揭烨霖', 'abc', 20, '女', '2020级', '计算机类', '5班', 'C309');
INSERT INTO `userinfo` VALUES (75, '孝兴昌', 'abc', 20, '男', '2019级', '计算机科学与技术', '1班', 'C309');
INSERT INTO `userinfo` VALUES (76, '丑鹏海', 'abc', 19, '男', '2019级', '网络工程', '2班', 'C309');
INSERT INTO `userinfo` VALUES (77, '僪凯捷', 'abc', 20, '男', '2019级', '软件工程', '4班', 'A401');
INSERT INTO `userinfo` VALUES (78, '家嘉澍', 'abc', 20, '男', '2020级', '计算机类', '3班', 'A401');
INSERT INTO `userinfo` VALUES (79, '年嘉良', 'abc', 20, '男', '2020级', '人工智能', '1班', 'A401');
INSERT INTO `userinfo` VALUES (80, '连德庸', 'abc', 21, '男', '2019级', '计算机科学与技术', '2班', 'A401');
INSERT INTO `userinfo` VALUES (81, '衣飞昂', 'abc', 20, '女', '2019级', '网络工程', '4班', 'A401');
INSERT INTO `userinfo` VALUES (82, '养修筠', 'abc', 21, '女', '2019级', '软件工程', '2班', 'A401');
INSERT INTO `userinfo` VALUES (83, '告和顺', 'abc', 20, '女', '2020级', '计算机类', '3班', 'C414');
INSERT INTO `userinfo` VALUES (84, '尉宏盛', 'abc', 20, '女', '2020级', '人工智能', '2班', 'C414');
INSERT INTO `userinfo` VALUES (85, '郭浩宕', 'abc', 19, '女', '2019级', '计算机科学与技术', '1班', 'C414');
INSERT INTO `userinfo` VALUES (86, '系宏伟', 'abc', 20, '女', '2019级', '网络工程', '2班', 'C414');
INSERT INTO `userinfo` VALUES (87, '淦运乾', 'abc', 21, '女', '2019级', '软件工程', '1班', 'C414');
INSERT INTO `userinfo` VALUES (88, '栾令梓', 'abc', 20, '女', '2020级', '计算机类', '5班', 'C414');
INSERT INTO `userinfo` VALUES (89, '汲锐阵', 'abc', 20, '女', '2020级', '人工智能', '1班', 'C403');
INSERT INTO `userinfo` VALUES (90, '旁令秋', 'abc', 20, '女', '2019级', '计算机科学与技术', '2班', 'C403');
INSERT INTO `userinfo` VALUES (91, '劳咏德', 'abc', 20, '男', '2019级', '网络工程', '1班', 'C403');
INSERT INTO `userinfo` VALUES (92, '千靖琪', 'abc', 20, '女', '2020级', '计算机类', '5班', 'C403');
INSERT INTO `userinfo` VALUES (93, '野博艺', 'abc', 20, '男', '2019级', '计算机科学与技术', '1班', 'C403');
INSERT INTO `userinfo` VALUES (94, '梁骏祥', 'abc', 19, '男', '2019级', '网络工程', '2班', 'C403');
INSERT INTO `userinfo` VALUES (95, '竹玉宇', 'abc', 20, '男', '2019级', '软件工程', '4班', 'C205');
INSERT INTO `userinfo` VALUES (96, '肖宏胜', 'abc', 20, '男', '2020级', '计算机类', '3班', 'C205');
INSERT INTO `userinfo` VALUES (97, '从骏年', 'abc', 20, '男', '2020级', '人工智能', '1班', 'C205');
INSERT INTO `userinfo` VALUES (98, '韦旭尧', 'abc', 21, '男', '2019级', '计算机科学与技术', '2班', 'C205');
INSERT INTO `userinfo` VALUES (99, '招浦和', 'abc', 20, '女', '2019级', '网络工程', '4班', 'C205');
INSERT INTO `userinfo` VALUES (100, '堂浩邈', 'abc', 21, '女', '2019级', '软件工程', '2班', 'C205');
INSERT INTO `userinfo` VALUES (101, '窦雨石', 'abc', 20, '女', '2020级', '计算机类', '3班', 'C407');
INSERT INTO `userinfo` VALUES (102, '平煜祺', 'abc', 20, '女', '2020级', '人工智能', '2班', 'C407');
INSERT INTO `userinfo` VALUES (103, '侨越彬', 'abc', 19, '女', '2019级', '计算机科学与技术', '1班', 'C407');
INSERT INTO `userinfo` VALUES (104, '说奇正', 'abc', 20, '女', '2019级', '网络工程', '2班', 'C407');
INSERT INTO `userinfo` VALUES (105, '佛坚壁', 'abc', 21, '女', '2019级', '软件工程', '1班', 'C407');
INSERT INTO `userinfo` VALUES (106, '步海荣', 'abc', 20, '女', '2020级', '计算机类', '5班', 'C407');

SET FOREIGN_KEY_CHECKS = 1;
