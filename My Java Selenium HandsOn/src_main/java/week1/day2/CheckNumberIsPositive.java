package week1.day2;

public class CheckNumberIsPositive {

	public static void main(String[] args) {
		
		int a = 10; // Positive Number
		int b = -25; // Negative Number
		
		int i = a; // Change the value of i as "a & b" to run this program with different inputs
		
		System.out.println("================== Check the Given Number is Positive or Negative ================== ");
		if (i > 0) {
			System.out.println("The given input is " + i + " which is greaterthan zero, so this is Positive Number");
		}else {
			System.out.println("The given input is " + i + " which is lessthan zero, so this is Negative Number");
		}
		System.out.println("================== End Of Program ================== ");
	}
}
