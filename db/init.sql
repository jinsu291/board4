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
                         contentHtml LONGTEXT NOT NULL
);