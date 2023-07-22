package javaPrograms;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class SynchronizedArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> namesList = Collections.synchronizedList(new ArrayList<String>());
		namesList.add("Krishna");
		namesList.add("Kamakshi");
		namesList.add("Brahma");
		
		//to fetch the value / traverse the values from the list 
		
		synchronized (namesList) {
			for (String s : namesList) {
				System.out.println(s);
			}
			
		}
		
		//2. CopyOnWriteArrayLisat -- its a class 
		CopyOnWriteArrayList<String> empLisat = new CopyOnWriteArrayList<String>();
		empLisat.add("Test");
		empLisat.add("QA Test");

		for (String s : empLisat) {
			System.out.println(s);
		}

	}

}
