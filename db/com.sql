-- MySQL Script generated by MySQL Workbench
-- Tue Apr 11 23:28:22 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema com
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `com` ;

-- -----------------------------------------------------
-- Schema com
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `com` DEFAULT CHARACTER SET utf8mb4 ;
SHOW WARNINGS;
USE `com` ;

-- -----------------------------------------------------
-- Table `com`.`enum_protocol`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `com`.`enum_protocol` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `com`.`enum_protocol` (
  `id` INT UNSIGNED NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `modify_ts` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UQ_PROTOCOL_NAME` (`name` ASC))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `com`.`master_site`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `com`.`master_site` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `com`.`master_site` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `protocol` INT UNSIGNED NOT NULL,
  `host` VARCHAR(45) NOT NULL,
  `description` VARCHAR(512) NULL,
  `create_utc` BIGINT NOT NULL,
  `update_utc` BIGINT NOT NULL,
  `modify_ts` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UQ_SITE` (`protocol` ASC, `host` ASC),
  CONSTRAINT `FK_SITE_PK_PROTOCOL`
    FOREIGN KEY (`protocol`)
    REFERENCES `com`.`enum_protocol` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `com`.`master_layout`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `com`.`master_layout` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `com`.`master_layout` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `site` INT(10) UNSIGNED NOT NULL,
  `name` VARCHAR(128) NOT NULL,
  `description` VARCHAR(512) NULL,
  `create_utc` BIGINT NOT NULL,
  `update_utc` BIGINT NOT NULL,
  `modify_ts` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UQ_LAYOUT` (`site` ASC, `name` ASC),
  CONSTRAINT `FK_LAYOUT_PK_SITE`
    FOREIGN KEY (`site`)
    REFERENCES `com`.`master_site` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `com`.`master_page`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `com`.`master_page` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `com`.`master_page` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `site` INT(10) UNSIGNED NOT NULL,
  `path` VARCHAR(45) NOT NULL,
  `title` VARCHAR(128) NOT NULL,
  `description` VARCHAR(512) NULL,
  `layout` INT(10) UNSIGNED NOT NULL,
  `create_utc` BIGINT NOT NULL,
  `update_utc` BIGINT NOT NULL,
  `modify_ts` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UQ_PAGE` (`site` ASC, `path` ASC),
  INDEX `FK_PAGE_PK_LAYOUT` (`layout` ASC),
  CONSTRAINT `FK_PAGE_PK_SITE`
    FOREIGN KEY (`site`)
    REFERENCES `com`.`master_site` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_PAGE_PK_LAYOUT`
    FOREIGN KEY (`layout`)
    REFERENCES `com`.`master_layout` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `com`.`master_fraction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `com`.`master_fraction` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `com`.`master_fraction` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL,
  `template` VARCHAR(128) NOT NULL,
  `description` VARCHAR(512) NULL,
  `create_utc` BIGINT NOT NULL,
  `update_utc` BIGINT NOT NULL,
  `modify_ts` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `com`.`rel_layout_fraction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `com`.`rel_layout_fraction` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `com`.`rel_layout_fraction` (
  `layout` INT(10) UNSIGNED NOT NULL,
  `fraction` INT UNSIGNED NOT NULL,
  `modify_ts` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`layout`, `fraction`),
  UNIQUE INDEX `REVERSE_PRIMARY` (`fraction` ASC, `layout` ASC),
  CONSTRAINT `REL_FRACTION_TO_LAYOUT`
    FOREIGN KEY (`layout`)
    REFERENCES `com`.`master_layout` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `REL_LAYOUT_TO_FRACTION`
    FOREIGN KEY (`fraction`)
    REFERENCES `com`.`master_fraction` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
USE `com` ;

-- -----------------------------------------------------
-- View `com`.`view_site`
-- -----------------------------------------------------
DROP VIEW IF EXISTS `com`.`view_site` ;
SHOW WARNINGS;
USE `com`;
CREATE  OR REPLACE VIEW `view_site` AS
SELECT
  `s`.`id`,
  `p`.`name` AS `protocol`,
  `s`.`host`,
  `s`.`description`,
  `s`.`create_utc`,
  `s`.`update_utc`
FROM
  `master_site` AS `s`,
  `enum_protocol` AS `p`
WHERE
  `s`.`protocol` = `p`.`id`
ORDER BY
  `s`.`id` ASC
;
SHOW WARNINGS;

-- -----------------------------------------------------
-- View `com`.`view_page`
-- -----------------------------------------------------
DROP VIEW IF EXISTS `com`.`view_page` ;
SHOW WARNINGS;
USE `com`;
CREATE  OR REPLACE VIEW `view_page` AS
SELECT
  `p`.`id`,
  `enum_protocol`.`name` AS `protocol`,
  `s`.`host`,
  `p`.`path`,
  `p`.`title`,
  `l`.`name` AS `layout`,
  `p`.`description`,
  `p`.`create_utc`,
  `p`.`update_utc`,
  `p`.`modify_ts`
FROM
  `master_page` AS `p`,
  `master_site` AS `s`,
  `enum_protocol`,
  `master_layout` AS `l`
WHERE
  `p`.`site` = `s`.`id`
  AND `s`.`protocol` = `enum_protocol`.`id`
  AND `p`.`layout` = `l`.`id`
ORDER BY
  `p`.`id` ASC
;
SHOW WARNINGS;

-- -----------------------------------------------------
-- View `com`.`view_layout`
-- -----------------------------------------------------
DROP VIEW IF EXISTS `com`.`view_layout` ;
SHOW WARNINGS;
USE `com`;
CREATE  OR REPLACE VIEW `view_layout` AS
SELECT
  `l`.`id`,
  `enum_protocol`.`name` AS `protocol`,
  `s`.`host`,
  `l`.`name`,
  `l`.`description`,
  `l`.`create_utc`,
  `l`.`update_utc`,
  `l`.`modify_ts`
FROM
  `master_layout` AS `l`,
  `master_site` AS `s`,
  `enum_protocol`
WHERE
  `l`.`site` = `s`.`id`
  AND `s`.`protocol` = `enum_protocol`.`id`
ORDER BY
  `l`.`id` ASC
;
SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `com`.`enum_protocol`
-- -----------------------------------------------------
START TRANSACTION;
USE `com`;
INSERT INTO `com`.`enum_protocol` (`id`, `name`, `modify_ts`) VALUES (0, 'HTTP', DEFAULT);
INSERT INTO `com`.`enum_protocol` (`id`, `name`, `modify_ts`) VALUES (1, 'HTTPS', DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `com`.`master_site`
-- -----------------------------------------------------
START TRANSACTION;
USE `com`;
INSERT INTO `com`.`master_site` (`id`, `protocol`, `host`, `description`, `create_utc`, `update_utc`, `modify_ts`) VALUES (DEFAULT, 0, 'example.com', 'example site.', 0, 0, DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `com`.`master_layout`
-- -----------------------------------------------------
START TRANSACTION;
USE `com`;
INSERT INTO `com`.`master_layout` (`id`, `site`, `name`, `description`, `create_utc`, `update_utc`, `modify_ts`) VALUES (DEFAULT, 1, 'default1', 'default layout #1.', 0, 0, DEFAULT);
INSERT INTO `com`.`master_layout` (`id`, `site`, `name`, `description`, `create_utc`, `update_utc`, `modify_ts`) VALUES (DEFAULT, 1, 'default2', 'default layout #2.', 0, 0, DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `com`.`master_page`
-- -----------------------------------------------------
START TRANSACTION;
USE `com`;
INSERT INTO `com`.`master_page` (`id`, `site`, `path`, `title`, `description`, `layout`, `create_utc`, `update_utc`, `modify_ts`) VALUES (DEFAULT, 1, '', 'INDEX', 'example index page.', 1, 0, 0, DEFAULT);
INSERT INTO `com`.`master_page` (`id`, `site`, `path`, `title`, `description`, `layout`, `create_utc`, `update_utc`, `modify_ts`) VALUES (DEFAULT, 1, 'test', 'TEST', 'example test(sub) page.', 2, 0, 0, DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `com`.`master_fraction`
-- -----------------------------------------------------
START TRANSACTION;
USE `com`;
INSERT INTO `com`.`master_fraction` (`id`, `name`, `template`, `description`, `create_utc`, `update_utc`, `modify_ts`) VALUES (DEFAULT, 'content', 'example/content', 'Simpl page zone placeholder content.', 0, 0, DEFAULT);
INSERT INTO `com`.`master_fraction` (`id`, `name`, `template`, `description`, `create_utc`, `update_utc`, `modify_ts`) VALUES (DEFAULT, 'header', 'example/header', 'Simpl page zone placeholder header.', 0, 0, DEFAULT);
INSERT INTO `com`.`master_fraction` (`id`, `name`, `template`, `description`, `create_utc`, `update_utc`, `modify_ts`) VALUES (DEFAULT, 'footer', 'example/footer', 'Simpl page zone placeholder footer.', 0, 0, DEFAULT);
INSERT INTO `com`.`master_fraction` (`id`, `name`, `template`, `description`, `create_utc`, `update_utc`, `modify_ts`) VALUES (DEFAULT, 'sidebar', 'example/sidebar', 'Simpl page zone placeholder sidebar.', 0, 0, DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `com`.`rel_layout_fraction`
-- -----------------------------------------------------
START TRANSACTION;
USE `com`;
INSERT INTO `com`.`rel_layout_fraction` (`layout`, `fraction`, `modify_ts`) VALUES (1, 1, DEFAULT);
INSERT INTO `com`.`rel_layout_fraction` (`layout`, `fraction`, `modify_ts`) VALUES (1, 2, DEFAULT);
INSERT INTO `com`.`rel_layout_fraction` (`layout`, `fraction`, `modify_ts`) VALUES (1, 3, DEFAULT);
INSERT INTO `com`.`rel_layout_fraction` (`layout`, `fraction`, `modify_ts`) VALUES (1, 4, DEFAULT);
INSERT INTO `com`.`rel_layout_fraction` (`layout`, `fraction`, `modify_ts`) VALUES (2, 1, DEFAULT);

COMMIT;

