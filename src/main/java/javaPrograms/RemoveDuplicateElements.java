package javaPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class RemoveDuplicateElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1,2,3,4,1,2,3,4,5,11,1,1,1,1,1,1,1,1,1,1,1,1,1));
		
		LinkedHashSet<Integer> n = new LinkedHashSet<Integer>(numbers);
		ArrayList<Integer> numbers1 = new ArrayList<Integer>(n);
		System.out.println(numbers1);
		ArrayList<Integer> numbers2 = new ArrayList<Integer>(Arrays.asList(2,2,3,4,1,2,3,4,5,11,1,1,3,2,1,11,1,1,1,1,1,1,1));
		System.out.println(numbers2.stream().distinct().collect(Collectors.toList()));
	}

}
