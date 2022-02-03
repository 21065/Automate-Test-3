import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Prj3 {
	
	public static ChromeDriver driver = null;
	String CSV_PATH = "C:/TestDataP2.csv";
	 private CSVReader csvReader;
	 String[] csvCell;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		 System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		 driver = new ChromeDriver();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
        driver.close();
        driver.quit();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void LaunchBrowserTets()
	{
		System.out.println("Welcome to Prject #3");
		
		driver.get("http://localhost/index.php");
		String expectedUrl = "http://localhost/index.php";
		assertEquals("http://localhost/index.php", expectedUrl);	
		
	}
	
	@Test
	void AddNewEntryLinkTest() throws Exception
	{
		String baseURL = ("http://localhost/index.php");
	
		driver.get(baseURL);
		WebElement newEntryLink = driver.findElement(By.partialLinkText("New Entry"));
		newEntryLink.click();
		
	}
	 
	 @Test
	    public void dataRead_CSV() throws IOException, CsvValidationException {
	        //Create an object of CSVReader
	        csvReader = new CSVReader(new FileReader(CSV_PATH));
	        driver.get("http://localhost/newEntry.php"); 
	 
	        //You can use while loop like below, It will be executed until the last line in CSV used. 
	        while ((csvCell = csvReader.readNext()) != null) {
	        	
	        	String entryType = csvCell[0];
	            String firstName = csvCell[1];
	            String lastName = csvCell[2];
	            String BusinessName = csvCell[3];
	            String Address = csvCell[4];
	            String Address2 = csvCell[5];
	            String Address3 = csvCell[6];
	            String city = csvCell[7];
	            String province = csvCell[8];
	            String country = csvCell[9];
	            String postalCode = csvCell[10];
	            String Email1 = csvCell[11];
	            String Email2 = csvCell[12];
	            String Email3 = csvCell[13];
	            String phoneType1 = csvCell[14];
	            String phoneNumber1 = csvCell[15];
	            String phoneType2 = csvCell[16];
	            String phoneNumber2 = csvCell[17];
	            String phoneType3 = csvCell[18];
	            String phoneNumber3 = csvCell[19];
	            String webSite1 = csvCell[20];
	            String webSite2 = csvCell[21];
	            String webSite3 = csvCell[22];
	            
	            driver.findElement(By.name("addr_type")).sendKeys(entryType);
	            driver.findElement(By.name("addr_first_name")).sendKeys(firstName);
	            driver.findElement(By.name("addr_last_name")).sendKeys(lastName);
	            driver.findElement(By.name("addr_business")).sendKeys(BusinessName);
	            driver.findElement(By.name("addr_addr_line_1")).sendKeys(Address);
	            driver.findElement(By.name("addr_addr_line_2")).sendKeys(Address2);
	            driver.findElement(By.name("addr_addr_line_3")).sendKeys(Address3);
	            driver.findElement(By.name("addr_city")).sendKeys(city);
	            driver.findElement(By.name("addr_region")).sendKeys(province);
	            driver.findElement(By.name("addr_country")).sendKeys(country);
	            driver.findElement(By.name("addr_post_code")).sendKeys(postalCode);
	            driver.findElement(By.name("addr_email_1")).sendKeys(Email1);
	            driver.findElement(By.name("addr_email_2")).sendKeys(Email2);
	            driver.findElement(By.name("addr_email_3")).sendKeys(Email3);
	            driver.findElement(By.name("addr_phone_1_type")).sendKeys(phoneType1);
	            driver.findElement(By.name("addr_phone_1")).clear();
	            driver.findElement(By.name("addr_phone_1")).sendKeys(phoneNumber1);
	            driver.findElement(By.name("addr_phone_2_type")).sendKeys(phoneType2);
	            driver.findElement(By.name("addr_phone_2")).sendKeys(phoneNumber2);
	            driver.findElement(By.name("addr_phone_3_type")).sendKeys(phoneType3);
	            driver.findElement(By.name("addr_phone_3")).sendKeys(phoneNumber3);
	            driver.findElement(By.name("addr_web_url_1")).sendKeys(webSite1);
	            driver.findElement(By.name("addr_web_url_2")).sendKeys(webSite2);
	            driver.findElement(By.name("addr_web_url_3")).sendKeys(webSite3);
	            
	            
	            driver.findElement(By.name("submit_button")).click();
	            driver.findElement(By.xpath("//input[@value='Continue']")).click();
	            driver.get("http://localhost/index.php"); 
	            driver.findElement(By.partialLinkText("New Entry")).click();
	            
	           
	            
	        }
	    }
	
	

}
