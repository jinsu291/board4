# DB 생성
DROP DATABASE IF EXISTS board4;
CREATE DATABASE board4;
USE board4;

# 게시물 테이블 생성
CREATE TABLE post (
                         id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                         PRIMARY KEY(id),
                         createDate DATETIME NOT NULL,
                         modifyDate DATETIME NOT NULL,
                         `subject` CHAR(100) NOT NULL,
                         content LONGTEXT NOT NULL,
                         contentHtml LONGTEXT NOT NULL,
                         `author` CHAR(30) NOT NULL
);

# 회원 테이블 생성
CREATE TABLE member (
                         id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                         PRIMARY KEY(id),
                         createDate DATETIME NOT NULL,
                         modifyDate DATETIME NOT NULL,
                         username CHAR(20) NOT NULL,
                         password CHAR(20) NOT NULL,
                         email CHAR(20) NOT NULL,
                         nickname CHAR(20) NOT NULL
);
