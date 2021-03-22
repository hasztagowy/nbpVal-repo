package maven.controller;

import java.math.BigDecimal;

public class MathOperator {

	public static BigDecimal calculate(BigDecimal given, BigDecimal curr_val) {

		return given.multiply(curr_val);
	}

}
