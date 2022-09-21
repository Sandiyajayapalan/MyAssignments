package week3.day2assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingElementInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = {1,2,3,4,6,7,8};
		
		
		
		List<Integer> s1 = new ArrayList<Integer>();
		for (Integer i : ar) {
			s1.add(i);
			
		}
		// Sort the array	
		Collections.sort(s1);
		System.out.println(s1);
		// loop through the array (start i from arr[0] till the length of the array)
			for (int i = 0; i < s1.size(); i++) {
				// check if the iterator variable is not equal to the array values respectively
				
				// print the number
				
				// once printed break the iteration
				
				if (s1.get(i)!=i+1) {
					System.out.println("The Missing Element is :" + (i+1));
					break;
				}
			}

	}

}
