package maven.connector;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import maven.exception.DataIsNullException;

public class JSONReader {

	public maven.entity.Currency getDataFromJson(String connect, maven.entity.Currency currency) {

		Gson gson = new Gson();
		try {
			currency = gson.fromJson(connect, maven.entity.Currency.class);
			return currency;
		} catch (JsonSyntaxException e) {
			throw new DataIsNullException("cant read data! " + e);
		}

	}

}
