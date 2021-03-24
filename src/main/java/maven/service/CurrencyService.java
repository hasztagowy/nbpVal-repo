package maven.service;

import java.io.IOException;
import java.time.LocalDate;

public interface CurrencyService {

	public String getCurrencyData(String currencyCode, LocalDate localDate) throws IOException;

}
