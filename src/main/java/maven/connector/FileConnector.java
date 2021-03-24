package maven.connector;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import maven.exception.DataNotFoundException;

public class FileConnector implements ConnectStrategy {

	public String connect(String path) {
		try {
			File file = new File(path);
			StringBuilder textFromFile = new StringBuilder();
			try (InputStream myInputStream = new FileInputStream(file); Scanner scanner = new Scanner(myInputStream)) {
				while (scanner.hasNextLine()) {
					textFromFile.append(scanner.nextLine());
				}
				return textFromFile.toString();
			}
		} catch (IOException e) {
			throw new DataNotFoundException("can't read file! " + e);
		}
	}

}
