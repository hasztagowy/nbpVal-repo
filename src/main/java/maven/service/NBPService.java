package maven.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import maven.entity.Currency;
import maven.exception.DataIsNullException;

public class NBPService implements CurrencyServiceStategy {

	final String url = "http://api.nbp.pl/api/exchangerates/rates/a/";

	@Override
	public Currency getCurrencyRecord(String currencyCode, LocalDate localDate) throws IOException {

		Currency currency = getDataFromJSON(currencyCode, localDate);

		return currency;
	}

	private Currency getDataFromJSON(String currencyCode, LocalDate localDate) throws IOException {

		String connector = connectToServis(currencyCode, localDate);

		Gson gson = new Gson();
		try {
			Currency JSON = gson.fromJson(connector, Currency.class);
			return JSON;
		} catch (JsonSyntaxException e) {
			throw new DataIsNullException("cant read data! " + e);
		}
	}

	private String connectToServis(String currencyCode, LocalDate localDate) throws IOException {

		URL myUrl = new URL(url + currencyCode.toLowerCase() + "/" + localDate.toString() + "?format=json");
		StringBuilder text = new StringBuilder();
		try (InputStream myInputStream = myUrl.openStream(); Scanner scanner = new Scanner(myInputStream)) {
			while (scanner.hasNextLine()) {
				text.append(scanner.nextLine());
			}
			return text.toString();

		}
	}

}
