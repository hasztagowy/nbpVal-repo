package maven.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import maven.CurrencyConverter;

public class SavedokumentService {

	public void insert() {
		CurrencyConverter currencyConverter = new CurrencyConverter();

		BigDecimal userVal = new BigDecimal(10);

		BigDecimal res = currencyConverter.convertToPLN(userVal, "eur", LocalDate.parse("2020-12-26"));
		System.out.println(res);

	}

}
