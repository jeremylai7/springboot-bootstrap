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

INSERT INTO `t_user` VALUES ('1', '1', 'apple', 'fe895fc2989c3ff0af142b62d3be3a8d98a923', 18, '0', null);
INSERT INTO `t_user` VALUES ('2', '1', 'apple1', 'fe895fc2989c3ff0af142b62d3be3a8d98a923',19, '0', 'NL');
INSERT INTO `t_user` VALUES ('3', '1', 'apple2', 'fe895fc2989c3ff0af142b62d3be3a8d98a923',21, '0', 'NL');
INSERT INTO `t_user` VALUES ('4', '1', 'apple3', 'fe895fc2989c3ff0af142b62d3be3a8d98a923',22, '0', 'NL');
INSERT INTO `t_user` VALUES ('9', '1', 'apple4', 'fe895fc2989c3ff0af142b62d3be3a8d98a923',23, '0', 'NL');
INSERT INTO `t_user` VALUES ('10', '8', 'apple5','fe895fc2989c3ff0af142b62d3be3a8d98a923',24, '0', 'NL');
INSERT INTO `t_user` VALUES ('11', '8', '46464', 'fe895fc2989c3ff0af142b62d3be3a8d98a923',25, '0', 'NL');

create table t_access_log (
  `id` bigint not null auto_increment,
  `ip` varchar(32) null comment "ip地址",
  `browser` varchar(64) comment "浏览器",
  `pc` varchar(64) comment "电脑",
  create_time timestamp not null default current_timestamp comment "访问时间",
  `country`  varchar(32) comment "国家",
  `region_name`  varchar(32) comment "省份",
  `city`  varchar(32) comment "市",
  primary key(`id`)
)

