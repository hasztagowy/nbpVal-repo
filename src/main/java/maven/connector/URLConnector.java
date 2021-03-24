package maven.connector;

import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.URL;
import java.util.Scanner;

import maven.exception.DataNotFoundException;
import maven.exception.HttpConnectFailException;

public class URLConnector implements ConnectStrategy {

	public String connect(String urlText) {
		try {
			URL myUrl = new URL(urlText);
			StringBuilder text = new StringBuilder();
			try (InputStream myInputStream = myUrl.openStream(); Scanner scanner = new Scanner(myInputStream)) {
				while (scanner.hasNextLine()) {
					text.append(scanner.nextLine());
				}
				return text.toString();
			} catch (ConnectException e) {
				throw new HttpConnectFailException("Faild to connect server");
			}
		} catch (IOException e) {
			throw new DataNotFoundException("\ncant read data! " + e);
		}
	}

	public boolean checkConnection(String urlText) throws IOException {

		URL myUrl = new URL(urlText);
		StringBuilder text = new StringBuilder();
		try (InputStream myInputStream = myUrl.openStream(); Scanner scanner = new Scanner(myInputStream)) {
			return scanner.hasNextLine();

		}

	}

}
