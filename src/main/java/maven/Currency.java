package maven;

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
			 double value = curency.rates[i].mid;
			  String valCode=curency.rates[i].code;
			 System.out.println(value+valCode);
			 i++;
    	
		 }
    }
    
    public void printOneCurr() {
    	
    }
}
