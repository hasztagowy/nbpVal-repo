package maven;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SavedokumentService {
	
	
	
	public static BigDecimal convertToPLN(int z) {
		
		BigDecimal bg=new BigDecimal(z);
		
		return CurrencyMethods.printOneCurr(bg);
	}
	
	public static BigDecimal convertToPLN(int z, String curr_code) {
		
		BigDecimal bg=new BigDecimal(z);
		
		
		return CurrencyMethods.printOneCurr(bg,curr_code);
	}
	public static BigDecimal convertTPLN(int value,String curr_code,LocalDate localDate) {
		
		BigDecimal bg=new BigDecimal(value);
		
		return CurrencyMethods.printOneCurr(bg, curr_code, localDate);
	}
	
	
	
	

}
