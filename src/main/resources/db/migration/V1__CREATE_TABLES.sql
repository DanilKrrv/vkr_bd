create table hibernate_sequence (
    next_val bigint
) engine=MyISAM;

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

CREATE TABLE user (
    id BIGINT NOT NULL AUTO_INCREMENT,
    password varchar(64) not null,
    login varchar(64) not null unique,
    FIO varchar(64) not null,
    PRIMARY KEY (id)
) engine=MyISAM;

CREATE TABLE attestation (
    id BIGINT NOT NULL AUTO_INCREMENT,
    title varchar(64) not null,
    isvalid BOOLEAN not null,
    datapassed varchar(64) not null,
    PRIMARY KEY (id)
) engine=MyISAM;

ALTER TABLE attestation
MODIFY COLUMN isvalid BOOLEAN DEFAULT NULL;

ALTER TABLE attestation
MODIFY COLUMN datapassed varchar(64) DEFAULT NULL;
