package week4.day1;

public class JavaScriptConnection extends MySqlConnection {

	public static void main(String[] args) {
		JavaScriptConnection jcConnection = new JavaScriptConnection();
		jcConnection.connect();
		jcConnection.disconnect();
		jcConnection.executeUpdate();
		jcConnection.executeQuery();
	}

	@Override
	public void connect() {
		System.out.println("Connect from Java Script Connection");
	}

	@Override
	public void disconnect() {
		System.out.println("Connect from Java Script Connection");
	}

	@Override
	public void executeUpdate() {
		System.out.println("Connect from Java Script Connection");
	}

}
