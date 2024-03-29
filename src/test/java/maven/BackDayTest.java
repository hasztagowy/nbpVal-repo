package maven;

import static org.testng.Assert.assertEquals;

import java.time.LocalDate;

import org.testng.annotations.Test;

import maven.valid.DateValidator;

public class BackDayTest {

	@Test
	void should_return_yesterday_or_if_is_a_weekend_friday() {

		// given:
		DateValidator dateValid = new DateValidator();
		LocalDate today = LocalDate.now();
		LocalDate yesterday = LocalDate.now().minusDays(1);
		int howManyDays = 1;

		// when:
		LocalDate yesterdayFromdateValid = dateValid.backDays(today, howManyDays);

		// then:
		assertEquals(yesterday, yesterdayFromdateValid);
	}

	@Test
	void should_return_friday_from_backDays() {

		// given:
		DateValidator dateValid = new DateValidator();
		LocalDate monday = LocalDate.parse("2021-03-22");
		LocalDate friday = LocalDate.parse("2021-03-19");
		int howManyDays = 1;

		// when:
		LocalDate fridayFromdateValid = dateValid.backDays(monday, howManyDays);

		// then:
		assertEquals(friday, fridayFromdateValid);
	}

	@Test
	void should_return_friday2_from_backDays() {
		// given:
		DateValidator dateValid = new DateValidator();
		LocalDate monday = LocalDate.parse("2021-03-22");
		LocalDate friday = LocalDate.parse("2021-03-19");
		int howManyDays = 2;

		// when:
		LocalDate fridayFromdateValid = dateValid.backDays(monday, howManyDays);

		// then:
		assertEquals(friday, fridayFromdateValid);
	}

	@Test
	void should_return_thusday_from_backDays() {
		// given:
		DateValidator dateValid = new DateValidator();
		LocalDate monday = LocalDate.parse("2021-03-22");
		LocalDate thusday = LocalDate.parse("2021-03-18");
		int howManyDays = 4;

		// when:
		LocalDate thusdayFromdateValid = dateValid.backDays(monday, howManyDays);

		// then:
		assertEquals(thusday, thusdayFromdateValid);
	}

}
