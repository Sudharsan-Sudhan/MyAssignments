package week3.day1;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		
		String text1 = "stops"; 
		String text2 = "potss";
		int text1Length = text1.length();
		int text2Length = text2.length();
		char[] text1CharArray = text1.toCharArray();
		char[] text2CharArray = text2.toCharArray();
		
		Arrays.sort(text1CharArray, 0, text1Length);
		Arrays.sort(text2CharArray, 0, text2Length);
		
		if (text1Length == text2Length) {
			System.out.println("Length is match");
			for (int i=0;i<text1Length;i++) {
				if (text1CharArray[i]==text2CharArray[i]) {
				}
			}
			System.out.println("Given String is Anagram");
		} else {
			System.out.println("Lengths mismatch, therefore the strings are not an Anagram");
		}
	}
}
