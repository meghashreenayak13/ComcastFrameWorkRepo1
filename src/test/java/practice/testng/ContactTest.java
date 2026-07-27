package practice.testng;

import org.testng.annotations.Test;

public class ContactTest {

	@Test(priority=-1)
	public void createContactTest() {
		System.out.println("exceute contact test");
	}
	@Test(priority=3)
	public void modifyContactTest() {
		System.out.println("exceute modify test");
	}
	
	@Test(priority=0)
	public void deleteContactTest() {
		System.out.println("exvceute delete contact");
	}
}
