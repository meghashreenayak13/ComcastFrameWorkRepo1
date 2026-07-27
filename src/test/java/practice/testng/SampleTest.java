package practice.testng;

import org.testng.annotations.Test;

public class SampleTest {
   @Test
   public void createContactTest() {
	   System.out.println("execute login");
	   System.out.println("exceute navigate to contact");
	   System.out.println("exceute create contact");
	   System.out.println("verify contact");
	   System.out.println("exceute navigate to contact");  // write all the realted to single testcasein one testng method instead of using multiplke testng method for each scenario
	   
   }

   @Test
   public void createcontactWithMobileNumberTest() {
	   System.out.println("excecute createcontactwithmobilenumber");
   }

@Test 
public int createContactWithPhone(int phone) {
	System.out.println("creating contact with phone");  ///this ll not exceutew bcos return type is string
	return phone;
	
}
@Test
private void createContactWithPhone() {
	System.out.println("create contact with phone");
}


}
