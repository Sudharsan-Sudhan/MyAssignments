package week1.day2;

public class IsPrimeNumber {

	public static void main(String[] args) {

		System.out.println("================== Given Number is Prime or Not Prime : ================== ");
		int a = 11; // Prime Number input
		int b = 18; // Non Prime Number input
		int j = b; // Change the value of j as "a & b" to run this program with different inputs
		int k;
		for (int i=2;i<=j;i++) {
			k = j % i;
			if (k==0) {
				if(i == j) {
					System.out.println("The Given Number is : " + j + " a Prime Number");
				}else if (i != j) {
					System.out.println("The Given Number is : " + j + " Not a Prime Number");
					break;
				}
			}
		}
		System.out.println("================== End Of Program ================== ");
	}
}