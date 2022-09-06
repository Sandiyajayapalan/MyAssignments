package week1.day2.assignments;

import java.lang.reflect.Array;

public class SmallestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {23,45,67,32,89,22};
		int temp ;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[i]>arr[j]) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				
				}	
			}
			
		}
		System.out.println("2nd Smallest number in array is " + arr[1]);
	}

}
