package maven.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.util.Scanner;

import maven.exception.DataNotFoundException;

public class NBPService implements CurrencyService {

	final String url = "http://api.nbp.pl/api/exchangerates/rates/a/";

	@Override
	public String getCurrencyData(String currencyCode, LocalDate localDate) throws IOException {

		String connector = connectToServis(currencyCode, localDate);
		return connector;
	}

	private String connectToServis(String currencyCode, LocalDate localDate) throws IOException {

		URL myUrl = new URL(url + currencyCode.toLowerCase() + "/" + localDate.toString() + "?format=json");
		StringBuilder text = new StringBuilder();
		try (InputStream myInputStream = myUrl.openStream(); Scanner scanner = new Scanner(myInputStream)) {
			while (scanner.hasNextLine()) {
				text.append(scanner.nextLine());
			}
			return text.toString();
		} catch (UnknownHostException e) {
			throw new DataNotFoundException("cant connect to: " + e.getLocalizedMessage());
		}
	}

}
