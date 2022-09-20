package org.college;

public class College {
	
	public void collegeName() {
		System.out.println("The College Name is RMD Engineering College");
	}
	public void collegeCode() {
		System.out.println("The College Code is 103");
	}
    public void collegeRank() {
    	System.out.println("The College Rank is 25");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		College info = new College();
		info.collegeName();
		info.collegeCode();
		info.collegeRank();
	}

}
