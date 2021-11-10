create table t_access_log (
      `id` bigint not null auto_increment,
      `ip` varchar(32) null comment "ip地址",
      `browser` varchar(32) comment "浏览器",
      `pc` varchar(32) comment "电脑",
      create_time timestamp not null default current_timestamp comment "访问时间",
      primary key(`id`)
)