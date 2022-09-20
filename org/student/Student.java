package org.student;

import org.department.Department;

public class Student extends Department {
	public void studentName() {
		System.out.println("The student Name is Sandiya");
	}
	public void studentDept() {
		System.out.println("The student Department is ECE");
	}
	public void studentId() {
		System.out.println("The student Id is	103798");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student obj = new Student();
		obj.studentName();
		obj.studentDept();
		obj.studentId();
		obj.deptName();
		obj.collegeName();
		obj.collegeCode();
		obj.collegeRank();
		

	}

}
