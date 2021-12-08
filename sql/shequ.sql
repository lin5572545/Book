/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : shequ

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 01/12/2021 11:06:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '管理员', 'admin', '123');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `goods_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_price` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `publisher_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `publish_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (51, '7w0Q6GWe', '活着', '《活着》是一本有生命、有感染力的书。我深深记得初读《活着》的感受，从初始的悠然到其后的 凝重，翻动书页的手指愈渐迟疑，我感到心中似乎有一种隐秘的期待——呼唤着一个转折，一个让主 角福贵走向幸福的转折，然而，我失望了，作者是那么的残忍与吝啬，我几乎是一路心痛地读到最终。 当我满心酸楚地合上书页，猛然望见封面一袭鲜血般的暗红：刺目一如长长伤口上的血淋淋，却又宛如 生命勃勃的涌动……我的泪直直地落下来了。', '91d8eaa83031acab080f62886e2fafec_0_0_0_0_water.jpg', '林家鹏  物联网应用技术B班', 'admin', '2021-11-20 14:06:17');
INSERT INTO `goods` VALUES (52, '3tHbY7jn', '许三观卖血记', '许三观是一个平凡的人，他的身上也有着缺点和不足可是正是在最普通最平凡的人身上所体现的抗争更具有普遍性。他的一生是苦难的一生，更是丰富的一生，无论是眼泪、温情还是欢笑、乐观。我们从中得到的是生存的意义和生命的力量。', 'a584bf0e06f88dbc7672db7203d134ff_0_1_300_300.jpg', '杨煜榜  物联网应用技术B班', 'admin', '2021-11-20 14:09:17');
INSERT INTO `goods` VALUES (53, '1GcmMHJR', '在细雨中呼喊', '余华笔下的村庄，安逸平淡却裹挟着人性的善良与丑恶，“我”虽然沉默寡言，逆来顺受，却避免 不了被送人；哥哥因为父亲的暴行而割下他的耳朵；弟弟因救人而牺牲却成为父兄二人攫取荣耀的工 具，在无尽的丑恶与不堪中我们才能感受到“我”面对漂亮女生时的紧张与不安，养父母对“我”的疼 爱，人世在变，沧海桑田，唯一不变的只有规律。余华以特殊的年代，特殊的经历，却很普通的笔调， 描绘出一个个栩栩如生的人物，供人哀叹、供人唏嘘、供人荡气回肠！', '92d833e03683a2e7238341ddcb679b51_0_1_300_300.jpg', '吴韦漫  物联网应用技术B班', 'admin', '2021-11-20 14:13:58');
INSERT INTO `goods` VALUES (56, 'x3K1uHmj', '三毛流浪记', '　　读了这本书我觉得有点难过，跟三毛的吃不饱、穿不暖，没有可避风挡雨的家，没有爸爸妈妈的疼 爱，没有学可上，相比之下我是多么的幸福，可是我却常常因为学习不够自觉而让爸爸妈妈生气、操 心。从现在开始我决心做懂事的孩子。', '1f05b9b2e482e91636b028e358a0b141_0_1_300_300.jpg', '杨煜榜', 'admin', '2021-11-20 14:34:39');

-- ----------------------------
-- Table structure for goodspay
-- ----------------------------
DROP TABLE IF EXISTS `goodspay`;
CREATE TABLE `goodspay`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `goods_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goodspay
-- ----------------------------
INSERT INTO `goodspay` VALUES (34, '1301jL97', 'Y3NxjulM');
INSERT INTO `goodspay` VALUES (35, 'u1aB3Vma', 'Y3NxjulM');
INSERT INTO `goodspay` VALUES (36, 'x3K1uHmj', 'Y3NxjulM');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `time` datetime NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatarUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (27, '2021-11-20 14:55:57', '林家鹏', '活着.xml', 'book118.jpg', '《活着》文章节选', 'book118.jpg');

-- ----------------------------
-- Table structure for repair
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `my_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `my_area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pic0` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pic1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pic2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of repair
-- ----------------------------
INSERT INTO `repair` VALUES (13, 'Y3NxjulM', '界面不美观', '使用问题', 'iQMp1uzgepdZ31a0f35efd520d1eda36052c014be822.png', NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `buildingNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unitNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `roomNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `roomId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('Y3NxjulM', '林家鹏', '男', '3', '3', '3', '13888888888', '13888888888', '9');

-- ----------------------------
-- Table structure for user_sur
-- ----------------------------
DROP TABLE IF EXISTS `user_sur`;
CREATE TABLE `user_sur`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qid` int NULL DEFAULT NULL,
  `su_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_sur
-- ----------------------------

-- ----------------------------
-- Table structure for user_sur_opt
-- ----------------------------
DROP TABLE IF EXISTS `user_sur_opt`;
CREATE TABLE `user_sur_opt`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_sur_id` int NULL DEFAULT NULL,
  `opt_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_sur_opt
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
