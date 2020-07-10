package apachepoicode.apachepoicode;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.qa.XLSfile.Xls_Reader;

public class WebTableHandle {
	public WebDriver driver;
	@Test
	public void webtableexample() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\New folder\\drivers_selenium\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		
		String beforeXpath_company="//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath_company="]/td[1]";
		
		String beforeXpath_contact="//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath_contact="]/td[2]";
		
		String beforeXpath_country="//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath_country="]/td[3]";
		
		 List<WebElement> rows=  driver.findElements(By.xpath("//table[@id='customers']//tr"));
		 System.out.println("total number of rows= "+(rows.size()-1));
		 int rowcount=rows.size();	
		 
		 
		 Xls_Reader reader=new Xls_Reader("C:\\Users\\poonamk6.BIRLASOFT\\eclipse-workspace\\apachepoicode"
		 		+ "\\src\\main\\java\\com\\qa\\XLSfile\\webtabledata.xlsx");
		 
		 if(!reader.isSheetExist("TableData")) {
			 reader.addSheet("TableData");
			 	 
		 }
		 
		 reader.addColumn("TableData", "companyName");
		 reader.addColumn("TableData", "contact");
		 reader.addColumn("TableData", "country");
		
		for(int i=2;i<=rowcount;i++) {
			String actualXpath_company = beforeXpath_company+i+afterXpath_company;
			String companyName=	driver.findElement(By.xpath(actualXpath_company)).getText();
			System.out.println(companyName);
			
			
			reader.setCellData("TableData", "companyName", i, companyName);
			
			
			String actualXpath_contact = beforeXpath_contact+i+afterXpath_contact;
			String contact=	driver.findElement(By.xpath(actualXpath_contact)).getText();
			System.out.println(contact);
			
			
			reader.setCellData("TableData", "contact", i, contact);
			
			String actualXpath_country = beforeXpath_country+i+afterXpath_country;
			String country=	driver.findElement(By.xpath(actualXpath_country)).getText();
			System.out.println(country);
			
			
			reader.setCellData("TableData", "country", i, country);
						
		}
		
		driver.quit();
		
	}

}
