package maven;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import maven.connector.JSONReader;
import maven.connector.URLConnector;
import maven.controller.MathOperator;
import maven.entity.Currency;
import maven.valid.DateValidator;
import maven.valid.ValueValidator;

public class CurrencyConverter {

	public static BigDecimal convertToPLN(BigDecimal givenVal, String currCode) {

		URLConnector connector = new URLConnector();
		String z = connector
				.connect("http://api.nbp.pl/api/exchangerates/rates/a/" + currCode.toLowerCase() + "/last?format=json");
		Gson gson = new Gson();
		Currency currency = new Currency();
		try {
			currency = gson.fromJson(z, Currency.class);
		} catch (JsonSyntaxException e) {
			System.err.println("fail to read JSON");
		}

		return MathOperator.calculate(givenVal, currency.getRates()[0].getMid());
	}

	public static BigDecimal convertToPLN(BigDecimal decimal, String currCode, LocalDate localDate) {
		DateValidator dateValid = new DateValidator();

		String url = "http://api.nbp.pl/api/exchangerates/rates/a/";
		URLConnector connector = new URLConnector();

		ValueValidator valueValidator = new ValueValidator();

		localDate = dateValid.getValidDate(localDate);

		if (connector
				.checkConnection(url + currCode.toLowerCase() + "/" + localDate.toString() + "?format=json") != true) {
			localDate.minusDays(1);
			connector.checkConnection(url + currCode.toLowerCase() + "/" + localDate.toString() + "?format=json");
		}

		String connect = connector.connect(url + currCode.toLowerCase() + "/" + localDate.toString() + "?format=json");

		Currency currency = new Currency();

		JSONReader jsonReader = new JSONReader();

		currency = jsonReader.getDataFromJson(connect, currency);

		return MathOperator.calculate(decimal, currency.getRates()[0].getMid());
	}

	public static BigDecimal convertToPLN(BigDecimal decimal, String currCode, LocalDate localDate, String url) {
		DateValidator dateValid = new DateValidator();

		URLConnector connector = new URLConnector();

		ValueValidator valueValidator = new ValueValidator();

		localDate = dateValid.getValidDate(localDate);

		if (connector.checkConnection(url) != true) {
			localDate.minusDays(1);
			connector.checkConnection(url);
		}

		String connect = connector.connect(url + currCode.toLowerCase() + "/" + localDate.toString() + "?format=json");

		Currency currency = new Currency();

		JSONReader jsonReader = new JSONReader();

		currency = jsonReader.getDataFromJson(connect, currency);

		return MathOperator.calculate(decimal, currency.getRates()[0].getMid());
	}

}
