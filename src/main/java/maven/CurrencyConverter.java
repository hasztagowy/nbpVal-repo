package maven;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import maven.convert.Converter;
import maven.convert.ConverterJSONFromNBPToObject;
import maven.entity.Currency;
import maven.entity.CurrencyResoult;
import maven.exception.DataIsNullException;
import maven.service.CurrencyService;
import maven.service.NBPService;
import maven.valid.DateValidator;

public class CurrencyConverter {

	private CurrencyService currencyServiceProvider;
	private Converter converter;

	public CurrencyConverter() {
		this.currencyServiceProvider = new NBPService();
		this.converter = new ConverterJSONFromNBPToObject();
	}

	public CurrencyConverter(CurrencyService currencyServiceStategy) {
		this.currencyServiceProvider = currencyServiceStategy;
		this.converter = converter;
	}

	public CurrencyConverter(Converter converter) {
		this.converter = converter;
	}

	public CurrencyResoult convertToPLN(BigDecimal decimal, String currCode, LocalDate localDate) {

		DateValidator.getValidDate(localDate);

		String data = getDataInString(currCode, localDate);

		Currency currency = converter.covert(data);

		CurrencyResoult currencyResoult = new CurrencyResoult(currency, decimal);

		return currencyResoult;
	}

	private String getDataInString(String currCode, LocalDate localDate) {
		int tryToConnect = 10;

		while (true) {
			try {
				String data = currencyServiceProvider.getCurrencyData(currCode, localDate);
				if (data != null) {
					return data;
				}
			} catch (IOException e) {
				localDate = localDate.minusDays(1);
				tryToConnect--;
				if (tryToConnect == 0) {
					throw new DataIsNullException("cant get data from " + e.getLocalizedMessage());
				}
			}

		}

	}

}
