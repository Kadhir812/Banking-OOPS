package com.example.const_arg;


public class Student {
	 int studentId;
	 String studentName;
	 int age;
	 String course;

     
	public Student() {
    }

    public Student(int studentId, String studentName, int age, String course) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.course = course;
    }

    public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", age=" + age + ", course=" + course + "]";
	}
}
