package maven;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		
		
		System.out.println(SavedokumentService.convertToPLN(20));
		
		System.out.println(SavedokumentService.convertToPLN(10, "eur"));
		System.out.println(SavedokumentService.convertTPLN(10, "eur",LocalDate.parse("2021-03-14")));
		

	}

}
