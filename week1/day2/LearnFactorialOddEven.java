package week1.day2;

public class LearnFactorialOddEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int j = 10;
		int Fact = 1;
		int OddCount , EvenCount , SumEven , SumOdd;
		OddCount = EvenCount = SumOdd = SumEven = 0;
		System.out.println("================= Printing Odd & Even Numbers : ================== ");
		for(int i=1;i<=j;i++) {
			if (i%2 == 1) {
				System.out.println("Odd Number : " + i);
				OddCount = OddCount + 1;
				SumOdd = SumOdd + i ; 
			}
			if (i%2 == 0) {
				System.out.println("Even Number : " + i);
				EvenCount = EvenCount + 1; 
				SumEven = SumEven + i ;
			}
		}
		System.out.println("Count of Odd Numbers are : " +  OddCount);
		System.out.println("Count of Even Numbers are : " +  EvenCount);
		System.out.println("Sum of Odd Numbers are : " +  SumOdd);
		System.out.println("Sum of Even Numbers are : " +  SumEven);
		
		System.out.println("================= Factorial Numbers : ================== ");
		for(int i=1;i<=j;i++) {
			Fact = Fact * i;
		}
		System.out.println("Factorial Value for " + j + " is " + Fact);
	}
}