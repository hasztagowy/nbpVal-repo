package maven;
import java.math.BigDecimal;

public class Currency {
	private String table;
	// public String currency;
	private String code;
	private Rate[] rates;
	//public BigDecimal rate;
	
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Rate[] getRates() {
		return rates;
	}
	public void setRates(Rate[] rates) {
		this.rates = rates;
	}
	

}
