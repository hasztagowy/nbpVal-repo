package maven;

public class Main {
	
	public static void main(String[] args) {
		Connection connection= new Connection();
		try {
			connection.connectToNBP();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("fd");
	}
}
