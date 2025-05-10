package week4.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionUsingList {

	public static void main(String[] args) {
		
		Integer[] Array1 = {3, 2, 11, 4, 6, 7};
		Integer[] Array2 = {1, 2, 8, 4, 9, 7};
		int n=1;
		List<Integer> Array1List =new ArrayList<Integer>(Arrays.asList(Array1));
		List<Integer> Array2List =new ArrayList<Integer>(Arrays.asList(Array2));
		for (int i=0;i<Array1List.size();i++) {
			for(int j=0;j<Array2List.size();j++) {
				if(Array1List.get(i) == Array2List.get(i)) {
					System.out.println(n + "th Common Value is : " + Array2List.get(i));
					n++;
					break;
				}
			}
		}
	}
}
