CREATE TABLE customers (
id int(11) NOT NULL AUTO_INCREMENT,
name varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
email  varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
PRIMARY KEY (`id`)
)DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE customer_orders (
id int(11) NOT NULL AUTO_INCREMENT,
customer_id int(11) NOT NULL DEFAULT '0',
total double(12,4) NOT NULL DEFAULT '0.0000',
date_created datetime NOT NULL,
PRIMARY KEY (`id`)
)DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE customer_order_products (
order_id int(11) NOT NULL DEFAULT '0',
product_id int(11) NOT NULL DEFAULT '0',
quantity int(11) NOT NULL DEFAULT '0',
PRIMARY KEY (`order_id`)
)DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE products (
id int(11) NOT NULL AUTO_INCREMENT,
name varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
price double(12,4) NOT NULL DEFAULT '0.0000',
PRIMARY KEY (`id`)
)DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO customers (name, email) VALUES ('Customer 1', 'customer1@test.com');
INSERT INTO customers (name, email) VALUES ('Customer 2', 'customer2@test.com');
INSERT INTO customers (name, email) VALUES ('Customer 3', 'customer3@test.com');
INSERT INTO customers (name, email) VALUES ('Customer 4', 'customer4@test.com');
INSERT INTO customers (name, email) VALUES ('Customer 5', 'customer5@test.com');

INSERT INTO products (name, price) VALUES ('Product 1', 10.0);
INSERT INTO products (name, price) VALUES ('Product 2', 20.0);
INSERT INTO products (name, price) VALUES ('Product 3', 30.0);
INSERT INTO products (name, price) VALUES ('Product 4', 40.0);
INSERT INTO products (name, price) VALUES ('Product 5', 50.0);