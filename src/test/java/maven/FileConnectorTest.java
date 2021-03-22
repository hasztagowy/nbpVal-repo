package maven;

import org.testng.Assert;
import org.testng.annotations.Test;

import maven.connector.FileConnector;

public class FileConnectorTest {
	
	FileConnector fileConnector=new FileConnector();
	
	@Test
	void ConnectionTest() {
		Assert.assertEquals(null, fileConnector.connect("text.txt"));
	}

}
