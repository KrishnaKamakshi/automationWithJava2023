package javaPrograms;

import java.util.HashMap;
import java.util.HashSet;

public class HashMap2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Integer, String> newT = new HashMap<Integer, String>();
		newT.put(1, "Krishna");
		newT.put(2, "Krishna2");
		
		
		HashMap<Integer, String> newT2 = new HashMap<Integer, String>();
		newT2.put(1, "Krishna3233");
		newT2.put(2, "Krishna2");
		
		HashSet<Integer> combineKeys = new HashSet<>(newT.keySet());
		combineKeys.addAll(newT2.keySet());
		combineKeys.removeAll(newT.keySet());
		System.out.println(combineKeys);
		
	}

}
