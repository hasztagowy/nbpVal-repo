package maven;

import static org.testng.Assert.assertEquals;

import java.time.LocalDate;

import org.testng.annotations.Test;

import maven.valid.DateValidator;

public class DateWeekendTest {

	DateValidator dateValid = new DateValidator();

	@Test
	void should_return_friday_from_minusWeekend1() {
		// given:
		LocalDate friday = LocalDate.parse("2021-03-19");
		LocalDate saturday = LocalDate.parse("2021-03-20");

		// when:
		LocalDate fridayFromValid = dateValid.minusWeekend(saturday);

		// then:
		assertEquals(friday, fridayFromValid);
	}

	@Test
	void should_return_friday_from_minusWeekend2() {
		// given:
		LocalDate friday = LocalDate.parse("2021-03-19");
		LocalDate sunday = LocalDate.parse("2021-03-21");

		// when:
		LocalDate fridayFromValid = dateValid.minusWeekend(sunday);

		// then:
		assertEquals(friday, fridayFromValid);

	}
}
