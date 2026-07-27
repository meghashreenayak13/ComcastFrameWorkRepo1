package practice.testng;

import org.testng.annotations.Test;

public class InvocOrderTest {     //we go for dataprovider usually
	@Test(invocationCount=10)
	public void createOrderTest() {
		System.out.println("Exceute create order==>123");
		//String str=null;
		//System.out.println(str.equals("123"));  //if this fails the dependent method will gwt skipped
	}

	@Test(enabled=false)
	public void billingOrder() {
		System.out.println("Exceute billing order==>123");
	}
}
