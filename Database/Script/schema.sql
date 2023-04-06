--CREATE DATABASE spsmb;
--USE spsmb;

DROP TABLE IF EXISTS users;
CREATE TABLE users(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    name    VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS items;
CREATE TABLE items(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(50) NOT NULL UNIQUE,
    item_count  INT NOT NULL
);

DROP TABLE IF EXISTS users_items;
CREATE TABLE users_items (
    user_id     INT NOT NULL,
    item_id     INT NOT NULL,
    FOREIGN KEY(user_id) REFERENCES users(id),
    FOREIGN KEY(item_id) REFERENCES items(id)
);