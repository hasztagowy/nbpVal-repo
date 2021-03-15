package maven;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import javax.swing.text.Document;

public class Connection {
	public Connection() {
		// TODO Auto-generated constructor stub
	}
	public void connectToNBP() throws IOException, URISyntaxException, InterruptedException {
	
		/*URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/a/chf/");
	HttpURLConnection con = (HttpURLConnection) url.openConnection();
	con.setRequestMethod("GET");
	
	InputStream response=con.getInputStream();
	
	System.out.println(response);
	*/
		URI uri=new URI("http://api.nbp.pl/api/exchangerates/tables/a/");
		HttpClient httpClient=HttpClient.newHttpClient();
		
		HttpRequest request=HttpRequest.newBuilder()
				.uri(uri)
				.build();
		
		HttpResponse<String>res= httpClient.send(request, BodyHandlers.ofString());
		System.out.println(res.body());
	
	}

}
