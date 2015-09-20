CREATE TABLE `organization` (
  `organization_id` int(11) NOT NULL AUTO_INCREMENT,
  `market_area` varchar(10) NOT NULL,
  `business_manager` varchar(15) NOT NULL,
  `busniess_assistant` varchar(15) NOT NULL,
  `finance` varchar(15) NOT NULL,
  PRIMARY KEY (`organization_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_code` varchar(10) NOT NULL DEFAULT 'GTW',
  `type` varchar(8) NOT NULL DEFAULT 'STD',
  `Group_company` varchar(10) DEFAULT NULL,
  `Corporation` varchar(10) DEFAULT NULL,
  `organization_id` int(11) NOT NULL,
  `customer_name` varchar(120) NOT NULL DEFAULT 'Greate Tesla World Co.,Ltd',
  PRIMARY KEY (`customer_id`),
  KEY `for_origanization_id` (`organization_id`),
  CONSTRAINT `for_origanization_id` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`organization_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


CREATE TABLE `address` (
  `address_id` int(11) NOT NULL,
  `country` varchar(20) NOT NULL DEFAULT 'USA',
  `state` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `address_line1` varchar(100) DEFAULT NULL,
  `address_line2` varchar(100) DEFAULT NULL,
  `postcode` varchar(15) DEFAULT NULL,
  `port_of_destination` varchar(20) NOT NULL DEFAULT 'Los Angeles',
  `shipping_mark` varchar(100) NOT NULL DEFAULT 'dsadasasda',
  `status` varchar(6) DEFAULT NULL,
  `inactuve_date` datetime DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  CONSTRAINT `foraddr_customer_id` FOREIGN KEY (`address_id`) REFERENCES `customer` (`customer_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `linkman` (
  `customer_id` int(11) NOT NULL,
  `mailfrom` varchar(50) DEFAULT NULL,
  `prepo_mailto` varchar(200) DEFAULT NULL,
  `po_mailto` varchar(200) DEFAULT NULL,
  `ocpi_mailto` varchar(200) DEFAULT NULL,
  `inv_pklist_mailto` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  CONSTRAINT `forlink_customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `om_normal_discount` (
  `normal_id` int(11) NOT NULL AUTO_INCREMENT,
  `discount_name` varchar(30) NOT NULL DEFAULT '3%折扣',
  `type` varchar(8) NOT NULL DEFAULT '一般折扣',
  `discount_base` varchar(8) NOT NULL DEFAULT '金额',
  `base_qty` int(8) DEFAULT NULL,
  `discount_rate` int(8) NOT NULL DEFAULT '0',
  `activity` varchar(2) NOT NULL DEFAULT '是',
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`normal_id`),
  KEY `fornor_cuetomer_id` (`customer_id`),
  CONSTRAINT `fornor_cuetomer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `om_special_discount` (
  `special_id` int(11) NOT NULL AUTO_INCREMENT,
  `discount_name` varchar(30) NOT NULL DEFAULT 'GTW2015年返',
  `cust_code` varchar(10) NOT NULL DEFAULT 'GTW',
  `amount` varchar(15) NOT NULL DEFAULT '20000',
  `applied_amount` int(15) DEFAULT NULL,
  `balance` int(15) NOT NULL,
  `activity` varchar(2) NOT NULL DEFAULT '是',
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`special_id`),
  KEY `forsp_custoemr_id` (`customer_id`),
  CONSTRAINT `forsp_custoemr_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `on_discount_applied_records` (
  `applied_id` int(11) NOT NULL AUTO_INCREMENT,
  `dicount_name` varchar(30) NOT NULL,
  `cust_code` varchar(10) NOT NULL,
  `adn_identify_num` varchar(30) NOT NULL,
  `applied_amount` int(15) NOT NULL,
  `applied_date` datetime NOT NULL,
  `cancel` int(2) DEFAULT NULL,
  `cancel_date` datetime DEFAULT NULL,
  `customer_id` int(15) NOT NULL,
  PRIMARY KEY (`applied_id`),
  KEY `forapp_customer_id` (`customer_id`),
  CONSTRAINT `forapp_customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL AUTO_INCREMENT,
  `invoice_group` varchar(20) DEFAULT NULL,
  `currency` varchar(3) NOT NULL DEFAULT 'USD',
  `payment_term` varchar(120) NOT NULL DEFAULT '60天后付款',
  `price_iterm1` varchar(100) DEFAULT NULL,
  `price_iterm2` varchar(100) DEFAULT NULL,
  `price_iterm3` varchar(100) DEFAULT NULL,
  `markup_name` varchar(20) NOT NULL DEFAULT '低于50片加价5%',
  `discount_name` varchar(20) NOT NULL,
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `for_customer_id` (`customer_id`),
  CONSTRAINT `for_customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;







CREATE TABLE `priceconfig` (
  `price_config_id` int(11) NOT NULL AUTO_INCREMENT,
  `cust_code` varchar(120) NOT NULL DEFAULT 'GTW',
  `type` varchar(8) NOT NULL DEFAULT 'STD',
  `display_name` varchar(30) DEFAULT NULL,
  `prive_list_col` varchar(30) NOT NULL DEFAULT 'User_def3',
  `excel_col` int(3) DEFAULT NULL,
  `activity` varchar(2) NOT NULL DEFAULT '是',
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`price_config_id`),
  KEY `for_customer_id` (`customer_id`),
  CONSTRAINT `for_config_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


CREATE TABLE `price` (
  `price_id` int(11) NOT NULL AUTO_INCREMENT,
  `pl_cust_code` varchar(10) NOT NULL DEFAULT 'GTW',
  `type` varchar(8) NOT NULL DEFAULT 'STD',
  `pl_yh_item` varchar(20) NOT NULL DEFAULT 'YH21422',
  `effective_date_from` datetime DEFAULT NULL,
  `effective_date_to` datetime DEFAULT NULL,
  `user_def1` varchar(20) DEFAULT NULL,
  `user_def2` varchar(20) DEFAULT NULL,
  `user_def3` varchar(20) DEFAULT NULL,
  `user_def4` varchar(20) DEFAULT NULL,
  `user_def5` varchar(20) DEFAULT NULL,
  `user_def6` varchar(20) DEFAULT NULL,
  `user_def7` varchar(20) DEFAULT NULL,
  `user_def8` varchar(20) DEFAULT NULL,
  `user_def9` varchar(20) DEFAULT NULL,
  `user_def10` varchar(20) DEFAULT NULL,
  `user_def11` varchar(20) DEFAULT NULL,
  `user_def12` varchar(20) DEFAULT NULL,
  `user_def13` varchar(20) DEFAULT NULL,
  `user_def14` varchar(20) DEFAULT NULL,
  `user_def15` varchar(20) DEFAULT NULL,
  `user_def16` varchar(20) DEFAULT NULL,
  `user_def17` varchar(20) DEFAULT NULL,
  `user_def18` varchar(20) DEFAULT NULL,
  `user_def19` varchar(20) DEFAULT NULL,
  `user_def20` varchar(20) DEFAULT NULL,
  `user_def21` varchar(20) DEFAULT NULL,
  `user_def22` varchar(20) DEFAULT NULL,
  `user_def23` varchar(20) DEFAULT NULL,
  `user_def24` varchar(20) DEFAULT NULL,
  `user_def25` varchar(20) DEFAULT NULL,
  `user_def26` varchar(20) DEFAULT NULL,
  `user_def27` varchar(20) DEFAULT NULL,
  `user_def28` varchar(20) DEFAULT NULL,
  `user_def29` varchar(20) DEFAULT NULL,
  `user_def30` varchar(20) DEFAULT NULL,
  `priceconfig_id` int(11) NOT NULL,
  PRIMARY KEY (`price_id`),
  KEY `idx_fk_priceconfig_id` (`priceconfig_id`) USING BTREE,
  CONSTRAINT `fk_price_priceconfig` FOREIGN KEY (`priceconfig_id`) REFERENCES `priceconfig` (`price_config_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

