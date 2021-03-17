package maven;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.google.gson.Gson;

public class CurrencyMethods {
	
	public static  BigDecimal printOneCurr(BigDecimal decimal) {
		String curr_code="usd";

		return printOneCurr(decimal, curr_code);
	}

	public static BigDecimal printOneCurr(BigDecimal decimal, String curr_code) {

		Connect connect = new Connect();
		String z = connect.connectToNBP("http://api.nbp.pl/api/exchangerates/rates/a/" + curr_code.toLowerCase() + "/last?format=json");
		Gson gson = new Gson();
		Currency ew = new Currency();
		ew = gson.fromJson(z, Currency.class);
		BigDecimal value = ew.getRates()[0].getMid();
		String valCode = ew.getCode();
		System.out.println("1 " + valCode + "=" + value + " PLN");

		return calculate(decimal, value);
	}
	
	public static BigDecimal printOneCurr(BigDecimal decimal, String curr_code, LocalDate localDate) {

		Connect connect = new Connect();
		String z = connect.connectToNBP("http://api.nbp.pl/api/exchangerates/rates/a/" + curr_code.toLowerCase()+"/" +localDate.toString()+ "?format=json");
		Gson gson = new Gson();
		Currency ew = new Currency();
		ew = gson.fromJson(z, Currency.class);
		BigDecimal value = ew.getRates()[0].getMid();
		String valCode = ew.getCode();
		System.out.println("1 " + valCode + "=" + value + " PLN");

		return calculate(decimal, value);
	}

	public static BigDecimal calculate(BigDecimal given, BigDecimal curr_val) {

		return given.multiply(curr_val);

	}

}
