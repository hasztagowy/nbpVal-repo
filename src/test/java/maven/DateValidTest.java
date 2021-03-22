package maven;

import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import maven.valid.DateValidator;

public class DateValidTest {

	@Test
	void testDateFromFuture() {

		// given:
		DateValidator dateValid = new DateValidator();
		LocalDate today = LocalDate.now();
		boolean notFuture = false;

		// when:
		boolean todayDate = dateValid.checkIfDateisFromFuture(today);

		// then:
		Assert.assertEquals(notFuture, todayDate);
	}

	@Test
	void testDateFromFuture2() {
		// given:
		DateValidator dateValid = new DateValidator();

		Assert.assertEquals(false, dateValid.checkIfDateisFromFuture(LocalDate.parse("2002-02-02")));
	}

	@Test
	void testDataFromFuture3() {
		// given:
		DateValidator dateValid = new DateValidator();
		LocalDate dayFromFuture = LocalDate.parse("2022-02-02");
		boolean isFuture = false;

		// when:
		boolean resultValidFutureDay = dateValid.checkIfDateisFromFuture(dayFromFuture);

		// then::
		Assert.assertEquals(isFuture, resultValidFutureDay);
	}

	@Test
	void testDateValid() {
		// given:
		DateValidator dateValid = new DateValidator();
		LocalDate monday = LocalDate.parse("2021-03-18");

		// when:
		LocalDate getMonday = dateValid.getValidDate(monday);

		// then:
		Assert.assertEquals(monday, getMonday);
	}

}
