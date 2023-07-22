package javaPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CompareTwoLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> numbers4 = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
		ArrayList<Integer> numbers3 = new ArrayList<Integer>(Arrays.asList(2,12,3,14));
		
		Collections.sort(numbers4); 
		Collections.sort(numbers3);
		
		System.out.println(numbers4.equals(numbers3));
		
		ArrayList<Integer> numbers5 = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
		ArrayList<Integer> numbers6 = new ArrayList<Integer>(Arrays.asList(1,2,3,5));
		
		numbers5.removeAll(numbers6);
		System.out.println(numbers5);
		

	}

}
