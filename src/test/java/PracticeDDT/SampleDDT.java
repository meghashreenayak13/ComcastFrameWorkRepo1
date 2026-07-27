package PracticeDDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SampleDDT {

	public static void main(String[] args) throws IOException {
			// step1:get the java representation object of the physical file"
			FileInputStream	fis=new FileInputStream("C:\\Users\\ASUS\\Desktop\\commandata.properties");
			//step2:using property class load all the keys
			Properties pObj=new Properties();
			pObj.load(fis);
			//step3:get the value based on the key
			System.out.println(pObj.getProperty("url"));
			}

		}

	


