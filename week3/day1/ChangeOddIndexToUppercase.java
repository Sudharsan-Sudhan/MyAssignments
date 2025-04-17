package week3.day1;

public class ChangeOddIndexToUppercase {

	public static void main(String[] args) {

		String text = "changeme"; 
		char[] textCharArray = text.toCharArray();
		
		for (int i=0;i<textCharArray.length;i++) {
			if(i%2==1) {
				textCharArray[i] = Character.toUpperCase(textCharArray[i]);
				System.out.print(textCharArray[i]);
			}else if(i%2==0) {
				textCharArray[i] = Character.toLowerCase(textCharArray[i]);
				System.out.print(textCharArray[i]);
			}
		}
	}
}
