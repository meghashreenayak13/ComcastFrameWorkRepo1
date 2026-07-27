package PracticeDDT;

import org.testng.annotations.Test;

public class ReadRunTimeParameterTest {

	@Test
	public void runtimeParameterTest() {
		String url=System.getProperty("url");
		String USERNAME=System.getProperty("username");
System.out.println("Env Data==>URL==>"+url);
System.out.println("Browser Data==>"+USERNAME);
	}

}
