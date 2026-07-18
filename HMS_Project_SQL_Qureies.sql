-- DATABASE FOR BISHNU TARA MEMORIAL HOSPITAL
CREATE DATABASE hospital_management_system;
USE hospital_management_system;

-- Login 
CREATE TABLE login(ID varchar(20), PW varchar(20));
SELECT * FROM login;

-- Username and Password
insert into login value("pramesh","9748421356");

-- Add New Patient 
CREATE TABLE patient_info (First_Name VARCHAR(20), Last_Name VARCHAR(20), Gender VARCHAR(20), Department VARCHAR(50), ID VARCHAR(20), ID_Number VARCHAR(20), Payment_Method VARCHAR(30), Room VARCHAR(20), Date_and_Time VARCHAR(100), Deposit VARCHAR(20));
SELECT * FROM patient_info;

-- Room
CREATE TABLE Room(Room_No varchar(20), Availability varchar(20),Room_Type varchar(100), Room_Price varchar(20));
SELECT * FROM Room;

insert into Room values("101","Available","Emergency Room Bed 1","4000");
insert into Room values("102","Available","Emergency Room Bed 2","4000");
insert into Room values("103","Available","Emergency Room Bed 3","4000");
insert into Room values("104","Available","Emergency Room Bed 4","4000");
insert into Room values("105","Available","Emergency Room Bed 5","4000");
insert into Room values("201","Available","General Bed 1",500);
insert into Room values("202","Available","General Bed 2",500);
insert into Room values("203","Available","General Bed 3",500);
insert into Room values("204","Available","General Bed 4",500);
insert into Room values("205","Available","General Bed 5",500);
insert into Room values("301","Available","Semi-Cabin Bed 1",1500);
insert into Room values("302","Available","Semi-Cabin Bed 2",1500);
insert into Room values("303","Available","Semi-Cabin Bed 3",1500);
insert into Room values("304","Available","Semi-Cabin Bed 4",1500);
insert into Room values("305","Available","Semi-Cabin Bed 5",1500);
insert into Room values("401","Available","Private Cabin Bed 1",3000);
insert into Room values("402","Available","Private Cabin Bed 2",3000);
insert into Room values("403","Available","Private Cabin Bed 3",3000);
insert into Room values("404","Available","Private Cabin Bed 5",3000);
insert into Room values("405","Available","Private Cabin Bed 5",3000);

-- Department
CREATE TABLE Department(Department varchar(100), Phone_Number varchar(20));
SELECT * FROM Department;

insert into department values ("Radiology Department","061460232");
insert into department values ("Pathology Department","061460234");
insert into department values ("Pharmacy Department","061460235");
insert into department values ("Blood Bank Unit","061460236");
insert into department values ("Laboratory Services","061460237");
insert into department values ("Physiotherapy Department","061460238");
insert into department values ("Anesthesiology","061460239");
insert into department values ("Administration","061460331");
insert into department values ("Accounts and Billing","061460332");
insert into department values ("Human Resource","061460333");
insert into department values ("Medical Records","061460334");
insert into department values ("IT Department","061460335");
insert into department values ("Reception/Front Desk","061460336");
insert into department values ("Cleaning,Maintainance and Security","061460337");

-- Employee Details
CREATE TABLE EMP_INFO(Name varchar(20), Age varchar(20),Department varchar (100), Hospital_ID varchar (20), Mobile_Number varchar(20), NID_Number varchar(20), PAN_Number varchar(20), Gmail varchar(100));
SELECT * FROM EMP_INFO;

