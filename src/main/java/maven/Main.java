package maven;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import maven.connector.FileConnector;
import maven.service.SavedokumentService;
import maven.valid.DateValidator;

public class Main {
	public static void main(String[] args) {

		SavedokumentService savedokumentService=new SavedokumentService();
		savedokumentService.insert();
		
		
//		String a="a";
//		String b="a";
//	String c=new String("a");
//		System.out.println(a==b);
//		System.out.println(a==c);
//	System.out.println(c.eq);
//		
		

	}

}
