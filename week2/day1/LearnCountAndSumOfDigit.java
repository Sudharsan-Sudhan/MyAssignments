package week2.day1;

public class LearnCountAndSumOfDigit {

	public static void main(String[] args) {
		System.out.println("================= Count and Sum of the Given Number : ================== ");
		int a = 994454452;
		int count, sum;
		sum = count = 0;
	
		while (a>0) {
			sum = (a%10) + sum;
			count = count + 1;
			a=a/10;
		}
		System.out.println("Given value is :" + a +" and The digit count is :"+ count);	
		System.out.println("Given value is :" + a +" and The sum of digit is :"+ sum);
		System.out.println("================== End Of Program ================== ");
		}
}
