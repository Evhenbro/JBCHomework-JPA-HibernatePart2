CREATE SCHEMA IF NOT EXISTS `departmentworkers` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;

CREATE TABLE IF NOT EXISTS `departmentworkers`.`department` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `status` BIT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `departmentworkers`.`workers` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `age` INT(11) NULL DEFAULT NULL,
  `availability` ENUM('FULL_TIME','PART_TIME') NULL DEFAULT NULL,
  `fullName` VARCHAR(255) NULL DEFAULT NULL,
  `departmentId_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKedchn47yy1beede8be2ianbhe` (`departmentId_id` ASC) VISIBLE,
  CONSTRAINT `FKedchn47yy1beede8be2ianbhe`
    FOREIGN KEY (`departmentId_id`)
    REFERENCES `departmentworkers`.`department` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;





INSERT INTO departmentworkers.department (name, status) values ('mathematics', true);

INSERT INTO departmentworkers.department (name, status) values ('geography', false);

INSERT INTO departmentworkers.department (name, status) values ('physics', false);

INSERT INTO departmentworkers.department (name, status) values ('history', true);

INSERT INTO departmentworkers.department (name, status) values ('ecology', true);

INSERT INTO departmentworkers.department (name, status) values ('department1', true);
INSERT INTO departmentworkers.workers (age, availability, fullName, departmentId_id) values (27, 'FULL_TIME', 'Yevhen_Yarema', 1);

INSERT INTO departmentworkers.workers (age, availability, fullName, departmentId_id) values (12, 'FULL_TIME', 'Zhekalo_Pavlo', 1);

INSERT INTO departmentworkers.workers (age, availability, fullName, departmentId_id) values (56, 'FULL_TIME', 'Barabashka_Svitlana', 2);

INSERT INTO departmentworkers.workers (age, availability, fullName, departmentId_id) values (28, 'FULL_TIME', 'Fritz_Hunter', 2);

INSERT INTO departmentworkers.workers (age, availability, fullName, departmentId_id) values (21, 'FULL_TIME', 'Gerechko_Tetiana', 3);

INSERT INTO departmentworkers.workers (age, availability, fullName, departmentId_id) values (32, 'FULL_TIME', 'Sosna_Ania', 3);

INSERT INTO departmentworkers.workers (age, availability, fullName, departmentId_id) values (19, 'FULL_TIME', 'Gelner_Volodymyr', 4);

INSERT INTO departmentworkers.workers (age, availability, fullName, departmentId_id) values (30, 'FULL_TIME', 'Kuz_Igor', 4);

INSERT INTO departmentworkers.workers (age, availability, fullName, departmentId_id) values (26, 'FULL_TIME', 'Senyk_Oleg', 5);

INSERT INTO departmentworkers.workers (age, availability, fullName, departmentId_id) values (27, 'FULL_TIME', 'Huk_Olia', 5);

INSERT INTO departmentworkers.workers (age, availability, fullName, departmentId_id) values (38, 'FULL_TIME', 'Fediv_Vasyl', 6);

INSERT INTO departmentworkers.workers (age, availability, fullName, departmentId_id) values (60, 'FULL_TIME', 'Bybkin_Petro', 6);
