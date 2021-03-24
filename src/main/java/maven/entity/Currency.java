package maven.entity;

public class Currency {
	private String table;
	private String code;
	private Rate[] rates;
	private String effectiveDate;

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
