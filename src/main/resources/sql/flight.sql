  CREATE TABLE `flight`
(
	`id` BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    `flight_number` VARCHAR(128) NOT NULL,
    `plane` BIGINT NOT NULL,
    `departure` BIGINT NOT NULL,
    `arrival` BIGINT NOT NULL,
    `departure_date` DATE NOT NULL,
    `arrival_date` DATE NOT NULL,
     FOREIGN KEY (plane) REFERENCES plane (id),
     FOREIGN KEY (departure) REFERENCES location (id),
     FOREIGN KEY (arrival) REFERENCES location (id)
)

