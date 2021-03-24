package maven;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import maven.entity.CurrencyResoult;
import maven.exception.DataNotFoundException;
import maven.service.NBPService;

public class CurrencyMethodsTest {

	@Mock
	NBPService mockCurrencyConverter = Mockito.mock(NBPService.class);

	@Test
	public void should_throw_DataNotExistException_when_cant_get_data_ten_times() throws IOException {
		// given:
		String currencyCode = "eur";
		BigDecimal value = new BigDecimal(10);
		LocalDate date = LocalDate.now();

		Mockito.when(mockCurrencyConverter.getCurrencyData(currencyCode, date)).thenReturn(null);
		Mockito.when(mockCurrencyConverter.getCurrencyData(currencyCode, date.minusDays(1))).thenReturn(null);
		Mockito.when(mockCurrencyConverter.getCurrencyData(currencyCode, date.minusDays(2))).thenReturn(null);
		Mockito.when(mockCurrencyConverter.getCurrencyData(currencyCode, date.minusDays(3))).thenReturn(null);
		Mockito.when(mockCurrencyConverter.getCurrencyData(currencyCode, date.minusDays(4))).thenReturn(null);
		Mockito.when(mockCurrencyConverter.getCurrencyData(currencyCode, date.minusDays(5))).thenReturn(null);
		Mockito.when(mockCurrencyConverter.getCurrencyData(currencyCode, date.minusDays(6))).thenReturn(null);
		Mockito.when(mockCurrencyConverter.getCurrencyData(currencyCode, date.minusDays(7))).thenReturn(null);
		Mockito.when(mockCurrencyConverter.getCurrencyData(currencyCode, date.minusDays(8))).thenReturn(null);
		Mockito.when(mockCurrencyConverter.getCurrencyData(currencyCode, date.minusDays(9))).thenReturn(null);

		// when:
		Throwable throwable = catchThrowable(
				() -> new CurrencyConverter(mockCurrencyConverter).convertToPLN(value, currencyCode, date));

		// then:
		assertThat(throwable).isInstanceOf(DataNotFoundException.class);
	}

	@Test
	public void should_return_dolar_exchange_rate_from_friday() {

		BigDecimal exchangeRateFromFriday = new BigDecimal(3.8865).setScale(4, RoundingMode.CEILING);
		String currencyCode = "usd";
		LocalDate friday = LocalDate.parse("2021-03-19");
		CurrencyConverter currencyConverter = new CurrencyConverter();
		CurrencyResoult currency = new CurrencyResoult();

		currency = currencyConverter.convertToPLN(exchangeRateFromFriday, currencyCode, friday);
		assertEquals(currency.getValue(), exchangeRateFromFriday);

	}

	@Test
	public void should_return_dolar_exchange_rate_from_last_friday() {

		BigDecimal exchangeRateFromFriday = new BigDecimal(3.8865).setScale(4, RoundingMode.CEILING);
		String currencyCode = "usd";
		LocalDate sunday = LocalDate.parse("2021-03-21");
		CurrencyConverter currencyConverter = new CurrencyConverter();
		CurrencyResoult currency = new CurrencyResoult();

		currency = currencyConverter.convertToPLN(exchangeRateFromFriday, currencyCode, sunday);
		assertEquals(currency.getValue(), exchangeRateFromFriday);

	}

	@Test
	public void should_return_date_before_chrismas() {

		BigDecimal exchangeRateFromFriday = new BigDecimal(3.8865);
		String currencyCode = "usd";
		LocalDate chrismas = LocalDate.parse("2020-12-26");
		LocalDate expectDate = LocalDate.parse("2020-12-24");
		CurrencyConverter currencyConverter = new CurrencyConverter();
		CurrencyResoult currency = new CurrencyResoult();

		currency = currencyConverter.convertToPLN(exchangeRateFromFriday, currencyCode, chrismas);
		assertEquals(currency.getLocalDate(), expectDate);

	}

}
