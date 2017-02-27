CREATE TABLE `seat`
 (
 	`id` BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
     `number` INTEGER NOT NULL,
     `business` BOOLEAN NOT NULL,
     `plane` BIGINT NOT NULL,
     FOREIGN KEY (plane) REFERENCES plane (id)
 )