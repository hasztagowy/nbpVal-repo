package maven;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.testng.annotations.Test;

public class CurrencyMethodsTest {

	@Test
	public void currencyConvertTest() {
		// given:
		BigDecimal value = new BigDecimal(10);
		LocalDate date = LocalDate.parse("2020-12-26");
		CurrencyConverter currencyConverter = new CurrencyConverter();
		String currCode = "eur";

		// when:
		BigDecimal valueFromConverter = currencyConverter.convertToPLN(value, currCode, date);

		// then:

	}

}
