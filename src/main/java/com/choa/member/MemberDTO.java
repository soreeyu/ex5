package com.choa.member;

import org.springframework.web.multipart.MultipartFile;

public class MemberDTO {

		private String id;
		private String pw;
		private String name;
		private int age;
		private String grade;
		private String fileName;
		private String oriName;
		
		private MultipartFile f1;
		
		public MultipartFile getF1() {
			return f1;
		}
		public void setF1(MultipartFile f1) {
			this.f1 = f1;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPw() {
			return pw;
		}
		public void setPw(String pw) {
			this.pw = pw;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getGrade() {
			return grade;
		}
		public void setGrade(String grade) {
			this.grade = grade;
		}
		public String getfileName() {
			return fileName;
		}
		public void setfileName(String fileName) {
			this.fileName = fileName;
		}
		public String getoriName() {
			return oriName;
		}
		public void setoriName(String oriName) {
			this.oriName = oriName;
		}
		
		
}
