package week3.day2assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindSecondLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] s1 = {3,2,11,4,6,7};
		List<Integer> s2 = new ArrayList<Integer>();
		for (Integer i : s1) {
			s2.add(i);
		}
		Collections.sort(s2);
		System.out.println(s2);
		System.out.println("The Second Largest Element is " + s2.get(s2.size()-2));
	}

}
