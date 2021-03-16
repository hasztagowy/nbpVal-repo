package maven;

import java.math.BigDecimal;
import java.util.Scanner;

import com.google.gson.Gson;

public class Currency {
	public String table;
  // public String currency;
    public String code;
    public Rate[] rates;
    
    
    public void printAllCur() {
    	Connect connect=new Connect();
    	int i=0;
    	
    	String z= connect.aaz("http://api.nbp.pl/api/exchangerates/tables/a/?format=json");
		 Gson gson=new Gson();
		 
		 Currency[] curr=gson.fromJson(z, Currency[].class);
		 for(Currency curency: curr){
			 BigDecimal value = curency.rates[i].mid;
			  String valCode=curency.rates[i].code;
			 System.out.println(value+valCode);
			 i++;
		 }
		 
    }
    
    public BigDecimal printOneCurr(BigDecimal decimal) {
    	code="USD";
    	
    	
		
		Connect connect=new Connect();
		String z= connect.aaz("http://api.nbp.pl/api/exchangerates/rates/a/"+code+"?format=json");
		 Gson gson=new Gson();
		 Currency ew= new Currency();
		 ew=gson.fromJson(z, Currency.class);
		 BigDecimal value = ew.rates[0].mid;
		 String valCode=ew.code;
        System.out.println("1 "+valCode+ "=" + value + " PLN");
         
         
        
         return calculate(decimal,value);
    }
    public BigDecimal printOneCurr(BigDecimal decimal, String curr_code) {
   
    	
    	
		
		Connect connect=new Connect();
		String z= connect.aaz("http://api.nbp.pl/api/exchangerates/rates/a/"+curr_code+"?format=json");
		 Gson gson=new Gson();
		 Currency ew= new Currency();
		 ew=gson.fromJson(z, Currency.class);
		 BigDecimal value = ew.rates[0].mid;
		 String valCode=ew.code;
        System.out.println("1 "+valCode+ "=" + value + " PLN");
         
         
        
         return calculate(decimal,value);
    }
    
    public BigDecimal calculate(BigDecimal given, BigDecimal curr_val) {
    	
    	
    	return given.multiply(curr_val);
    	
    	
    }
}
