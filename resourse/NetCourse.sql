/*
Navicat MySQL Data Transfer

Source Server         : netcourse
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : test2

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2016-05-11 09:45:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for tb_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_course`;
CREATE TABLE `tb_course` (
  `courseid` int(11) NOT NULL,
  `coursename` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `teacher` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `courseimage` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `coursetitle` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `courseintroduce` varchar(2000) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`courseid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for tb_coursesystem
-- ----------------------------
DROP TABLE IF EXISTS `tb_coursesystem`;
CREATE TABLE `tb_coursesystem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `majorid` int(11) NOT NULL,
  `grade` int(11) NOT NULL,
  `courseid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `majorid` (`majorid`),
  KEY `courseid` (`courseid`),
  CONSTRAINT `courseid` FOREIGN KEY (`courseid`) REFERENCES `tb_course` (`courseid`),
  CONSTRAINT `majorid` FOREIGN KEY (`majorid`) REFERENCES `tb_major` (`majorid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for tb_haslearned
-- ----------------------------
DROP TABLE IF EXISTS `tb_haslearned`;
CREATE TABLE `tb_haslearned` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseid` int(11) NOT NULL,
  `studentname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `haslearnedcourseid` (`courseid`),
  KEY `studentid` (`studentname`),
  CONSTRAINT `haslearnedcourseid` FOREIGN KEY (`courseid`) REFERENCES `tb_course` (`courseid`),
  CONSTRAINT `studentid` FOREIGN KEY (`studentname`) REFERENCES `tb_student` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for tb_institute
-- ----------------------------
DROP TABLE IF EXISTS `tb_institute`;
CREATE TABLE `tb_institute` (
  `instituteid` int(11) NOT NULL,
  `institutename` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`instituteid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for tb_major
-- ----------------------------
DROP TABLE IF EXISTS `tb_major`;
CREATE TABLE `tb_major` (
  `majorid` int(11) NOT NULL,
  `majorname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `instituteid` int(255) DEFAULT NULL,
  PRIMARY KEY (`majorid`),
  KEY `instituteid` (`instituteid`),
  CONSTRAINT `instituteid` FOREIGN KEY (`instituteid`) REFERENCES `tb_institute` (`instituteid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for tb_question
-- ----------------------------
DROP TABLE IF EXISTS `tb_question`;
CREATE TABLE `tb_question` (
  `questionid` int(11) NOT NULL AUTO_INCREMENT,
  `context` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `teacher` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `student` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `video` int(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`questionid`),
  KEY `studentToQuestion` (`student`),
  KEY `teacherToQuestion` (`teacher`),
  KEY `videoToQuestion` (`video`),
  CONSTRAINT `studentToQuestion` FOREIGN KEY (`student`) REFERENCES `tb_student` (`username`),
  CONSTRAINT `teacherToQuestion` FOREIGN KEY (`teacher`) REFERENCES `tb_teacher` (`username`),
  CONSTRAINT `videoToQuestion` FOREIGN KEY (`video`) REFERENCES `tb_video` (`videoid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student` (
  `username` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `majorid` int(255) DEFAULT NULL,
  `firstname` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastname` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `userimage` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `studentmajor` (`majorid`),
  CONSTRAINT `studentmajor` FOREIGN KEY (`majorid`) REFERENCES `tb_major` (`majorid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for tb_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE `tb_teacher` (
  `username` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `institute` int(11) DEFAULT NULL,
  `firstname` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastname` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `teacherinstitute` (`institute`),
  CONSTRAINT `teacherinstitute` FOREIGN KEY (`institute`) REFERENCES `tb_institute` (`instituteid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for tb_video
-- ----------------------------
DROP TABLE IF EXISTS `tb_video`;
CREATE TABLE `tb_video` (
  `videoid` int(11) NOT NULL,
  `videoname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `course` int(11) DEFAULT NULL,
  `path` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`videoid`),
  KEY `videocourseid` (`course`),
  CONSTRAINT `videocourseid` FOREIGN KEY (`course`) REFERENCES `tb_course` (`courseid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
