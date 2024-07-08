package courses;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ForgotPassword extends Setup {

	
	
	
	@Test()
	public void CheackForgetPassword() throws InterruptedException, InvalidFormatException, IOException {
		
		XSSFSheet sheetName =  Setup.ExcelSheet("correctEmailPass");
		
		 test=  extent.createTest("Forget Password", "Verify Forget Password");
		
		WebElement locateSginIn = driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a"));
		HighlightElement(locateSginIn);
		locateSginIn.click();
		Thread.sleep(3000);
		
		WebElement locateEmail = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[1]/input"));
		
		 HighlightElement(locateEmail);
			
		 locateEmail.sendKeys(sheetName.getRow(1).getCell(0).getStringCellValue());
		
			WebElement locateForgetPass = driver.findElement(By.xpath("//a[normalize-space()='Forgot Password?']"));
		    HighlightElement(locateForgetPass);
		    locateForgetPass.click();
		    Thread.sleep(5000);
		    
		    WebElement locateEmailSent = driver.findElement(By.xpath("//input[contains(@id,'user')]"));
		    HighlightElement(locateEmailSent);
		    locateEmailSent.sendKeys("testalsawalha93@gmail.com");
		    
		    WebElement locateSubmit = driver.findElement(By.xpath("/html/body/main/div/div/div/form/div[2]/input"));
		     HighlightElement(locateSubmit);
		     locateSubmit.click();
		     Thread.sleep(5000);
		    driver.get("https://mail.google.com/mail/u/0/#inbox");
		    Thread.sleep(5000);
		
		    WebElement locateTestEmail = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/c-wiz/div/div[2]/div/div/div[1]/form/span/section/div/div/div[1]/div/div[1]/div/div[1]/input"));
		
		    HighlightElement(locateTestEmail);
		    locateTestEmail.sendKeys("testalsawalha93");
		    Thread.sleep(10000);
		    
		    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/c-wiz/div/div[3]/div/div[1]/div/div/button")).click();
		    Thread.sleep(10000);
		    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/c-wiz/div/div[2]/div/div/div/form/span/section[2]/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input")).sendKeys("h12345678*");
		    Thread.sleep(4000);
		    
		    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/c-wiz/div/div[3]/div/div[1]/div/div/button")).click();
		    Thread.sleep(10000);
	
	     driver.findElement(By.xpath("/html/body/div[8]/div[3]/div/div[2]/div[4]/div/div/div/div[2]/div/div[1]/div/div[1]/div[9]/div[1]/div[1]/div/div[1]/div[2]/div/table/tbody/tr[1]")).click();
	
	     Thread.sleep(10000);
	   //  driver.findElement(By.xpath("//*[@id=\":8w\"]/div[1]/div[2]/div[2]/div[1]/table/tbody/tr[1]/td/table/tbody/tr[2]/td/p[4]/strong/a")).click();
	     //Thread.sleep(10000);
	     driver.get("https://courses.ultimateqa.com/users/password/edit?email=alsawalhahothaifa%40gmail.com&reset_password_token=6fNnnuw6SNFM5bmeKm5b");
	     
	     Thread.sleep(10000);
	     WebElement locateNewPass = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[1]/input"));
	     HighlightElement(locateNewPass);
	     locateNewPass.sendKeys("h12345678");
	     Thread.sleep(5000);
	     WebElement locateConfPass = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[2]/input"));
	     HighlightElement(locateConfPass);
	     locateConfPass.sendKeys("h12345678");
	     
	     Thread.sleep(5000);
	     
	     WebElement locateButtonChangPass = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[3]/input"));
	     HighlightElement(locateButtonChangPass);
	     locateButtonChangPass.click();
	     Thread.sleep(10000);
	     
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
