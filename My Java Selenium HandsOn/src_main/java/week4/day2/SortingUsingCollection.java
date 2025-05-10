package week4.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingUsingCollection {

	public static void main(String[] args) {

		String[] Companies = {"HCL", "Wipro", "Aspire Systems", "CTS"};
		List<String> companiesList = new ArrayList<String>(Arrays.asList(Companies));
		Collections.sort(companiesList);
		int sizeOfCompaniesList = companiesList.size();
		System.out.println("Size of Companies List is : " + sizeOfCompaniesList);
		System.out.println("Sorted Companies List is : " + companiesList);
		List<String> sortedCompaniesList = new ArrayList<String>();
		System.out.println("Newly Created List is : " + sortedCompaniesList);
		for(int i=sizeOfCompaniesList-1;i>=0;i--) {
			System.out.println("Reverse order list is : "+ companiesList.get(i));
			sortedCompaniesList.add(companiesList.get(i));
		}
		System.out.println("Reverse order Sorted Companies List is : " + sortedCompaniesList);
	}
}
