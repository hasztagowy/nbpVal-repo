package maven;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import maven.controller.MathOperator;
import maven.entity.Currency;
import maven.exception.DataNotExistException;
import maven.service.CurrencyServiceStategy;
import maven.service.NBPService;
import maven.valid.DateValidator;

public class CurrencyConverter {

	private CurrencyServiceStategy currencyServiceStategy;

	public CurrencyConverter() {
		this.currencyServiceStategy = new NBPService();
	}

	public CurrencyConverter(CurrencyServiceStategy currencyServiceStategy) {
		this.currencyServiceStategy = currencyServiceStategy;

	}

	public BigDecimal convertToPLN(BigDecimal decimal, String currCode, LocalDate localDate) {
		DateValidator dateValid = new DateValidator();

		localDate = dateValid.getValidDate(localDate);

		Currency currency = getValue(currencyServiceStategy, currCode, localDate);

		return MathOperator.calculate(decimal, currency.getRates()[0].getMid());
	}

	private Currency getValue(CurrencyServiceStategy currencyServiceStategy, String currCode, LocalDate localDate) {
		Currency currency = new Currency();
		int tryToConnect = 10;

		while (true) {
			try {
				currency = currencyServiceStategy.getCurrencyRecord(currCode, localDate);
				if (currency.getRates()[0].getMid() != null) {
					System.out.println(localDate);
					tryToConnect--;
					return currency;
				}
			} catch (IOException e) {
				localDate = localDate.minusDays(1);
				tryToConnect--;
				if (tryToConnect == 0) {
					throw new DataNotExistException("cant get data from " + e.getLocalizedMessage());
				}
			}

		}

	}

}
