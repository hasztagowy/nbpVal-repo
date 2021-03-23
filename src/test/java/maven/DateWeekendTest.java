package maven;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.time.LocalDate;

import org.testng.annotations.Test;

import maven.valid.DateValidator;

public class DateWeekendTest {

	DateValidator dateValid = new DateValidator();

	@Test
	void testChangeDateIfIsAWeekend() {
		// given:
		LocalDate friday = LocalDate.parse("2021-03-19");
		LocalDate saturday = LocalDate.parse("2021-03-20");

		// when:
		LocalDate fridayFromValid = dateValid.minusWeekend(saturday);

		// then:
		assertEquals(friday, fridayFromValid);
	}

	@Test
	void testChangeDateIfIsAWeekend1() {
		// given:
		LocalDate friday = LocalDate.parse("2021-03-19");
		LocalDate sunday = LocalDate.parse("2021-03-21");

		// when:
		LocalDate fridayFromValid = dateValid.minusWeekend(sunday);

		// then:
		assertEquals(friday, fridayFromValid);

	}

	@Test
	void testChangeDateIfIsAWeekend2() {
		// given:
		LocalDate sunday = LocalDate.parse("2021-03-21");

		// when:
		LocalDate fridayFromValid = dateValid.minusWeekend(sunday);

		// then:
		assertNotEquals(sunday, fridayFromValid);

	}
}
