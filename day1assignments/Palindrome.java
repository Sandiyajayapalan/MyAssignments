package week3.day1assignments;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "madam";
		String str = "";
		for (int i = name.length()-1; i>=0 ; i--) {
			str = str + name.charAt(i);
			
		}
		if(name.equals(str)) {
			System.out.println("Palindrome");
		}
		else {
			System.out.println("Not Palindrome");
		}

	}

}
