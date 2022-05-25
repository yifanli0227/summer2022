
#CREATE DATABASE demo1;
USE demo1;
DROP TABLE IF EXISTS `sys_user_role`;
DROP TABLE IF EXISTS `sys_user`;
DROP TABLE IF EXISTS `sys_role`;

#DROP DATABASE IF EXISTS 'demo1';



CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL UNIQUE,
  `password` varchar(255) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `isenable` int(255) DEFAULT NULL,
  `islock` int(255) DEFAULT NULL,
  `iscredentials` int(255) DEFAULT NULL,
  `isexpired` int(11) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `logintime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(255) DEFAULT NULL,
  `rolememo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `sys_user_role` (
  `userid` int(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL
);



INSERT INTO sys_role VALUES(1,"ADMIN","high");
INSERT INTO sys_role VALUES(2,"USER","mid");
INSERT INTO sys_role VALUES(3,"READ","low");

INSERT INTO sys_user_role VALUES(1,1);
INSERT INTO sys_user_role VALUES(2,3);
INSERT INTO sys_user_role VALUES(3,2);