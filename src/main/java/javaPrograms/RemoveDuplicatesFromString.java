package javaPrograms;

public class RemoveDuplicatesFromString {

	public static void removeDup2(String str, String string) {

		StringBuilder strNoDup = new StringBuilder();

		// loop over string and get each char
		for (char ch : str.toCharArray()) {
			// if strNoDup does not contain char then add to it
			if (!strNoDup.toString().contains(String.valueOf(ch))) {
				strNoDup.append(ch);
			}
		}
		System.out.println(strNoDup);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		removeDup2("Krishna", "Krishna");

	}

}
