package maven;

import java.math.BigDecimal;

public class SavedokumentService {
	
	Currency curr= new Currency();
	
	
	public BigDecimal addUSD(int z) {
		
		BigDecimal bg=new BigDecimal(z);
		
		return curr.printOneCurr(bg);
	}
	
	public BigDecimal addOtherCurr(int z, String curr_name) {
		
		BigDecimal bg=new BigDecimal(z);
		
		
		return curr.printOneCurr(bg,curr_name);
	}
	
	

}
