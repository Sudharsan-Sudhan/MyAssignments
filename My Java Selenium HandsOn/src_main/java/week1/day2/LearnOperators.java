package week1.day2;

public class LearnOperators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a=6;            // a++ + ++a - a--
		
		System.out.println("Current value of a is " + a);
		
		int b = a++; // 6
		int c = ++a; // 7+1 = 8
		int d = a--; // 8
		
		System.out.println("Current value of b is " + b);
		System.out.println("Current value of c is " + c);
		System.out.println("Current value of d is " + d);
		
		System.out.println(b+c-d); // 6+8-8
		
		if (a==b) {
			System.out.println("a is equal to b");
		}else if (a<b) {
			System.out.println("a is lessthan b");
		}else if (a>b) {
			System.out.println("a is greaterthan b");
		}

	}

}
