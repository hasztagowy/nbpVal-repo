package maven;

import java.math.BigDecimal;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CurrencyTable {
	@Id
	@GeneratedValue
	private Long id;
	private BigDecimal value;
	private String curr_code;
	
	public String getCurr_code() {
		return curr_code;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public void setCurr_code(String curr_code) {
		this.curr_code = curr_code;
	}

}
