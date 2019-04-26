CREATE TABLE `member` (
  `member_code` varchar(255) NOT NULL COMMENT '会员编码',
  `merchant_code` varchar(255) NOT NULL COMMENT '商户编码',
  `member_name` varchar(255) DEFAULT NULL COMMENT '会员名称',
  `member_passwd` varchar(255) DEFAULT NULL COMMENT '会员密码',
  `head_img` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `state` int(11) DEFAULT '1' COMMENT '状态 0 停用 1 启用',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `open_id` varchar(255) DEFAULT NULL COMMENT '微信唯一标识',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
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
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`merchant_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商户表';


CREATE TABLE `user` (
  `user_code` varchar(255) NOT NULL COMMENT '用户编码',
  `merchant_code` varchar(255) NOT NULL COMMENT '商户编码',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名称',
  `user_passwd` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `state` int(11) DEFAULT '1' COMMENT '0 停用 1 启用',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`user_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';