package maven.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import maven.CurrencyConverter;
import maven.entity.CurrencyResoult;

public class SavedokumentService {

	public void insert() {
		CurrencyConverter currencyConverter = new CurrencyConverter();

		BigDecimal userVal = new BigDecimal(10);

		CurrencyResoult res = currencyConverter.convertToPLN(userVal, "eur", LocalDate.now());
		System.out.println(res.getResoult());

	}

}
