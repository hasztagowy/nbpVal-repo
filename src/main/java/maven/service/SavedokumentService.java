package maven.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import maven.CurrencyConverter;

public class SavedokumentService {

	public void insert() {
		CurrencyConverter currencyConverter = new CurrencyConverter();

		BigDecimal userVal = new BigDecimal(10);

		BigDecimal res = currencyConverter.convertToPLN(userVal, "eur", LocalDate.now());
		System.out.println(res);

	}

}
