package week4.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMissingElementUsingList {

	public static void main(String[] args) {
		
		Integer[] input = {1, 2, 3, 4, 10, 6, 8};
		List<Integer> ArrayList =new ArrayList<Integer>(Arrays.asList(input));
		
		Collections.sort(ArrayList);
		
		int sizeOfArrayList = ArrayList.size();
		System.out.println("size of this Array List is : " + sizeOfArrayList);
		
		for(int i = 1;i<sizeOfArrayList;i++) {
				if(i!=ArrayList.get(i-1)) {
		System.out.println("Missed Values are "+ i);	
		break;

			}
		}

	}

}
