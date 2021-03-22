package maven.valid;

import java.math.BigDecimal;

public class ValueValidator {

	public boolean checkIfValueAreGreaterThanZero(BigDecimal value) {
		return value.compareTo(BigDecimal.ZERO) > 0;
	}

}
