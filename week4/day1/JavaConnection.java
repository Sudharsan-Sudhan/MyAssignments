package week4.day1;

public class JavaConnection implements DatabaseConnection {
	
	public static void main(String[] args) {
		JavaConnection jc = new JavaConnection();
				jc.connect();
				jc.disconnect();
				jc.executeUpdate();
	}

	@Override
	public void connect() {
		System.out.println("Connect from Java Connection");
	}

	@Override
	public void disconnect() {
		System.out.println("Disconnect from Java Connection");
	}

	@Override
	public void executeUpdate() {
		System.out.println("Excel Update from Java Connection");
	}

}
