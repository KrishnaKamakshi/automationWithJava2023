package javaPrograms;

public class ReverseOfAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String givenWord = "Krishna";
		StringBuilder rev = new StringBuilder();
		int len = givenWord.length();

		for (int i = len - 1; i >= 0; i--) {
			rev.append(givenWord.charAt(i));
		}
		System.out.println(rev);

	}

}
