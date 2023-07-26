package TestCaseFiles;

public class TempInt {

	public static void main(String[] args) {
		String input = "J .irabaS";

		String reversed = "";

		for (int i = input.length() - 1; i >= 0; i--) {
			reversed = reversed + input.charAt(i);
		}
		System.out.println(reversed);
	}
}
