package maven.valid;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class DateValidator {

	public boolean checkIfDateIsAWeekend(LocalDate localDate) {
		if (localDate.getDayOfWeek().equals(DayOfWeek.SATURDAY))
			return true;
		if (localDate.getDayOfWeek().equals(DayOfWeek.SUNDAY))
			return true;
		return false;
	}

	public LocalDate minusWeekend(LocalDate localDate) {
		if (localDate.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
			localDate = localDate.minusDays(1);
		} else if (localDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
			localDate = localDate.minusDays(2);
		}
		return localDate;

	}

	public boolean checkIfDateisFromFuture(LocalDate localDate) {
		return localDate.isAfter(LocalDate.now());
	}

	public boolean checkIfTimeIsBefore12() {
		return LocalTime.now().isBefore(LocalTime.parse("12:00"));
	}

	public LocalDate backDays(LocalDate localDate, int days) {
		localDate = localDate.minusDays(days);

		if (checkIfDateIsAWeekend(localDate)) {
			return minusWeekend(localDate);
		}
		return localDate;

	}

	public LocalDate getValidDate(LocalDate localDate) {

		if (checkIfDateisFromFuture(localDate)) {
			localDate = LocalDate.now();
		}

		if (checkIfDateIsAWeekend(localDate)) {
			minusWeekend(localDate);
		} else if (checkIfTimeIsBefore12() && localDate.equals(LocalDate.now())) {
			return LocalDate.now().minusDays(1);
		}
		return localDate;
	}
}