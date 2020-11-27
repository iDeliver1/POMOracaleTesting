package com.AP.qa.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.AP.qa.base.TestBase;

public class TestUtil extends TestBase{
	
static String rootdir;
static Extent_Report objRep = new Extent_Report();
public static long PAGE_LOAD_TIMEOUT = 40;
public static long IMPLICIT_WAIT = 40;
public static String Report_Folder_path = "C:\\Reporting";
public static String brow;


public static String fGetCurrentDate()
{
	Date date = new Date();  
    SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");  
    String strDate = dateformat.format(date); 
    return strDate;
}

	
//-------------------------------------------TimeStamp Function----------------------------------	
	public static String fTimestamp()
		{
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
			String time = dateFormat.format(now);
			return time.replace("-", "");
		}
		 
//-----------------------------------------------Screenshot Function-------------------------------	
	  
	   
		
					
		//-------------------Function for determining Chrome Browser Version---------------------
		public static String getBrowserVersion() throws IOException {
			
			try {
				
				Runtime rt = Runtime.getRuntime();
			    try {
			    	rootdir = System.getProperty("user.dir");
			     
			    	rt.exec("cmd  /K \"dir /B/AD \"C:/Program Files (x86)/Google/Chrome/Application/\"|findstr /R /C:\"^[0-9].*\\..*[0-9]$\" > "+ rootdir +"\\version.txt\"");
			    	//C:\Program Files (x86)\Google\Chrome\Application
			       brow = getversion();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			return brow.substring(0, brow.length() - 4);
		}
		catch(Exception e)
		{
		brow = e.toString();
			return brow;
		}
		
		}
		
		//--------------------Return Stored value of  Chrome Browser Version----------------------------
		public static String getversion() {
			 String data = "";
			try {
			  File myObj = new File(rootdir+"/version.txt"); //File myObj = new File("E:/version.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		         data = myReader.nextLine();
		        System.out.println(data);
		        break;
		        
		      }
		      myReader.close();
		      return data;
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  
			return null;
		}
		
		
		
		//------------------Function for move able object------------------- 
		public void MoveElement(WebElement element) {
			Actions action = new Actions(getDriver());
			action.moveToElement(element).build().perform();
		}
		
		
		//---------------------function for Select size --------------------
		public static void SelectQuantity(List<WebElement> element,String size) {
			System.out.println(element.size());
			for(int i=0;i<element.size();i++) {
				if(element.get(i).getAttribute("Title").contains(size)) {
					element.get(i).click();
					break;
				}
			}
		}
}
