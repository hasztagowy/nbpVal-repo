package maven;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import maven.connector.JSONReader;
import maven.connector.URLConnector;
import maven.controller.MathOperator;
import maven.entity.Currency;
import maven.exception.DataNotExistException;
import maven.valid.DateValidator;
import maven.valid.ValueValidator;

public class CurrencyConverter {
	private static String url;

	public CurrencyConverter() {
		this.url = "http://api.nbp.pl/api/exchangerates/rates/a/";
	}

	public CurrencyConverter(String url) {
		this.url = url;
	}

	public static BigDecimal convertToPLN(BigDecimal givenVal, String currCode) {

		URLConnector connector = new URLConnector();
		String connectString = connector.connect(url + currCode.toLowerCase() + "/last?format=json");
		Gson gson = new Gson();
		Currency currency = new Currency();
		try {
			currency = gson.fromJson(connectString, Currency.class);
		} catch (JsonSyntaxException e) {
			System.err.println("fail to read JSON");
		}

		return MathOperator.calculate(givenVal, currency.getRates()[0].getMid());
	}

	public static BigDecimal convertToPLN(BigDecimal decimal, String currCode, LocalDate localDate) {
		DateValidator dateValid = new DateValidator();

		URLConnector connector = new URLConnector();

		ValueValidator valueValidator = new ValueValidator();

		localDate = dateValid.getValidDate(localDate);
		int tryToConnect = 2;

		while (true) {
			try {
				if (connector
						.checkConnection(url + currCode.toLowerCase() + "/" + localDate.toString() + "?format=json")) {
					System.out.println(localDate);
					break;
				}
			} catch (IOException e) {
				localDate = localDate.minusDays(1);
				tryToConnect--;
				if (tryToConnect == 0) {
					throw new DataNotExistException("cant get data check data!" + e.getLocalizedMessage());
				}
			}

		}

		String connect = connector.connect(url + currCode.toLowerCase() + "/" + localDate.toString() + "?format=json");

		Currency currency = new Currency();

		JSONReader jsonReader = new JSONReader();

		currency = jsonReader.getDataFromJson(connect, currency);

		return MathOperator.calculate(decimal, currency.getRates()[0].getMid());
	}
}
