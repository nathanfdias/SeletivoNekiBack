CREATE SCHEMA IF NOT EXISTS teste_residencia;

CREATE SEQUENCE teste_residencia.skill_seq;

CREATE SEQUENCE teste_residencia.user_seq;

CREATE SEQUENCE teste_residencia.user_skill_seq;

CREATE  TABLE teste_residencia.skill ( 
	id                   integer  NOT NULL ,
	name                 varchar(100)  NOT NULL ,
	"version"            varchar(10)   ,
	description          varchar(255)  NOT NULL ,
	image_url            varchar(255)   ,
	CONSTRAINT pk_skill_id PRIMARY KEY ( id )
 );

CREATE  TABLE teste_residencia."user" ( 
	id                   integer  NOT NULL ,
	login                varchar(12)  NOT NULL ,
	"password"           varchar(100)  NOT NULL ,
	last_login_date      date   ,
	CONSTRAINT pk_tbl_id PRIMARY KEY ( id )
 );

CREATE  TABLE teste_residencia.user_skill ( 
	id                   integer  NOT NULL ,
	user_id              integer  NOT NULL ,
	skill_id             integer  NOT NULL ,
	knowledge_level      integer  NOT NULL ,
	created_at           date  NOT NULL ,
	updated_at           date   ,
	CONSTRAINT pk_user_skill_id PRIMARY KEY ( id )
 );

COMMENT ON COLUMN teste_residencia.user_skill.knowledge_level IS 'de 1 a 10';

ALTER TABLE teste_residencia.user_skill ADD CONSTRAINT fk_user_skill_user FOREIGN KEY ( user_id ) REFERENCES teste_residencia."user"( id );

ALTER TABLE teste_residencia.user_skill ADD CONSTRAINT fk_user_skill_skill FOREIGN KEY ( skill_id ) REFERENCES teste_residencia.skill( id );