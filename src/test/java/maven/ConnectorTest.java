package maven;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.testng.annotations.Test;

import maven.connector.FileConnector;
import maven.exception.DataNotExistException;

public class ConnectorTest {

	FileConnector fileConnector = new FileConnector();

	@Test
	public void exceptionDataNotExistTest() {
		// given:
		Throwable throwable;
		BigDecimal value = new BigDecimal(10);
		LocalDate date = LocalDate.parse("2020-12-26");
		CurrencyConverter currencyConverter = new CurrencyConverter();

		// when:
		throwable = catchThrowable(() -> currencyConverter.convertToPLN(value, "eur", date));

		// then:
		assertThat(throwable).isInstanceOf(DataNotExistException.class);

	}

}
