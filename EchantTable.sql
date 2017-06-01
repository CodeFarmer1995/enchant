-- 用户表
CREATE TABLE `user_info`(
  `user_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_email` VARCHAR(64)  NOT NULL,
  `user_password` VARCHAR(64) NOT NULL,
  `user_name` VARCHAR(64) NOT NULL,
  `user_sex` TINYINT(4) NOT NULL, --0男1女
  `user_avatar` VARCHAR(32)  NOT NULL,
  `description` VARCHAR(128) NOT NULL,
  `ext_info` VARCHAR(128) NOT NULL,
  `user_type` TINYINT(4) UNSIGNED NOT NULL,
  `create_time` INT(11) UNSIGNED NOT NULL,
  `update_time` INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_email` (`user_email`)
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;

drop TABLE user_info;
-- 音乐表
CREATE TABLE `music_info`(
  `music_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `music_name` VARCHAR(32) NOT NULL,
  `user_id` BIGINT(20) UNSIGNED NOT NULL,
  `artist_name` VARCHAR(32) NOT NULL,
  `album` VARCHAR(32) NOT NULL,
  `cover_file` VARCHAR(32) NOT NULL,
  `quality` VARCHAR(32)  NOT NULL,
  `duration` INT(32) NOT NULL,
  `music_file` VARCHAR(32) NOT NULL,
  `lyric_file` VARCHAR(32) NOT NULL,
  `music_type` TINYINT(4) UNSIGNED NOT NULL,
  `ext_info` VARCHAR(128) NOT NULL,
  `create_time` INT(11) UNSIGNED NOT NULL,
  `update_time` INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`music_id`),
  KEY `music_name` (`music_name`),
  KEY `artist_name` (`artist_name`)
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;
-- 兼容后续用户上传音乐，type可以分类普通音乐，vip音乐，用户上传音乐

drop TABLE music_info;

-- 用户歌单表
CREATE TABLE `favorite_info`(
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT(20) UNSIGNED NOT NULL,
  `favorite_name` VARCHAR(32)  NOT NULL,
  `create_time` INT(11) UNSIGNED NOT NULL,
  `update_time` INT(11) UNSIGNED NOT NULL,
  `ext_info` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `favorite_name` (`favorite_name`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
-- 兼容后续自定义歌单,无id,name需对同一用户唯一


-- 用户收藏歌曲表
CREATE TABLE `user_favorite`(
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT(20) UNSIGNED NOT NULL,
  `favorite_name` VARCHAR(32)  NOT NULL,
  `music_id` BIGINT(20) UNSIGNED NOT NULL,
  `music_name` VARCHAR(32) NOT NULL,
  `artist_name` VARCHAR(32) NOT NULL,
  `create_time` INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `favorite_name` (`favorite_name`),
  KEY `music_id` (`music_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
-- 兼容后续自定义歌单，id不一定需要，可收藏我们曲库中没有的歌

-- 听歌记录表
CREATE TABLE `music_history`(
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT(20) UNSIGNED NOT NULL,
  `music_id` BIGINT(20) UNSIGNED NOT NULL,
  `music_name` VARCHAR(32) NOT NULL,
  `artist_name` VARCHAR(32) NOT NULL,
  `create_time` INT(11) UNSIGNED NOT NULL,
  `duration` INT(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 歌曲评论
CREATE TABLE `music_comment`(
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT(20) UNSIGNED NOT NULL,
  `user_name` VARCHAR(64) NOT NULL,
  `to_user_id` BIGINT(20) UNSIGNED NOT NULL,
  `to_user_name` VARCHAR(64) NOT NULL,
  `music_id` BIGINT(20) UNSIGNED NOT NULL,
  `music_name` VARCHAR(32) NOT NULL,
  `comment` VARCHAR(256) NOT NULL,
  `create_time` INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `music_id` (`music_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
-- 只针对我们的曲库中的歌进行评论,可以回

-- 未读消息记录表
CREATE TABLE `unreadmessages`(
  `message_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `send_user_id` BIGINT(20) UNSIGNED NOT NULL,
  `to_user_id` BIGINT(20) UNSIGNED NOT NULL,
  `message_type` TINYINT(4) NOT NULL,
  `content` VARCHAR(256) NOT NULL,
  `create_time` INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`message_id`),
  KEY `to_user_id` (`to_user_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
-- 系统消息默认有一个user_id,这里包括在歌曲评论下被回复的提醒
drop table unreadmessages;

CREATE TABLE unreadBoardcastMessages(
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `to_user_id` BIGINT(20) UNSIGNED,
  `message_id` INT UNSIGNED NOT NULL,
  `read` TINYINT(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `to_user_id` (`to_user_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 消息记录表
CREATE TABLE `messages`(
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `send_user_id` BIGINT(20) UNSIGNED NOT NULL,
  `to_user_id` BIGINT(20) UNSIGNED NOT NULL,
  `message_type` TINYINT(4) NOT NULL,  --0广播1个人
  `content` VARCHAR(256) NOT NULL,
  `create_time` INT(11) UNSIGNED NOT NULL,
  `title` VARCHAR(128) NOT NULL ,

  PRIMARY KEY (`id`),
  KEY `to_user_id` (`to_user_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
-- 消息记录