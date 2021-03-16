package maven;


import com.google.gson.Gson;

public class Main {
	public static void main(String[] args) {
		Connect connect=new Connect();
		String z= connect.aaz("http://api.nbp.pl/api/exchangerates/rates/a/chf?format=json");
		 Gson gson=new Gson();
		 Currency ew= new Currency();
		 ew=gson.fromJson(z, Currency.class);
		 double value = ew.rates[0].mid;
		 String valCode=ew.code;
         System.out.println("Today for 1 "+valCode+ " you’ll get " + value + " PLN");
	}

}
