package maven;

import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import maven.valid.DateValidator;

public class BackDayTest {

	DateValidator dateValid = new DateValidator();

	@Test
	void testBackDay() {

		// given:
		DateValidator dateValid = new DateValidator();
		LocalDate today = LocalDate.now();
		LocalDate yesterday = LocalDate.now().minusDays(1);
		int howManyDays = 1;

		// when:
		LocalDate yesterdayFromdateValid = dateValid.backDays(today, howManyDays);

		// then:
		Assert.assertEquals(yesterday, yesterdayFromdateValid);
	}

	@Test
	void testBackWeekend() {

		// given:
		DateValidator dateValid = new DateValidator();
		LocalDate monday = LocalDate.parse("2021-03-22");
		LocalDate friday = LocalDate.parse("2021-03-19");
		int howManyDays = 1;

		// when:
		LocalDate fridayFromdateValid = dateValid.backDays(monday, howManyDays);

		// then:
		Assert.assertEquals(friday, fridayFromdateValid);
	}

	@Test
	void testBackWeekend2() {
		// given:
		DateValidator dateValid = new DateValidator();
		LocalDate monday = LocalDate.parse("2021-03-22");
		LocalDate friday = LocalDate.parse("2021-03-19");
		int howManyDays = 2;

		// when:
		LocalDate fridayFromdateValid = dateValid.backDays(monday, howManyDays);

		// then:
		Assert.assertEquals(friday, fridayFromdateValid);
	}

	@Test
	void testBackWeekend3() {
		// given:
		DateValidator dateValid = new DateValidator();
		LocalDate monday = LocalDate.parse("2021-03-22");
		LocalDate thusday = LocalDate.parse("2021-03-18");
		int howManyDays = 4;

		// when:
		LocalDate thusdayFromdateValid = dateValid.backDays(monday, howManyDays);

		// then:
		Assert.assertEquals(thusday, thusdayFromdateValid);
	}

}
