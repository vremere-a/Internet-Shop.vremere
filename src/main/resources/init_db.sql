CREATE SCHEMA `internet_shop` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `internet_shop`.`products` (
                                            `product_id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                            `product_name` VARCHAR(255) NOT NULL,
                                            `price` DECIMAL(10,2) NOT NULL,
                                            `deleted` TINYINT UNSIGNED NOT NULL DEFAULT 0,
                                            PRIMARY KEY (`product_id`));
# CREATE TABLE `internet_shop`.`products`
# (
#     `product_id`  BIGINT(11)   NOT NULL AUTO_INCREMENT,
#     `product_name` VARCHAR(255) NOT NULL,
#     `price`       DOUBLE       NOT NULL,
#     `deleted`     TINYINT      NULL DEFAULT 0,
#     PRIMARY KEY (`product_id`),
#     UNIQUE INDEX `productName_UNIQUE` (`product_name` ASC) VISIBLE
# );
CREATE TABLE `internet_shop`.`users` (
                                         `user_id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                         `user_name` VARCHAR(225) NOT NULL,
                                         `user_surname` VARCHAR(225) NOT NULL,
                                         `email` VARCHAR(225) NOT NULL,
                                         `login` VARCHAR(225) NOT NULL,
                                         `password` VARCHAR(225) NOT NULL,
                                         `salt` VARBINARY(16) NOT NULL,
                                         `deleted` TINYINT UNSIGNED NOT NULL DEFAULT 0,
                                         PRIMARY KEY (`user_id`),
                                         UNIQUE INDEX `name_UNIQUE` (`login` ASC) VISIBLE);
# CREATE TABLE `internet_shop`.`users`
# (
#     `user_id`      bigint       NOT NULL AUTO_INCREMENT,
#     `user_name`    varchar(255) NOT NULL,
#     `user_surname` varchar(255) NOT NULL,
#     `email`        varchar(255) NOT NULL,
#     `login`        varchar(255) NOT NULL,
#     `password`     varchar(255) NOT NULL,
#     `salt`         blob         NOT NULL,
#     `deleted`      tinyint      NOT NULL DEFAULT '0',
#     PRIMARY KEY (`user_id`),
#     UNIQUE KEY `login_UNIQUE` (`login`)
# ) ENGINE = InnoDB
#   AUTO_INCREMENT = 79
#   DEFAULT CHARSET = utf8;
CREATE TABLE `internet_shop`.`roles` (
                                         `role_id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                         `role_name` VARCHAR(225) NOT NULL,
                                         PRIMARY KEY (`role_id`),
                                         UNIQUE INDEX `role_name_UNIQUE` (`role_name` ASC) VISIBLE);
# CREATE TABLE `internet_shop`.`roles`
# (
#     `role_id`   BIGINT(11)   NOT NULL AUTO_INCREMENT,
#     `role_name` VARCHAR(256) NOT NULL,
#     PRIMARY KEY (`role_id`)
# );
CREATE TABLE `internet_shop`.`orders` (
                                          `order_id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                          `user_id` BIGINT(11) NOT NULL,
                                          `deleted` TINYINT UNSIGNED NOT NULL DEFAULT 0,
                                          PRIMARY KEY (`order_id`),
                                          INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
                                          CONSTRAINT `user_id`
                                              FOREIGN KEY (`user_id`)
                                                  REFERENCES `internet_shop`.`users` (`user_id`)
                                                  ON DELETE NO ACTION
                                                  ON UPDATE NO ACTION);
# CREATE TABLE `internet_shop`.`orders`
# (
#     `order_id` BIGINT(11) NOT NULL AUTO_INCREMENT,
#     `user_id`  BIGINT(11) NOT NULL,
#     PRIMARY KEY (`order_id`),
#     INDEX `orders_users_fk_idx` (`user_id` ASC) VISIBLE,
#     CONSTRAINT `orders_users_fk`
#         FOREIGN KEY (`user_id`)
#             REFERENCES `internet_shop`.`users` (`user_id`)
#             ON DELETE NO ACTION
#             ON UPDATE NO ACTION
# );


