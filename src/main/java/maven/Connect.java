package maven;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class Connect {
	
	public String aaz(String urlText) {
		 try {
             URL myUrl = new URL(urlText);
             StringBuilder jsonText = new StringBuilder();
             try (InputStream myInputStream = myUrl.openStream();
             Scanner scanner = new Scanner(myInputStream)) {
             while (scanner.hasNextLine()) {
                          jsonText.append(scanner.nextLine());
               }
                      return jsonText.toString();
            }
            } catch (IOException e) {
            System.err.println("Failed to get content from URL" + urlText + " due to exception:"  + e.getMessage());
            return null;
            }
	}

}
