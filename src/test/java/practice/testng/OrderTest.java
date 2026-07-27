package practice.testng;

import org.testng.annotations.Test;

public class OrderTest {
@Test
public void createOrderTest() {
	System.out.println("Exceute create order==>123");
	String str=null;
	System.out.println(str.equals("123"));  //if this fails the dependent method will gwt skipped
}

@Test(dependsOnMethods="createOrderTest")
public void billingOrder() {
	System.out.println("Exceute billing order==>123");
}
}
