package maven;

import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import maven.valid.DateValidator;

public class DateWeekendTest {
	
	DateValidator dateValid=new DateValidator();
	
	
	@Test
	void testChangeDateIfIsAWeekend() {
		Assert.assertEquals(LocalDate.parse("2021-03-19"), dateValid.minusWeekend(LocalDate.parse("2021-03-20")));
	}
	
	@Test
	void testChangeDateIfIsAWeekend1() {
		Assert.assertEquals(LocalDate.parse("2021-03-19"), dateValid.minusWeekend(LocalDate.parse("2021-03-20")));
	}
	
	@Test
	void testChangeDateIfIsAWeekend2() {
		Assert.assertEquals(false, dateValid.checkIfDateIsAWeekend(LocalDate.parse("2021-03-17")));
	}
	
	@Test
	void testWeekendDayFalse() {
		Assert.assertEquals(false, dateValid.checkIfDateIsAWeekend(LocalDate.parse("2021-03-19")));
	}
	
	@Test
	void testWeekendDayFalse2() {
		Assert.assertEquals(false, dateValid.checkIfDateIsAWeekend(LocalDate.parse("2021-03-05")));
	}
	
	@Test
	void testWeekendDayFalse3() {
		Assert.assertEquals(false, dateValid.checkIfDateIsAWeekend(LocalDate.parse("2021-03-04")));
	}
	
	@Test
	void testWeekendDayTrue() {
		Assert.assertEquals(true, dateValid.checkIfDateIsAWeekend(LocalDate.parse("2021-03-20")));
	}
	
	@Test
	void testWeekendDayTrue1() {
		Assert.assertEquals(true, dateValid.checkIfDateIsAWeekend(LocalDate.parse("2021-03-27")));
	}
	
	@Test
	void testWeekendDayTrue2() {
		Assert.assertEquals(true, dateValid.checkIfDateIsAWeekend(LocalDate.parse("2021-03-28")));
	}
}
