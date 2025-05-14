package week3.day1;

import java.util.Arrays;

public class FindingMissingElementOnArray {

	public static void main(String[] args) {

		int[] numbers = {1,4,3,2,8,6,7};
		Arrays.sort(numbers);
		for (int i=1;i<=numbers.length;i++) {

			if(i!=(numbers[i-1])) {
				System.out.println("Print " + i);
				break;
			}
		}
	}
}
