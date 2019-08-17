-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2019 年 07 月 08 日 13:48
-- 服务器版本: 5.6.12-log
-- PHP 版本: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `shopping`
--
CREATE DATABASE IF NOT EXISTS `shopping` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `shopping`;

-- --------------------------------------------------------

--
-- 表的结构 `c3p0testtable`
--

CREATE TABLE IF NOT EXISTS `c3p0testtable` (
  `a` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `t_carousel`
--

CREATE TABLE IF NOT EXISTS `t_carousel` (
  `carousel_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `img_url` varchar(255) DEFAULT NULL,
  `sort_num` int(11) DEFAULT NULL,
  `target_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`carousel_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `t_carousel`
--

INSERT INTO `t_carousel` (`carousel_id`, `img_url`, `sort_num`, `target_id`) VALUES
(1, '/files/carousel/1/TB1ghY2dQxz61VjSZFtSuuDSVXa.jpg_q90_.webp', 1, 'https://pages.tmall.com/wow/a/act/tmall/tmc/22993/wupr?spm=a21bo.2017.201862-1.d1.5af911d9BY1OBG&pos=1&wh_pid=industry-163523&acm=20140506001.1003.2.6210603&scm=1003.2.20140506001.OTHER_1563969777532_6210603'),
(2, '/files/carousel/1/TB1oOfUe8Cw3KVjSZFlSuwJkFXa.jpg_q90_.webp', 2, 'https://pages.tmall.com/wow/a/act/tmall/tmc/22993/wupr?spm=a21bo.2017.201862-5.d1.5af911d9BY1OBG&pos=1&wh_pid=main-163635&acm=20140506002.1003.2.6208924&scm=1003.2.20140506002.OTHER_1563211425994_6208924'),
(3, '/files/carousel/1/TB1JNHwKFXXXXafXVXXSutbFXXX.jpg', 10, 'http://www.bai.com');

-- --------------------------------------------------------

--
-- 表的结构 `t_feedback`
--

CREATE TABLE IF NOT EXISTS `t_feedback` (
  `feedback_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`feedback_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- 转存表中的数据 `t_feedback`
--

INSERT INTO `t_feedback` (`feedback_id`, `content`, `create_time`, `email`, `name`, `phone`) VALUES
(1, '你好', NULL, '123@qq.com', '小明', '13433633333');

-- --------------------------------------------------------

--
-- 表的结构 `t_goods`
--

CREATE TABLE IF NOT EXISTS `t_goods` (
  `goods_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `img_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `num` int(11) NOT NULL,
  `price` float DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `produce` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=14 ;

--
-- 转存表中的数据 `t_goods`
--

INSERT INTO `t_goods` (`goods_id`, `img_url`, `name`, `num`, `price`, `type`, `produce`) VALUES
(1, '/files/goods/1/O1CN01YnbMeY1CP12CO1zxx_!!0-item_pic.jpg_430x430q90.jpg', 'java从入门精通', 0, 40, '图书', '【清华正版】Java从入门到精通(第5五版) java语言程序设计电脑编程思想软件开发教程javascript计算机自学书籍JAVA入门精通零基础'),
(2, '/files/goods/1/O1CN01k48iHk2NQoYLbL2xf_!!0-saturn_solar.jpg_230x230.jpg_.webp', '男士短袖', 0, 80, '衣服', '男士短袖t恤韩版潮流宽松五分袖夏季潮牌青少年半袖体恤夏装衣服'),
(3, '/files/goods/1/6.jpg', 'python基础教程', 0, 39, '图书', 'python基础教程 零基础学Python3.5编程从入门到实践 精通计算机程序设计pathon核心技术网络爬虫书籍 赠源代码/视频课程小甲鱼'),
(4, '/files/goods/1/5.jpg', '青少年体恤男', 0, 30, '衣服', '森马男装2019新款男士短袖t恤纯棉夏装字母刺绣宽松圆领体恤潮流'),
(5, '/files/goods/1/7.jpg', '显瘦大码女装', 0, 50, '衣服', '2019夏季新款女装条纹T恤衫短袖V领百搭时尚修身打底显瘦大码女装'),
(6, '/files/goods/1/7.jpg', '半袖上衣潮', 0, 100, '衣服', '短袖T恤女2019夏新款韩版斜领露肩显瘦露锁骨洋气纯色半袖上衣潮'),
(7, '/files/goods/1/10.jpg', '零食早餐', 0, 10, '食品', '巴莉甜甜滇式手工诺邓火腿饼礼盒装糕点休闲好吃的美食零食早餐'),
(8, '/files/goods/1/12.jpg', '螺狮粉', 0, 112, '食品', '好欢螺螺蛳粉柳州螺狮粉美食速食方便面300g*10袋礼盒酸辣粉包邮'),
(9, '/files/goods/1/13.jpg', '三只松鼠_猪肉脯', 0, 50, '食品', '【三只松鼠_猪肉脯210g】休闲食品网红零食肉脯特产美食靖江熟食'),
(10, '/files/goods/1/14.jpg', '黄山烧饼', 0, 16, '食品', '正宗安徽特产黄山烧饼60个梅干菜扣肉酥饼网红美食糕点心零食小吃'),
(11, '/files/goods/1/16.jpg', '螺蛳粉', 0, 58, '食品', '好欢螺螺蛳粉柳州特产美食酸辣粉300gx5袋螺狮粉速食方便面米线'),
(13, '/files/goods/1/TB1JNHwKFXXXXafXVXXSutbFXXX.jpg', '美食', 0, 10, '食品', '好吃的');

-- --------------------------------------------------------

--
-- 表的结构 `t_goods_type`
--

CREATE TABLE IF NOT EXISTS `t_goods_type` (
  `goods_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`goods_type_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- 转存表中的数据 `t_goods_type`
--

INSERT INTO `t_goods_type` (`goods_type_id`, `name`) VALUES
(1, '图书'),
(2, '衣服'),
(3, '食品'),
(4, '家具'),
(5, '乐器'),
(7, '家具');

-- --------------------------------------------------------

--
-- 表的结构 `t_item`
--

CREATE TABLE IF NOT EXISTS `t_item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `num` int(11) NOT NULL,
  `goods_goods_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `orderform_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `FK4xp14bh0kcxr3tgvmtkxo307p` (`goods_goods_id`),
  KEY `FKku8nqsw0766wx10d1tyb8pn3m` (`orderform_id`),
  KEY `FKebcgybi16p9sqlkv0dhbdsfu2` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

--
-- 转存表中的数据 `t_item`
--

INSERT INTO `t_item` (`item_id`, `num`, `goods_goods_id`, `user_id`, `orderform_id`) VALUES
(10, 1, 1, NULL, 4),
(11, 1, 1, NULL, 5);

-- --------------------------------------------------------

--
-- 表的结构 `t_keyword`
--

CREATE TABLE IF NOT EXISTS `t_keyword` (
  `keyword_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `about_us` longtext,
  `address` varchar(255) DEFAULT NULL,
  `common_problem` longtext,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `two_bar_code_url` varchar(255) DEFAULT NULL,
  `user_agreement` longtext,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`keyword_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- 转存表中的数据 `t_keyword`
--

INSERT INTO `t_keyword` (`keyword_id`, `about_us`, `address`, `common_problem`, `email`, `phone`, `two_bar_code_url`, `user_agreement`, `name`) VALUES
(1, '1', '欢迎光临本店，本店新开张，诚信经营，只赚信誉不赚钱。\n　　本店商品均属正品，假一罚十信誉保证。 欢迎广大顾客前来放心选购，我们将竭诚为您服务!\n　　本店专门营销什么什么商品，假一罚十信誉保证。本店的服务宗旨是用心服务，以诚待人!', '3', '123@qq.com', '13433643333', '/files/twocode/1/VQ{_`UP4X07B8}PAZPRGQVR.png', '2', '小鸡鸡');

-- --------------------------------------------------------

--
-- 表的结构 `t_orderform`
--

CREATE TABLE IF NOT EXISTS `t_orderform` (
  `orderform_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `price` float NOT NULL,
  `status` int(11) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`orderform_id`),
  KEY `FKlohhkcosqp35g8tfklsgb41c9` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `t_orderform`
--

INSERT INTO `t_orderform` (`orderform_id`, `address`, `price`, `status`, `user_id`) VALUES
(4, '广东省茂名市', 12, 3, 1),
(5, '广东省茂名市', 40, 3, 1);

-- --------------------------------------------------------

--
-- 表的结构 `t_user`
--

CREATE TABLE IF NOT EXISTS `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `t_user`
--

INSERT INTO `t_user` (`id`, `nickname`, `password`, `salt`, `username`, `create_time`, `phone`) VALUES
(1, NULL, 'JnKZh4hLYRsJQfwqeMa9hQ==', '@hffimvk0g8i5c^', 'user', '2019-06-27 22:33:33', '13433643333'),
(2, NULL, 'JnKZh4hLYRsJQfwqeMa9hQ==', '@hffimvk0g8i5c^', '小明', '2019-06-27 22:33:33', '13433643333');

--
-- 限制导出的表
--

--
-- 限制表 `t_item`
--
ALTER TABLE `t_item`
  ADD CONSTRAINT `FK4xp14bh0kcxr3tgvmtkxo307p` FOREIGN KEY (`goods_goods_id`) REFERENCES `t_goods` (`goods_id`),
  ADD CONSTRAINT `FKebcgybi16p9sqlkv0dhbdsfu2` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  ADD CONSTRAINT `FKku8nqsw0766wx10d1tyb8pn3m` FOREIGN KEY (`orderform_id`) REFERENCES `t_orderform` (`orderform_id`);

--
-- 限制表 `t_orderform`
--
ALTER TABLE `t_orderform`
  ADD CONSTRAINT `FKlohhkcosqp35g8tfklsgb41c9` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
