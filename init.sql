-- `student-manager`.tblcourse definition

CREATE TABLE `tblcourse` (
  `id` int NOT NULL AUTO_INCREMENT,
  `CourseName` varchar(100) NOT NULL,
  `CourseNameNumber` varchar(100) NOT NULL,
  `Section` varchar(100) NOT NULL,
  `CreateDate` datetime NOT NULL,
  `UpdateDate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- `student-manager`.tblfees definition

CREATE TABLE `tblfees` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fee` decimal(19,4) NOT NULL,
  `Fees_Status` int NOT NULL,
  `Scolarship_Status` int NOT NULL,
  `UserId` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tblfees_tblusers_FK` (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- `student-manager`.tblresult definition

CREATE TABLE `tblresult` (
  `id` int NOT NULL AUTO_INCREMENT,
  `UserId` varchar(10) NOT NULL,
  `CourseId` int NOT NULL,
  `SubjectId` int NOT NULL,
  `marks` int NOT NULL,
  `PostingDate` datetime NOT NULL,
  `UpdationDate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- `student-manager`.tblsubjectcombination definition

CREATE TABLE `tblsubjectcombination` (
  `id` int NOT NULL AUTO_INCREMENT,
  `CourseId` int NOT NULL,
  `SubjectId` int NOT NULL,
  `status` int NOT NULL,
  `CreateDate` datetime NOT NULL,
  `Updatedate` datetime NOT NULL,
  `UserId` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tblsubjectcombination_tblcourse_FK` (`CourseId`),
  KEY `tblsubjectcombination_tblsujects_FK` (`SubjectId`),
  KEY `tblsubjectcombination_tblusers_FK` (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- `student-manager`.tblsubjects definition

CREATE TABLE `tblsubjects` (
  `id` int NOT NULL AUTO_INCREMENT,
  `SubjectName` varchar(100) NOT NULL,
  `SubjectCode` varchar(100) NOT NULL,
  `Createdate` datetime NOT NULL,
  `UpdateDate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- `student-manager`.tblusers definition

CREATE TABLE `tblusers` (
  `UserId` varchar(10) NOT NULL,
  `Name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `RollId` int NOT NULL,
  `Email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Gender` int NOT NULL,
  `DOB` varchar(100) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `Password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `student-manager`.tblcourse (CourseName,CourseNameNumber,`Section`,CreateDate,UpdateDate) VALUES
	 ('Network Management','IS 5203','1','2024-10-06 00:00:00','2024-10-06 00:00:00'),
	 ('Data Science & Big Data','IS 5213','1','2024-10-06 00:00:00','2024-10-06 00:00:00');
INSERT INTO `student-manager`.tblfees (fee,Fees_Status,Scolarship_Status,UserId) VALUES
	 (12.0000,1,0,'001'),
	 (100.0000,0,1,'001'),
	 (133.0000,0,0,'001');
INSERT INTO `student-manager`.tblresult (UserId,CourseId,SubjectId,marks,PostingDate,UpdationDate) VALUES
	 ('001',1,1,100,'2024-10-06 00:00:00','2024-10-06 00:00:00'),
	 ('002',2,2,100,'2024-10-06 00:00:00','2024-10-06 00:00:00');
INSERT INTO `student-manager`.tblsubjectcombination (CourseId,SubjectId,status,CreateDate,Updatedate,UserId) VALUES
	 (1,1,1,'2024-10-06 00:00:00','2024-10-06 00:00:00','001');
INSERT INTO `student-manager`.tblsubjects (SubjectName,SubjectCode,Createdate,UpdateDate) VALUES
	 ('d1','dd','2024-10-06 00:00:00','2024-10-06 00:00:00'),
	 ('a1','aa','2024-10-06 00:00:00','2024-10-06 00:00:00');
INSERT INTO `student-manager`.tblusers (UserId,Name,RollId,Email,Gender,DOB,Address,Password) VALUES
	 ('000','admin',1,'12123',2,'2012','rwewr','bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a'),
	 ('001','test1',2,'12123',2,'2012','rwewr','bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a'),
	 ('002','test2',2,'12123',2,'2012','rwewr','bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a');
