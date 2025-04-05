package week2.day1;

public class LearnAmstrong {

	public static void main(String[] args) {
		int temp , amstrong , numOutput , num;
		System.out.println("================= Amstrong Numbers : ================== ");
		for (int i=150; i<=155; i++) {
			temp = amstrong = 0;	
			numOutput = num = i;
			while (num>0) { 
		    	temp = num % 10; 
		    	amstrong = amstrong + (temp * temp *temp);
		    	num = num / 10;
		    }	
		if(amstrong == numOutput) {
			System.out.println("Given Number is : " + numOutput + " and This is an Amstrong Number");
		} else if(amstrong != numOutput) {
			System.out.println("Given Number is : " + numOutput + " and This is Not an Amstrong Number");
		}
		}
		System.out.println("================== End Of Program ================== ");
	}
}
