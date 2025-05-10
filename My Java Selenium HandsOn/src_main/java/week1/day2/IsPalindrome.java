package week1.day2;

public class IsPalindrome {

	public static void main(String[] args) {

		System.out.println("================== Given Number is Palindrome or Not Palindrome : ================== ");

		int a = 141; // 3 digit Palindrome input  
		int b = 2112; // 4 digit Palindrome input 
		int c = 12121; // 5 digit Palindrome input 
		int d = 215512; // 6 digit Palindrome input
		int e = 123; // 3 digit Non Palindrome input
		int f = 1234; // 4 digit Non Palindrome input
		int g = 12345; // 5 digit Non Palindrome input
		int h = 123456; // 6 digit Non Palindrome input
		
		int num , inputNum;
		inputNum = num = h; // Change the value of inputNum & num as "a to h" to run this program with different inputs  
		int output = 0;
		int temp = 0;
			System.out.println("Input Value = " + num );	
		
		while (num>0) {
		    	temp = num % 10;
		    	output = (output * 10) + temp ;
		    	num = num / 10;
		    }
		    System.out.println("Output Value = " + output);
		
		if (inputNum==output) {
		    	System.out.println("Given Number is " + num +" a Palindrome");
		    }else if (inputNum!=output) {
		    	System.out.println("Given Number is " + num +" Not a Palindrome");
		    }
		    System.out.println("================== End Of Program ================== ");
		  }
		}