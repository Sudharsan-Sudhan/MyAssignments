package week4.day1;

public class APIClient {
	
	// SendRequest with 1 string parameter
	public void sendRequest(String a) {
		String endPoint = a;
		System.out.println("Value of End Point a is : " + endPoint);
	}

	// SendRequest with 3 parameters - 2 String and 1 boolean parameter
	public void sendRequest(String a, String b , boolean c) {
		String endPoint = a;
		String requestBody = b;
		boolean requestStatus = c;
		System.out.println("Value of End Point a is : " + endPoint);
		System.out.println("Value of Request Body b is : " + requestBody);
		System.out.println("Value of Request Status C is : " + requestStatus);
	}
	
	// method overloading concept applies here and user is able to call both the methods with different paramters
	public static void main(String[] args) {
		APIClient ac = new APIClient();
		ac.sendRequest("Circle");
		ac.sendRequest("Square", "Rectangle", false);
	}

}
