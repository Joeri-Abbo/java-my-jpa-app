CREATE TABLE `bookstoredb`.`bookstore_table`(`gen_name` VARCHAR(16) NOT NULL, `gen_val` int NOT NULL);
INSERT INTO `bookstoredb`.`bookstore_table` VALUES ("book_id", 1)
INSERT INTO `bookstoredb`.`bookstore_table` VALUES ("author_id", 1000)
CREATE TABLE `bookstoredb`.`Book`(`id` INT NOT NULL, `author` VARCHAR(64), `price` float, `title` VARCHAR(128));
CREATE TABLE `bookstoredb`.`Author`(`id` INT NOT NULL, `name` VARCHAR(128), `birthDate` DATETIME);