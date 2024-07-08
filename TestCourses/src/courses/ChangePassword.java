package courses;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ChangePassword extends Setup {

	
	
	

	
	
	public void Login() throws InterruptedException, InvalidFormatException, IOException {
		
		XSSFSheet sheetName =  Setup.ExcelSheet("correctEmailPass");
		  
		  
		  
		
		WebElement locateSginIn = driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a"));
		HighlightElement(locateSginIn);
		locateSginIn.click();
		Thread.sleep(3000);
		
		WebElement locateEmail = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[1]/input"));
		 HighlightElement(locateEmail);	
		 locateEmail.sendKeys(sheetName.getRow(2).getCell(0).getStringCellValue());
		 Thread.sleep(2000);
		 
		WebElement locatePass = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[2]/input"));
		 HighlightElement(locatePass);
		 locatePass.sendKeys(sheetName.getRow(2).getCell(1).getStringCellValue());
		 Thread.sleep(2000);
		
		
		
		WebElement locateLogin = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
		 HighlightElement(locateLogin);
	     Thread.sleep(3000);
	     locateLogin.click();
		 Thread.sleep(10000);
		
		
	}
	
	@Test(priority = 4)
	public void CheakChangePassword() throws InvalidFormatException, IOException, InterruptedException {
	
		test=  extent.createTest("Cheak Change Password", "Verify Change Password");
		XSSFSheet sheetName =  Setup.ExcelSheet("correctEmailPass");
       Login();
	 
	 WebElement locateMyAccountButton =driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li[2]/button"));
	HighlightElement(locateMyAccountButton);
	locateMyAccountButton.click();
	Thread.sleep(3000);
	
	WebElement locateMyAccount = driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li[2]/ul/li[2]/a"));
	HighlightElement(locateMyAccount);
	locateMyAccount.click();
	Thread.sleep(4000);
	
	
	
	WebElement locateButtonChangePassword = driver.findElement(By.xpath("//a[normalize-space()='Password']"));
	HighlightElement(locateButtonChangePassword);
	locateButtonChangePassword.click();
	Thread.sleep(4000);
	
	String newPass="hh12345678";
	
	
	WebElement locateInputChangePassword = driver.findElement(By.xpath("//*[@id=\"user[password]\"]"));
	HighlightElement(locateInputChangePassword);
	locateInputChangePassword.sendKeys(newPass);
	Thread.sleep(4000);
	
	

	WebElement locateInputRetypePassword = driver.findElement(By.xpath("//div[2]//input[1]"));
	HighlightElement(locateInputRetypePassword);
	locateInputRetypePassword.sendKeys(newPass);
	Thread.sleep(4000);
	
 
	
	WebElement locateInputCurrentPassword = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/form/div[3]/input"));
	HighlightElement(locateInputCurrentPassword);
	locateInputCurrentPassword.sendKeys(sheetName.getRow(2).getCell(1).getStringCellValue());
	Thread.sleep(4000);
	
	
	WebElement locateButtonUpdate = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/form/div[4]/input"));
	HighlightElement(locateButtonUpdate);
	locateButtonUpdate.sendKeys(Keys.ENTER);
	Thread.sleep(4000);

	
	   
	    
	
	
	String acualText = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/p")).getText();
	String expictedText = "Successfully updated your password.";
	
	
	
	
	
	WebElement locateMyAccountButton1 =driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li[2]/button"));
	HighlightElement(locateMyAccountButton1);
	locateMyAccountButton1.click();
	Thread.sleep(3000);
	
	WebElement locateSignOut = driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li[2]/ul/li[4]/a"));
	HighlightElement(locateSignOut);
	locateSignOut.click();
	Thread.sleep(4000);
	
	
	


	WriteExcelSheet("correctEmailPass",newPass);
    Login();
    
	 String acualTextlogin = driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li[2]/button")).getText();	
	 String expectedTextlogin= "emad a";
	 
	
	       
	 myAssert.assertEquals(acualText, expictedText);
	 myAssert.assertEquals(acualTextlogin, expectedTextlogin);
    
	
	
	
	

	
	}	
	
	
	@Test(priority = 1)
	public void CheakChangePasswordInvaldCurrentPassword() throws InvalidFormatException, IOException, InterruptedException {
	
		 test=  extent.createTest(" Change Password Invald Current Password", "Verify Change Password Invald Current Password");
		XSSFSheet sheetName =  Setup.ExcelSheet("correctEmailPass");
       Login();
	 
	 WebElement locateMyAccountButton =driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li[2]/button"));
	HighlightElement(locateMyAccountButton);
	locateMyAccountButton.click();
	Thread.sleep(3000);
	
	WebElement locateMyAccount = driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li[2]/ul/li[2]/a"));
	HighlightElement(locateMyAccount);
	locateMyAccount.click();
	Thread.sleep(4000);
	
	
	
	WebElement locateButtonChangePassword = driver.findElement(By.xpath("//a[normalize-space()='Password']"));
	HighlightElement(locateButtonChangePassword);
	locateButtonChangePassword.click();
	Thread.sleep(4000);
	
	
	
	
	WebElement locateInputChangePassword = driver.findElement(By.xpath("//*[@id=\"user[password]\"]"));
	HighlightElement(locateInputChangePassword);
	locateInputChangePassword.sendKeys("h12345678");
	Thread.sleep(4000);
	
	

	WebElement locateInputRetypePassword = driver.findElement(By.xpath("//div[2]//input[1]"));
	HighlightElement(locateInputRetypePassword);
	locateInputRetypePassword.sendKeys("h12345678");
	Thread.sleep(4000);
	
	
	WebElement locateInputCurrentPassword = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/form/div[3]/input"));
	HighlightElement(locateInputCurrentPassword);
	locateInputCurrentPassword.sendKeys("528963471236963");
	Thread.sleep(4000);
	
	
	WebElement locateButtonUpdate = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/form/div[4]/input"));
	HighlightElement(locateButtonUpdate);
	locateButtonUpdate.sendKeys(Keys.ENTER);
	Thread.sleep(4000);
	
	
	String acualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
	String expictedText = "Current password is invalid";
	
	myAssert.assertEquals(acualText, expictedText);
	myAssert.assertAll();
	
	
	
	
	
	
	
	

	
	}	
	
	
	

	@Test(priority = 2)
	public void CheakChangePasswordNotMatchingRetypeAndChangePassword() throws InvalidFormatException, IOException, InterruptedException {
	
		 test=  extent.createTest(" Change Password Not Matching Retype And Change Password", "Verify Change Password Not Matching Retype And Change Password");
	
		XSSFSheet sheetName =  Setup.ExcelSheet("correctEmailPass");
       Login();
	 
	 WebElement locateMyAccountButton =driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li[2]/button"));
	HighlightElement(locateMyAccountButton);
	locateMyAccountButton.click();
	Thread.sleep(3000);
	
	WebElement locateMyAccount = driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li[2]/ul/li[2]/a"));
	HighlightElement(locateMyAccount);
	locateMyAccount.click();
	Thread.sleep(4000);
	
	
	
	WebElement locateButtonChangePassword = driver.findElement(By.xpath("//a[normalize-space()='Password']"));
	HighlightElement(locateButtonChangePassword);
	locateButtonChangePassword.click();
	Thread.sleep(4000);
	
	
	
	
	WebElement locateInputChangePassword = driver.findElement(By.xpath("//*[@id=\"user[password]\"]"));
	HighlightElement(locateInputChangePassword);
	locateInputChangePassword.sendKeys("h12345678");
	Thread.sleep(4000);
	
	

	WebElement locateInputRetypePassword = driver.findElement(By.xpath("//div[2]//input[1]"));
	HighlightElement(locateInputRetypePassword);
	locateInputRetypePassword.sendKeys("345678963");
	Thread.sleep(4000);
	
	
	WebElement locateInputCurrentPassword = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/form/div[3]/input"));
	HighlightElement(locateInputCurrentPassword);
	locateInputCurrentPassword.sendKeys("12345678");
	Thread.sleep(4000);
	
	
	WebElement locateButtonUpdate = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/form/div[4]/input"));
	HighlightElement(locateButtonUpdate);
	locateButtonUpdate.sendKeys(Keys.ENTER);
	Thread.sleep(4000);
	
	
	String acualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
	String expictedText = "Password confirmation doesn't match Password";
	
	myAssert.assertEquals(acualText, expictedText);
	myAssert.assertAll();
	
	
	
	
	
	
	
	

	
	}	
	
	
	
	
	
	@Test(priority = 3)
	public void CheakSecurityChangePassword() throws InvalidFormatException, IOException, InterruptedException {
	
		
		 test=  extent.createTest("Cheak Security Change Password", "Verify Cheak Security Change Password");
		XSSFSheet sheetName =  Setup.ExcelSheet("correctEmailPass");
       Login();
	 
	 WebElement locateMyAccountButton =driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li[2]/button"));
	HighlightElement(locateMyAccountButton);
	locateMyAccountButton.click();
	Thread.sleep(3000);
	
	WebElement locateMyAccount = driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li[2]/ul/li[2]/a"));
	HighlightElement(locateMyAccount);
	locateMyAccount.click();
	Thread.sleep(4000);
	
	
	
	WebElement locateButtonChangePassword = driver.findElement(By.xpath("//a[normalize-space()='Password']"));
	HighlightElement(locateButtonChangePassword);
	locateButtonChangePassword.click();
	Thread.sleep(4000);
	
	
	
	
	WebElement locateInputChangePassword = driver.findElement(By.xpath("//*[@id=\"user[password]\"]"));
	HighlightElement(locateInputChangePassword);
	locateInputChangePassword.sendKeys("5678");
	Thread.sleep(4000);
	
	

	WebElement locateInputRetypePassword = driver.findElement(By.xpath("//div[2]//input[1]"));
	HighlightElement(locateInputRetypePassword);
	locateInputRetypePassword.sendKeys("5678");
	Thread.sleep(4000);
	
	
	WebElement locateInputCurrentPassword = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/form/div[3]/input"));
	HighlightElement(locateInputCurrentPassword);
	locateInputCurrentPassword.sendKeys("12345678");
	Thread.sleep(4000);
	
	
	WebElement locateButtonUpdate = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/form/div[4]/input"));
	HighlightElement(locateButtonUpdate);
	locateButtonUpdate.sendKeys(Keys.ENTER);
	Thread.sleep(4000);
	
	
	String acualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
	String expictedText = "Password must be at least 8 characters.";
	
	myAssert.assertEquals(acualText, expictedText);
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
