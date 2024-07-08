package courses;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;




public class Login extends Setup {
	
	@Test(invocationCount = 1 ,priority = 1)
	public void CheckInvaildPasswordEmail() throws InvalidFormatException, IOException, InterruptedException {
		 
	test=  extent.createTest("Invaild Password Email", "Verify Invaild Password Email");
	Random random=new Random();
	XSSFSheet sheetName =  Setup.ExcelSheet("incorrect");
	int number = random.nextInt(1,sheetName.getPhysicalNumberOfRows());
	
	WebElement locateSginIn = driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a"));
	HighlightElement(locateSginIn);
	locateSginIn.click();
	Thread.sleep(3000);
	
	WebElement locateEmail = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[1]/input"));
	WebElement locatePass = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[2]/input"));
	WebElement locateLogin = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
	
	

			 
		//	 Thread.sleep(2000);
			 HighlightElement(locateEmail);
			
			 locateEmail.sendKeys(sheetName.getRow(number).getCell(0).getStringCellValue());
			 HighlightElement(locatePass);
			 locatePass.sendKeys(sheetName.getRow(number).getCell(1).getStringCellValue());
			//System.out.print(sheetName.getRow(number).getCell(j).getStringCellValue()+" / ");
			 HighlightElement(locateLogin);
			 Thread.sleep(3000);
			 locateLogin.click();
			 Thread.sleep(10000);
			 String acualText = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[1]/ul/li")).getText();
			String expectedText= "Invalid email or password.";
		  myAssert.assertEquals(acualText, expectedText);
		  myAssert.assertAll();
		 
		 
	
		 
	 
	
	
	
	
	
	}
	
	
	
	@Test(invocationCount = 1 ,priority = 2)
	public void CheckInvaildPassword() throws InvalidFormatException, IOException, InterruptedException {
	
		test=  extent.createTest("Invaild Password ", "Verify Invaild Password ");
	Random random=new Random();
	XSSFSheet sheetName =  Setup.ExcelSheet("incorrectpass");
	int number = random.nextInt(1,sheetName.getPhysicalNumberOfRows());
	
	WebElement locateSginIn = driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a"));
	HighlightElement(locateSginIn);
	locateSginIn.click();
	Thread.sleep(3000);
	
	WebElement locateEmail = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[1]/input"));
	WebElement locatePass = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[2]/input"));
	WebElement locateLogin = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
	
	

			 
		//	 Thread.sleep(2000);
			 HighlightElement(locateEmail);
			
			 locateEmail.sendKeys(sheetName.getRow(number).getCell(0).getStringCellValue());
			 HighlightElement(locatePass);
			 locatePass.sendKeys(sheetName.getRow(number).getCell(1).getStringCellValue());
			//System.out.print(sheetName.getRow(number).getCell(j).getStringCellValue()+" / ");
			 HighlightElement(locateLogin);
			 Thread.sleep(3000);
			 locateLogin.click();
			 Thread.sleep(10000);
			 String acualText = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[1]/ul/li")).getText();
			String expectedText= "Invalid email or password.";
		  myAssert.assertEquals(acualText, expectedText);
		  myAssert.assertAll();
		 
		 
	
		 
	 
	
	
	
	
	
	}
	
	
	
	@Test(invocationCount = 1 ,priority = 3)
	public void CheckInvaildEmail() throws InvalidFormatException, IOException, InterruptedException {
	
	test=  extent.createTest("Invaild  Email", "Verify Invaild  Email");
	Random random=new Random();
	XSSFSheet sheetName =  Setup.ExcelSheet("incorrectEmail");
	int number = random.nextInt(1,sheetName.getPhysicalNumberOfRows());
	
	WebElement locateSginIn = driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a"));
	HighlightElement(locateSginIn);
	locateSginIn.click();
	Thread.sleep(10000);
	
	WebElement locateEmail = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[1]/input"));
	WebElement locatePass = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[2]/input"));
	WebElement locateLogin = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
	
	

			 
		//	 Thread.sleep(2000);
			 HighlightElement(locateEmail);
			
			 locateEmail.sendKeys(sheetName.getRow(number).getCell(0).getStringCellValue());
			 HighlightElement(locatePass);
			 locatePass.sendKeys(sheetName.getRow(number).getCell(1).getStringCellValue());
			
			 HighlightElement(locateLogin);
			 Thread.sleep(3000);
			 locateLogin.click();
			 Thread.sleep(10000);
			 String acualText = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[1]/ul/li")).getText();
			String expectedText= "Invalid email or password.";
		  myAssert.assertEquals(acualText, expectedText);
		  myAssert.assertAll();
		 

	
	}
	
	
	

	
	@Test(priority = 4)
	public void CheckVaildEmailPass() throws InvalidFormatException, IOException, InterruptedException {
		
		test=  extent.createTest("vaild Password Email", "Verify vaild Password Email");
	XSSFSheet sheetName =  Setup.ExcelSheet("correctEmailPass");

	
	WebElement locateSginIn = driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a"));
	HighlightElement(locateSginIn);
	locateSginIn.click();
	Thread.sleep(3000);
	
	WebElement locateEmail = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[1]/input"));
	WebElement locatePass = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[2]/input"));
	WebElement locateLogin = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
	
	

			 
		//	 Thread.sleep(2000);
			 HighlightElement(locateEmail);
			
			 locateEmail.sendKeys(sheetName.getRow(1).getCell(0).getStringCellValue());
			 HighlightElement(locatePass);
			 locatePass.sendKeys(sheetName.getRow(1).getCell(1).getStringCellValue());
			
			 HighlightElement(locateLogin);
			 Thread.sleep(3000);
			 locateLogin.click();
			 Thread.sleep(10000);
			
			 String acualText = driver.findElement(By.xpath("//button[normalize-space()='huthaifa a']")).getText();
			
			 String expectedText= "huthaifa a";
		  myAssert.assertEquals(acualText, expectedText);
		  myAssert.assertAll();
		 

	
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		  Random random =new Random();
		  int num = random.nextInt();
		String path="C:\\Users\\alsaw\\OneDrive\\Desktop\\New folder (5)\\test"+num+".png";
	 if(result.FAILURE==result.getStatus())
	 {
		   
			  test.fail(" Not Successfully");
			  //test.info(Status.FAIL, Status.INFO);
			  test.fail(result.getThrowable());
			  test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
				takeSnapShot(driver,path) ;
			  test.addScreenCaptureFromPath(path);
			  
	 }else if(result.SUCCESS==result.getStatus()) {
		   test.pass("Successfully");
		 
		   
		   
		   
	}else {
		
		 test.skip("Skip Test");
		 test.skip(result.getThrowable());
		
	}
	}
	
	
	
	
	
	

}
