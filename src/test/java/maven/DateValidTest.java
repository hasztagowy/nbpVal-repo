package maven;

import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import maven.valid.DateValidator;

public class DateValidTest {

	@Test
	void should_return_false_from_checkIfDateisFromFuture() {

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
	void should_return_true_if_date_is_from_future() {
		// given:
		DateValidator dateValid = new DateValidator();
		LocalDate dayFromFuture = LocalDate.now().plusDays(1);
		boolean isFuture = true;

		// when:
		boolean resultValidFutureDay = dateValid.checkIfDateisFromFuture(dayFromFuture);

		// then:
		Assert.assertEquals(isFuture, resultValidFutureDay);
	}

	@Test
	void should_return_same_date() {
		// given:
		DateValidator dateValid = new DateValidator();
		LocalDate monday = LocalDate.parse("2021-03-15");

		// when:
		LocalDate getMonday = dateValid.getValidDate(monday);

		// then:
		Assert.assertEquals(monday, getMonday);
	}

}
