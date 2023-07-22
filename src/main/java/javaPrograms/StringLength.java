package javaPrograms;

public class StringLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "sampleString";
		int i = 0;
		for (@SuppressWarnings("unused")
		char ch : str.toCharArray()) {
			i++;
		}
		System.out.println("Length of the given string :" + i);

	}

}
