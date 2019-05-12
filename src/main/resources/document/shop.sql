CREATE TABLE `img_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类别编码',
  `parent_id` int(11) DEFAULT NULL COMMENT '父类编码',
  `name` varchar(255) DEFAULT NULL COMMENT '类别名称',
  `merchant_code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

CREATE TABLE `member` (
  `member_code` varchar(255) NOT NULL COMMENT '会员编码',
  `merchant_code` varchar(255) NOT NULL COMMENT '商户编码',
  `member_name` varchar(255) DEFAULT NULL COMMENT '会员名称',
  `member_passwd` varchar(255) DEFAULT NULL COMMENT '会员密码',
  `head_img` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `state` int(11) DEFAULT '1' COMMENT '状态 0 停用 1 启用',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `open_id` varchar(255) DEFAULT NULL COMMENT '微信唯一标识',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`member_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员表';


CREATE TABLE `merchant` (
  `merchant_code` varchar(255) NOT NULL COMMENT '商户编码',
  `merchant_name` varchar(255) DEFAULT NULL COMMENT '商户名称',
  `state` int(11) DEFAULT '1' COMMENT '0 停用 1 启用',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `secret_key` varchar(255) DEFAULT NULL COMMENT '商户密钥',
  `expire_time` datetime DEFAULT NULL COMMENT '到期时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`merchant_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商户表';


CREATE TABLE `user` (
  `user_code` varchar(255) NOT NULL COMMENT '用户编码',
  `merchant_code` varchar(255) NOT NULL COMMENT '商户编码',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名称',
  `user_passwd` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `state` int(11) DEFAULT '1' COMMENT '0 停用 1 启用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`user_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

CREATE TABLE `img_info` (
  `img_code` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category_id` int(11) DEFAULT NULL COMMENT '所属分类',
  `img_url` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `merchant_code` varchar(255) DEFAULT NULL COMMENT '商户编码',
  `user_code` varchar(255) DEFAULT NULL COMMENT '用户编码',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`img_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;