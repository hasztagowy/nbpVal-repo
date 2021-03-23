package maven.service;

import java.io.IOException;
import java.time.LocalDate;

import maven.entity.Currency;

public interface CurrencyServiceStategy {

	public Currency getCurrencyRecord(String currencyCode, LocalDate localDate) throws IOException;

}
