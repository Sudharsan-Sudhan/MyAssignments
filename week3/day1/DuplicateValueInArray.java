package week3.day1;

import java.util.Arrays;

public class DuplicateValueInArray {

	public static void main(String[] args) {
		int [] value = {2,5,7,7,5,9,2,3,9,11,14};
		Arrays.sort(value);
		for(int i=0;i<value.length-1;i++) {
			System.out.println("Sorted value is " + value[i]);
			if(value[i]==value[i+1]) {
				System.out.println("duplicate value is " + value[i]);
			}
		}
	}
}
