CREATE SCHEMA `internet_shop` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `internet_shop`.`products` (
  `product_id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `productName` VARCHAR(255) NOT NULL,
  `price` DOUBLE NOT NULL,
  `deleted` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`product_id`),
  UNIQUE INDEX `productName_UNIQUE` (`productName` ASC) VISIBLE);

CREATE TABLE `internet_shop`.`orders` (
                                          `order_id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                          `user_id` BIGINT(11) NOT NULL,
                                          PRIMARY KEY (`order_id`),
                                          INDEX `orders_users_fk_idx` (`user_id` ASC) VISIBLE,
                                          CONSTRAINT `orders_users_fk`
                                              FOREIGN KEY (`user_id`)
                                                  REFERENCES `internet_shop`.`users` (`user_id`)
                                                  ON DELETE NO ACTION
                                                  ON UPDATE NO ACTION);


CREATE TABLE `internet_shop`.`orders_products` (
                                                   `order_id` BIGINT(11) NOT NULL,
                                                   `product_id` BIGINT(11) NOT NULL,
                                                   INDEX `orders_products_fk_idx` (`order_id` ASC) VISIBLE,
                                                   INDEX `products_orders_fk_idx` (`product_id` ASC) VISIBLE,
                                                   CONSTRAINT `orders_products_fk`
                                                       FOREIGN KEY (`order_id`)
                                                           REFERENCES `internet_shop`.`orders` (`order_id`)
                                                           ON DELETE NO ACTION
                                                           ON UPDATE NO ACTION,
                                                   CONSTRAINT `products_orders_fk`
                                                       FOREIGN KEY (`product_id`)
                                                           REFERENCES `internet_shop`.`products` (`product_id`)
                                                           ON DELETE NO ACTION
                                                           ON UPDATE NO ACTION);