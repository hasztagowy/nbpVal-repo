package maven.entity;

import java.math.BigDecimal;

public class Rate {
//	public String no;
	private String effectiveDate;
	private BigDecimal mid;
	private String currency;
	private String code;

	public BigDecimal getMid() {
		return mid;
	}

	public void setMid(BigDecimal mid) {
		this.mid = mid;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

}
