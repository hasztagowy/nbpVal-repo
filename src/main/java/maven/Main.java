package maven;


import com.google.gson.Gson;

public class Main {
	public static void main(String[] args) {
		String code="EUR";
		
		Connect connect=new Connect();
		String z= connect.aaz("http://api.nbp.pl/api/exchangerates/rates/a/"+code+"?format=json");
		 Gson gson=new Gson();
		 Currency ew= new Currency();
		 ew=gson.fromJson(z, Currency.class);
		 double value = ew.rates[0].mid;
		 String valCode=ew.code;
         System.out.println("1 "+valCode+ "=" + value + " PLN");
         
         ew.printAllCur();
// 		String z= connect.aaz("http://api.nbp.pl/api/exchangerates/tables/a/?format=json");
//		 Gson gson=new Gson();
//		 //Currency ew[]=new Currency();
//		// ew[]=gson.fromJson(z, Currency[].class);
//		 Currency[] curr=gson.fromJson(z, Currency[].class);
//		 for(Currency curency: curr){
//			  value = curency.rates[i].mid;
//			  valCode=curency.rates[i].code;
//			 System.out.println(value+valCode);
//			 i++;
//		 }
	}

}
