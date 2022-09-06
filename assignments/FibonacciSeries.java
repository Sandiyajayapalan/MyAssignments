package week1.day2.assignments;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int range = 8 ;
		int Num1 = 0 , Num2 = 1 ;
		int sum ;
		System.out.println(Num1);
		System.out.println(Num2);
		for (int i = 0; i <=range; i++) {
			
			sum = Num1 + Num2;
			System.out.println(sum);
			Num1 = Num2;
			Num2 = sum;
		}
			
			

	}

}
