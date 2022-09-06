package week1.day2.assignments;

public class Palindrome {
	public static void main(String[] args) {
		int num = 34343;
		int temp = num;
		int reverse=0;
		//for loop  : we have not mentioned the initialization part
		//No increment / decrement part 
		for (;num!=0;) {
			int remainder = num % 10;
			reverse = reverse*10+remainder;
			num = num/10;
		}	
		
		if(temp==reverse) {
			System.out.println(temp + " is a palindrome number");
		}
		else {
			System.out.println(temp + " is not a palindrome number");
		}
	}

}
