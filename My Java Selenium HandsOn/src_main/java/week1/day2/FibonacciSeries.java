package week1.day2;

public class FibonacciSeries {

	public static void main(String[] args) {

		System.out.println("================== Fibonacci Series : ================== ");
		int j = 4; // if the value of j is 4, then we will get the first 8 Fibonacci series value
		int Previous = 0;
		int Previous1 = 1;
		for(int i=1;i<=j;i++) {
			System.out.println(Previous);
			System.out.println(Previous1);
			Previous = Previous + Previous1;
			Previous1 = Previous + Previous1;
		}
		System.out.println("================== End Of Program ================== ");
	}
}
