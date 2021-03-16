package maven;



public class Main {
	public static void main(String[] args) {
		
		
		SavedokumentService sv=new SavedokumentService();
		System.out.println(sv.addUSD(20));
		
		System.out.println(sv.addOtherCurr(10, "eur"));
	}

}
