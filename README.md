# Processo Seletivo Neki
React project consuming API

* [FrontEnd Repository](https://github.com/nathanfdias/SeletivoNekiBack/) 
* [BackEnd Repository](https://github.com/nathanfdias/SeletivoNekiFront/) 

![Badge em Desenvolvimento](https://img.shields.io/static/v1?label=STATUS&message=FINALIZADO&color=GREEN&style=for-the-badge)
 
--- 

## 📋 Índice

- [Observações](#-observações)
- [Tecnologias utilizadas](#-tecnologias-utilizadas)
- [Como executar o projeto](#-como-executar-o-projeto)
- [Construído com](#%EF%B8%8F-construído-com)
- [Autor](#%EF%B8%8F-autor)
- [Banco](#%EF%B8%8F-autor)

---

## 🚀 Observações

1- User: usuários que não ultilizarem do lembrar de mim terão que relogar ao atualizarem suas skills!</br>
2- Token: Uso do token contido na API, porém consumo no Front dificultado pela função do usuário de não ser lembrado, assim não sendo liberado pelo LocalStorage, onde Token estaria contido.</br>
3- Script de Banco Alterado: Apenas PK alterada para relacionamento.</br>


--- 

## 🚀 Tecnologias utilizadas

O projeto está desenvolvido utilizando as seguintes tecnologias:

- CSS 3
- HTML 5
- JAVASCRIPT
- REACT
- API Rest: JAVA 11
- Spring Boot

--- 

## ⌨ Como executar o projeto

Apenas instalando os arquivos de projeto:
  - API LocalHost
  - Npm Install Arquivos Front

--- 

## 🛠️ Construído com

* [Visual Studio Code](https://code.visualstudio.com/) - ferramenta de desenvolvimento

--- 

## ✒️ Autor

  * [Nathan Dias](https://github.com/nathanfdias/) 

--- 
 
## 🎁 Expressões de gratidão

* Conte a outras pessoas sobre este projeto 📢
* Obrigado por vizualizar o projeto ❤️

--- 

## 👾 Script Banco de dados

CREATE SCHEMA IF NOT EXISTS teste_residencia;

CREATE SEQUENCE teste_residencia.skill_seq;

CREATE SEQUENCE teste_residencia.user_seq;

CREATE SEQUENCE teste_residencia.user_skill_seq;

CREATE  TABLE teste_residencia.skill ( 
	skill_id                   integer  NOT NULL ,
	name                 varchar(100)  NOT NULL ,
	"version"            varchar(10)   ,
	description          varchar(255)  NOT NULL ,
	image_url            varchar(255)   ,
	CONSTRAINT pk_skill_id PRIMARY KEY ( id )
 );

CREATE  TABLE teste_residencia."user" ( 
	user_id                   integer  NOT NULL ,
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

--- 
