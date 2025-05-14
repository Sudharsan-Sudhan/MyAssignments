package week3.day1;



public class ReverseOddWordsInAString {

	public static void main(String[] args) {
		String input = "I am a software tester";
		String[] splitInput = input.split(" ");
		 
		 for (int i=0;i<splitInput.length;i++) {
			 if(i%2==1) {
				 String outputString = "";
				 for (int j=splitInput[i].length()-1; j>=0;j--) {
					 
					 outputString = outputString + splitInput[i].charAt(j);
				 }
				 System.out.print(outputString + " ");	 
			 }
			 else {
				 System.out.print(splitInput[i] + " ");
			 } 
		 }
	}
}