CREATE TABLE `internet_shop`.`shopping_carts` (
                                                  `cart_id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                                  `user_id` BIGINT(11) NOT NULL,
                                                  `deleted` TINYINT UNSIGNED NOT NULL DEFAULT 0,
                                                  PRIMARY KEY (`cart_id`),
                                                  INDEX `carts_users_fk_idx` (`user_id` ASC) VISIBLE,
                                                  CONSTRAINT `users_carts_fk`
                                                      FOREIGN KEY (`user_id`)
                                                          REFERENCES `internet_shop`.`users` (`user_id`)
                                                          ON DELETE NO ACTION
                                                          ON UPDATE NO ACTION);
# CREATE TABLE `internet_shop`.`shopping_carts`
# (
#     `cart_id` BIGINT(11) NOT NULL AUTO_INCREMENT,
#     `user_id` BIGINT(11) NOT NULL,
#     PRIMARY KEY (`cart_id`),
#     INDEX `carts_users_fk_idx` (`user_id` ASC) VISIBLE,
#     CONSTRAINT `users_carts_fk`
#         FOREIGN KEY (`user_id`)
#             REFERENCES `internet_shop`.`users` (`user_id`)
#             ON DELETE NO ACTION
#             ON UPDATE NO ACTION
# );
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
# CREATE TABLE `internet_shop`.`orders_products`
# (
#     `order_id`   bigint NOT NULL,
#     `product_id` bigint NOT NULL,
#     KEY `orders_products_fk_idx` (`order_id`),
#     KEY `products_orders_fk_idx` (`product_id`),
#     CONSTRAINT `orders_products_fk`
#         FOREIGN KEY (`order_id`)
#             REFERENCES `orders` (`order_id`)
#             ON DELETE NO ACTION
#             ON UPDATE NO ACTION,
#     CONSTRAINT `products_orders_fk`
#         FOREIGN KEY (`product_id`)
#             REFERENCES `products` (`product_id`)
#             ON DELETE NO ACTION
#             ON UPDATE NO ACTION
# ) ENGINE = InnoDB
#   DEFAULT CHARSET = utf8;

CREATE TABLE `internet_shop`.`shopping_carts_products` (
                                                           `cart_id` BIGINT(11) NOT NULL,
                                                           `product_id` BIGINT(11) NOT NULL,
                                                           INDEX `carts_products_fk_idx` (`cart_id` ASC) VISIBLE,
                                                           INDEX `products_carts_fk_idx` (`product_id` ASC) VISIBLE,
                                                           CONSTRAINT `carts_products_fk`
                                                               FOREIGN KEY (`cart_id`)
                                                                   REFERENCES `internet_shop`.`shopping_carts` (`cart_id`)
                                                                   ON DELETE NO ACTION
                                                                   ON UPDATE NO ACTION,
                                                           CONSTRAINT `products_carts_fk`
                                                               FOREIGN KEY (`product_id`)
                                                                   REFERENCES `internet_shop`.`products` (`product_id`)
                                                                   ON DELETE NO ACTION
                                                                   ON UPDATE NO ACTION);
# CREATE TABLE `internet_shop`.`shopping_carts_products`
# (
#     `cart_id`    BIGINT(11) NOT NULL,
#     `product_id` BIGINT(11) NOT NULL,
#     INDEX `carts_products_fk_idx` (`cart_id` ASC) VISIBLE,
#     INDEX `products_carts_fk_idx` (`product_id` ASC) VISIBLE,
#     CONSTRAINT `carts_products_fk`
#         FOREIGN KEY (`cart_id`)
#             REFERENCES `internet_shop`.`shopping_carts` (`cart_id`)
#             ON DELETE NO ACTION
#             ON UPDATE NO ACTION,
#     CONSTRAINT `products_carts_fk`
#         FOREIGN KEY (`product_id`)
#             REFERENCES `internet_shop`.`products` (`product_id`)
#             ON DELETE NO ACTION
#             ON UPDATE NO ACTION
# );


CREATE TABLE `internet_shop`.`users_roles` (
                                               `user_id` BIGINT(11) NOT NULL,
                                               `role_id` BIGINT(11) NOT NULL,
                                               INDEX `users_roles_fk_idx` (`user_id` ASC) VISIBLE,
                                               INDEX `roles_users_fk_idx` (`role_id` ASC) VISIBLE,
                                               CONSTRAINT `users_roles_fk`
                                                   FOREIGN KEY (`user_id`)
                                                       REFERENCES `internet_shop`.`users` (`user_id`)
                                                       ON DELETE NO ACTION
                                                       ON UPDATE NO ACTION,
                                               CONSTRAINT `roles_users_fk`
                                                   FOREIGN KEY (`role_id`)
                                                       REFERENCES `internet_shop`.`roles` (`role_id`)
                                                       ON DELETE NO ACTION
                                                       ON UPDATE NO ACTION);
# CREATE TABLE `internet_shop`.`users_roles`
# (
#     `user_id` BIGINT(11) NOT NULL,
#     `role_id` BIGINT(11) NOT NULL,
#     INDEX `users_roles_fk_idx` (`user_id` ASC) VISIBLE,
#     INDEX `roles_users_fk_idx` (`role_id` ASC) VISIBLE,
#     CONSTRAINT `users_roles_fk`
#         FOREIGN KEY (`user_id`)
#             REFERENCES `internet_shop`.`users` (`user_id`)
#             ON DELETE NO ACTION
#             ON UPDATE NO ACTION,
#     CONSTRAINT `roles_users_fk`
#         FOREIGN KEY (`role_id`)
#             REFERENCES `internet_shop`.`roles` (`role_id`)
#             ON DELETE NO ACTION
#             ON UPDATE NO ACTION
# );
# INSERT INTO `internet_shop`.`roles` (`role_name`) VALUES ('USER');
# INSERT INTO `internet_shop`.`roles` (`role_name`) VALUES ('ADMIN');
INSERT INTO `internet_shop`.`roles` (`role_id`, `role_name`)
VALUES ('1', 'USER');
INSERT INTO `internet_shop`.`roles` (`role_id`, `role_name`)
VALUES ('2', 'ADMIN');
