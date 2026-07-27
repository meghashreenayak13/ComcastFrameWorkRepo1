package PracticeDDT;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class ReadDataFromJsonTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// step1:parse JSON physical fil;e into Java Object using Json parse class
   JSONParser parser=new JSONParser();
  Object obj= parser.parse(new FileReader("C:\\Users\\ASUS\\Desktop\\automationpractice\\appCommonData.json"));//parse convert one object to other obj here we are converting java obj to json obj
	
  //step2 :convert java object into json object using downcasting
  JSONObject map=(JSONObject)obj;
  
  //step 3: get the value from json using key
  System.out.println(map.get("url"));
  System.out.println(map.get("username"));
	}

}
