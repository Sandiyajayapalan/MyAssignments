package week3.day2assignments;

import java.util.ArrayList;

import java.util.List;

public class FindIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {3,2,11,4,6,7};
		int[] arr2 = {1,2,8,4,9,7};
		List<Integer> lst1= new ArrayList<Integer>();
		List<Integer> lst2= new ArrayList<Integer>();
			for(Integer i : arr1) {
				lst1.add(i);
				}
			for(Integer j : arr2) {
				lst2.add(j);
				}
			for(int i =0 ;i<lst1.size();i++) {
				for(int j=i ;j<lst2.size();j++) {
					if(lst1.get(i)==lst2.get(j)) {
						System.out.println(lst1.get(i)+" at index "+j);
					}
				}
			}						
	}

}
