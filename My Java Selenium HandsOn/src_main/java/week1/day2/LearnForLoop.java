package week1.day2;

public class LearnForLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("==================  Printing 1 to 5 : ==================");
		for(int i=1;i<=5;i++) {
			System.out.println("Printing 1 to 5 : " + i);
		}
		System.out.println("==================  Printing 5 to 1 : ==================");
		for(int j=5;j>=1;j--) {
			System.out.println("Printing 5 to 1 : " + j);
		}
		System.out.println("================== Odd Number : ================== ");
		for(int i=1;i<=10;i++) {
			if (i%2 == 1) {
				System.out.println("Odd Number : " + i);	
			}
		}
	}
}
