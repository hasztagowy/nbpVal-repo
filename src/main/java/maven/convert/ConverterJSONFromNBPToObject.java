package maven.convert;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import maven.entity.Currency;
import maven.exception.DataIsNullException;

public class ConverterJSONFromNBPToObject implements Converter {

	@Override
	public Currency covert(String data) {

		Gson gson = new Gson();
		try {
			Currency JSON = gson.fromJson(data, Currency.class);
			return JSON;

		} catch (JsonSyntaxException e) {
			throw new DataIsNullException("cant read data! " + e.getLocalizedMessage());
		}

	}
}
