package week3.day1;

public class RemoveDuplicateWordsInAString {

	public static void main(String[] args) {
		String input = "We learn Java basics as part of java sessions in java week1";
		String[] splitInput = input.split(" ");
		for(int i=0;i<splitInput.length;i++) {
			
			for(int j=i+1;j<splitInput.length;j++) {
				
				if (splitInput[i].equals(splitInput[j])) {
					splitInput[j]="";
				}
			}
			System.out.print(" " + splitInput[i]);
		}
	}
}
