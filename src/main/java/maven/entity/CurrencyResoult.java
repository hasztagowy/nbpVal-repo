package maven.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import maven.controller.MathOperator;

public class CurrencyResoult {

	public CurrencyResoult() {
		// TODO Auto-generated constructor stub
	}

	public CurrencyResoult(Currency currency, BigDecimal valueToMultiply) {

		this.localDate = LocalDate.parse(currency.getRates()[0].getEffectiveDate());
		this.value = currency.getRates()[0].getMid();
		this.currencyCode = currency.getCode();

		this.resoult = MathOperator.calculate(currency.getRates()[0].getMid(), valueToMultiply);
	}

	private BigDecimal value;
	private String currencyCode;
	private LocalDate localDate;
	private BigDecimal resoult;

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public BigDecimal getResoult() {
		return resoult;
	}

	public void setResoult(BigDecimal resoult) {
		this.resoult = resoult;
	}

}
