create database InternTest;
use InternTest;
CREATE TABLE EmpDet (
    EId VARCHAR(30) PRIMARY KEY,
    EName VARCHAR(50) NOT NULL,
    DOJ DATE NOT NULL,
    YOE INTEGER NOT NULL,
    Designation VARCHAR(30) NOT NULL
);

insert into EmpDet values("2022-46","Akshay Kumar","2022-08-12",0,"Android Devloper");
