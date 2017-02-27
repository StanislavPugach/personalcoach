CREATE TABLE `ticket`
 (
 	`id` BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
     `seat` BIGINT NOT NULL,
     `price` FLOAT(7,2) NOT NULL,
     `flight` BIGINT NOT NULL,
     `sold` BOOLEAN NOT NULL,
     `booked` BOOLEAN NOT NULL,
     `deleted` BOOLEAN NOT NULL,
     FOREIGN KEY (seat) REFERENCES seat (id),
     FOREIGN KEY (flight) REFERENCES flight (id),
 )