insert into emp_info values ("Dr. Ram Thapa","41","Radiology Department","HID001","9807000001","5483920176","839201745","ram.thapa@bishnutaramemorialhospital.com.np");
insert into emp_info values ("Dr. Rohan Karki","38","Radiology Department","HID002","9807000002","7392018645","482910376","rohan.karki@bishnutaramemorialhospital.com.np");
insert into emp_info values ("Dr. Anjali Rai","30","Pathology Department","HID003","9807000003","9201746385","761029384","anjali.rai@bishnutaramemorialhospital.com.np");
insert into emp_info values ("Dr. Suman Karki","32","Pathology Department","HID004","9807000004","6102948573","920384756","suman.karki@bishnutaramemorialhospital.com.np");
insert into emp_info values ("Prakash Joshi","29","Pharmacy Department","HID005","9807000005","8459201736","384756192","prakash.joshi@bishnutaramemorialhospital.com.np");
insert into emp_info values ("Sunita KC","34","Blood Bank Unit","HID006","9807000006","1938475620","564738291","sunita.kc@bishnutaramemorialhospital.com.np");
insert into emp_info values ("Arjun Shrestha","27","Laboratory Services","HID007","9807000007","6728391045","847362910","arjun.shrestha@bishnutaramemorialhospital.com.np");
insert into emp_info values ("Dr. Sita Sharma","40","Anesthesiology","HID009","9807000009","9582716403","657483920","sita.sharma@bishnutaramemorialhospital.com.np");
insert into emp_info values ("Dr. Neha Oli","35","General Surgery","HID010","9807000010","4172638950","384920175","neha.oli@bishnutaramemorialhospital.com.np");
insert into emp_info values ("Dr. Rajesh Koirala","50","Internal Medicine","HID011","9807000011","8601927345","564920183","rajesh.koirala@bishnutaramemorialhospital.com.np");
insert into emp_info values ("Dr. Pooja Thapa","33","Gynecology","HID012","9807000012","7203948561","748392015","pooja.thapa@bishnutaramemorialhospital.com.np");
insert into emp_info values ("Dr. Meena Gurung","37","Obstetrics (OBS)","HID013","9807000013","5910273648","920174635","meena.gurung@bishnutaramemorialhospital.com.np");
insert into emp_info values ("Dr. Alok Sharma","44","Cardiology","HID014","9807000014","3047561928","564738920","alok.sharma@bishnutaramemorialhospital.com.np");
insert into emp_info values ("Dr. Ritu Shrestha","36","Orthopedics","HID015","9807000015","4820193756","839201564","ritu.shrestha@bishnutaramemorialhospital.com.np");
insert into emp_info values ("Dr. Kiran Adhikari","39","Pediatrics","HID016","9807000016","7102948365","920384715","kiran.adhikari@bishnutaramemorialhospital.com.np");
insert into emp_info values ("Kamal Basnet","45","Administration","HID017","9807000017","6392017485","384756920","kamal.basnet@bishnutaramemorialhospital.com.np");
insert into emp_info values ("Deepak Khadka","42","Accounts and Billing","HID018","9807000018","8201746395","564738102","deepak.khadka@bishnutaramemorialhospital.com.np");
insert into emp_info values ("Rekha Acharya","31","Human Resource","HID019","9807000019","5918203746","748392651","rekha.acharya@bishnutaramemorialhospital.com.np");
insert into emp_info values ("Mahesh Rai","39","Medical Records","HID020","9807000020","7304958612","192837450","mahesh.rai@bishnutaramemorialhospital.com.np");
insert into emp_info values ("Nabin Poudel","28","IT Department","HID021","9807000021","4601928375","657483291","nabin.poudel@bishnutaramemorialhospital.com.np");
insert into emp_info values ("Sarita Magar","26","Reception/Front Desk","HID022","9807000022","9823746501","384920716","sarita.magar@bishnutaramemorialhospital.com.np");
insert into emp_info values ("Suresh Bhandari","46","Cleaning","HID023","9807000023","3048571926","920174853","suresh.bhandari@bishnutaramem.com.np");

-- Ambulance 

CREATE TABLE Ambulance(Driver_Name varchar(20), Gender varchar(20), Ambulance_Number varchar(50), Location varchar(20), Availablity varchar (20));
SELECT * FROM Ambulance;
insert into ambulance values ('Ram Rai', 'Male', 'KO 01 CHA 0456', 'Biratnagar','Available');
insert into ambulance values ('Sita Yadav', 'Female', 'MA 02 CHA 1234', 'Janakpur','Available');
insert into ambulance values ('Binod Tamang', 'Male', 'BA 03 CHA 2345', 'Hetauda','Available');
insert into ambulance values ('Anita Gurung', 'Female', 'GA 04 CHA 3456', 'Pokhara','Available');
insert into ambulance values ('Mohan Tharu', 'Male', 'LU 05 CHA 4567', 'Deukhuri','Available');
insert into ambulance values ('Rita Chhetri', 'Female', 'KA 06 CHA 5678', 'Birendranagar','Available');
insert into ambulance values ('Krishna Thakuri', 'Male', 'SU 07 CHA 6789', 'Godawari','Available');




