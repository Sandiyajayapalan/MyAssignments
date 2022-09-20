package week3.day1assignments;

import java.util.Iterator;



public class OddIndexToUppercase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name="changeme";
		char[] str = name.toCharArray();
        for (int i = 0; i < str.length; i++) {
          if(i%2!=0)
          {
             str[i]=Character.toUpperCase(str[i]);
          
          }
          else
          {
        	  str[i]=Character.toLowerCase(str[i]);
          }
        	
        	
		}	
		
		System.out.println(str);
	}
}
