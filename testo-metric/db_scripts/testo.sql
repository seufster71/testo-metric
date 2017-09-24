CREATE TABLE `messages`
	(`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`message` text,
	`is_active` bit(1) DEFAULT 1,
	`modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`created` timestamp NOT NULL DEFAULT '1970-01-01 00:00:01',
	`version` bigint(20) NOT NULL DEFAULT 0,
	PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;