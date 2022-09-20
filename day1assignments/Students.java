package week3.day1assignments;

public class Students {
	public void getStudentInfo(int id) {
		System.out.println("Student Id :" +id);
	}
	public void getStudentInfo(int id, String name) {
		System.out.println("Student Id :" +id+ "and Student Name :" +name);
		
	}
	public void getStudentInfo(String email, long phoneNumber) {
		System.out.println("Student email : " +email+ " and PhoneNumber :" +phoneNumber);
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Students obj = new Students();
		obj.getStudentInfo(13243);
		obj.getStudentInfo(13243, "Sandiya");
		obj.getStudentInfo("sandiyajayapalan@gmail.com", 9886657552l);
	}

}
