DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '角色id',
  `username` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `top` tinyint(1) DEFAULT NULL COMMENT '是否超级管理员',
  `user_type` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '用户类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB

INSERT INTO `t_user` VALUES ('1', '1', 'apple', 'fe895fc2989c3ff0af142b62d3be3a8d98a923', '18', '0', null);
INSERT INTO `t_user` VALUES ('2', '1', 'apple1', '133', 'fe895fc2989c3ff0af142b62d3be3a8d98a923', '0', 'NL');
INSERT INTO `t_user` VALUES ('3', '1', 'apple2', '4', 'fe895fc2989c3ff0af142b62d3be3a8d98a923', '0', 'NL');
INSERT INTO `t_user` VALUES ('4', '1', 'apple3', '464', 'fe895fc2989c3ff0af142b62d3be3a8d98a923', '0', 'NL');
INSERT INTO `t_user` VALUES ('9', '1', 'apple4', '4646', 'fe895fc2989c3ff0af142b62d3be3a8d98a923', '0', 'NL');
INSERT INTO `t_user` VALUES ('10', '8', 'apple5', '646', 'fe895fc2989c3ff0af142b62d3be3a8d98a923', '0', 'NL');
INSERT INTO `t_user` VALUES ('11', '8', '46464', '46464', 'fe895fc2989c3ff0af142b62d3be3a8d98a923', '0', 'NL');