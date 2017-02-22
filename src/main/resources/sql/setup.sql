CREATE DATABASE `flightbooking`;

USE `flightbooking`;

CREATE TABLE `location`
(
	`id` BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    `place` VARCHAR(128) NOT NULL
)

CREATE TABLE `plane`
(
	`id` BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    `model` VARCHAR(128) NOT NULL
)

CREATE TABLE `seat`
 (
 	`id` BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
     `number` INTEGER NOT NULL,
     `business` BOOLEAN NOT NULL,
     `plane` BIGINT NOT NULL,
     FOREIGN KEY (plane) REFERENCES plane (id)
 )

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
      FOREIGN KEY (flight) REFERENCES flight (id)
  )