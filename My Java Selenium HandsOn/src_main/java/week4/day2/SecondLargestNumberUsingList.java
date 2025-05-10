package week4.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondLargestNumberUsingList {

	public static void main(String[] args) {

		Integer[]  value = {3, 2, 11, 4, 6, 7};
		
		List<Integer> valueList = new ArrayList<Integer>(Arrays.asList(value));
		
		Collections.sort(valueList);
		
		int sizeOfValueList = valueList.size();
		
		System.out.println("size Of Value List : " + sizeOfValueList );
		
		for (int i=0;i<sizeOfValueList;i++) {
			System.out.println("Values in this List are : " + valueList.get(i));	
		}

		System.out.println("Second Largest value of this list is : " + valueList.get(sizeOfValueList-2));
		
	}

}
