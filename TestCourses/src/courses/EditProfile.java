package courses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class EditProfile extends Setup {

	@Test(priority = 1)
	public void CheakUpdateProfile () throws InvalidFormatException, IOException, InterruptedException {
		
		 test=  extent.createTest("Update Profile", "Verify Update Profile");
		XSSFSheet sheetName =  Setup.ExcelSheet("correctEmailPass");
        XSSFSheet sheetEditProfile = Setup.ExcelSheet("editProfile");
        Random random = new Random();
        int numberRow= random.nextInt(1,sheetEditProfile.getLastRowNum());
		
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
		 
		 WebElement locateMyAccountButton =driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li[2]/button"));
		HighlightElement(locateMyAccountButton);
		locateMyAccountButton.click();
		Thread.sleep(3000);
		
		WebElement locateMyAccount = driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li[2]/ul/li[2]/a"));
		HighlightElement(locateMyAccount);
		locateMyAccount.click();
		Thread.sleep(4000);
		
		WebElement locateUpdateEmail = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/form/div/div[2]/div[1]/input"));
		HighlightElement(locateUpdateEmail);
		locateUpdateEmail.clear();
		locateUpdateEmail.sendKeys(sheetEditProfile.getRow(numberRow).getCell(0).getStringCellValue());
		Thread.sleep(3000);
		
		
		
		WebElement locateFirstName = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/form/div/div[2]/div[2]/div[1]/input"));
		HighlightElement(locateFirstName);
		locateFirstName.clear();
		locateFirstName.sendKeys(sheetEditProfile.getRow(numberRow).getCell(1).getStringCellValue());
		Thread.sleep(3000);
		
		
		WebElement locateLastName = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/form/div/div[2]/div[2]/div[2]/input"));
		HighlightElement(locateLastName);
		locateLastName.clear();
		locateLastName.sendKeys(sheetEditProfile.getRow(numberRow).getCell(2).getStringCellValue());
		Thread.sleep(3000);
		
		
		WebElement locateCompany = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/form/div/div[2]/div[3]/input"));
		HighlightElement(locateCompany);
		locateCompany.clear();
		locateCompany.sendKeys(sheetEditProfile.getRow(numberRow).getCell(3).getStringCellValue());
		Thread.sleep(3000);
		
		
		WebElement locateProfessionalTitle = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/form/div/div[2]/div[4]/input"));
		HighlightElement(locateProfessionalTitle);
		locateProfessionalTitle.clear();
		locateProfessionalTitle.sendKeys(sheetEditProfile.getRow(numberRow).getCell(4).getStringCellValue());
		Thread.sleep(3000);
		
		
		Select timeZone= new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div/main/form/div/div[2]/div[5]/div/select")));
		HighlightElement(timeZone.getWrappedElement());
		timeZone.selectByVisibleText(sheetEditProfile.getRow(numberRow).getCell(5).getStringCellValue());
		//System.out.println(timeZone.getAllSelectedOptions());
		System.out.println(timeZone.getFirstSelectedOption().getText());
		Thread.sleep(3000);
          
		
		
		WebElement locateSaveButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/form/div/div[2]/div[6]/input"));
		HighlightElement(locateSaveButton);
		locateSaveButton.sendKeys(Keys.ENTER);
		//Thread.sleep(5000);
		
		String acualMessage= driver.findElement(By.xpath("/html/body/div[2]/div/div/div/p")).getText();
		String expectMessage = "Your profile was successfully updated.";
		System.out.println(acualMessage);
		
	   String acualEmail= driver.findElement(By.id("user[email]")).getAttribute("value");
	   String expectEmail=sheetEditProfile.getRow(numberRow).getCell(0).getStringCellValue();
	    
	   String acualfirstName= driver.findElement(By.id("user[first_name]")).getAttribute("value");
	    String expectFirstName=sheetEditProfile.getRow(numberRow).getCell(1).getStringCellValue();
	    
	  String acuallastName= driver.findElement(By.id("user[last_name]")).getAttribute("value");
	    String expectlasttName=sheetEditProfile.getRow(numberRow).getCell(2).getStringCellValue();
	    
	    String acualCompany= driver.findElement(By.xpath("/html/body/div[1]/div/div/main/form/div/div[2]/div[3]/input")).getAttribute("value");
	    String expectCompany=sheetEditProfile.getRow(numberRow).getCell(3).getStringCellValue();
	    
	    
	    String acualTitle= driver.findElement(By.xpath("/html/body/div[1]/div/div/main/form/div/div[2]/div[4]/input")).getAttribute("value");
	    String expectTitle=sheetEditProfile.getRow(numberRow).getCell(4).getStringCellValue();
	  
		Select timeZone2= new Select(driver.findElement(By.xpath("//select[contains(@id,'user')]")));
	   String acualTimeZone=timeZone2.getFirstSelectedOption().getText();
	    String expectTimeZone=sheetEditProfile.getRow(numberRow).getCell(5).getStringCellValue();
	   System.out.println( timeZone2.getFirstSelectedOption().getText());
	    
		WebElement locateMyAccountButton1 =driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li[2]/button"));
		HighlightElement(locateMyAccountButton1);
		locateMyAccountButton1.click();
		Thread.sleep(3000);
		
		WebElement locateSignOut = driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li[2]/ul/li[4]/a"));
	    HighlightElement(locateSignOut);
		locateSignOut.click();
		Thread.sleep(4000);
		
		myAssert.assertEquals(acualMessage, expectMessage);
		myAssert.assertEquals(acualEmail, expectEmail);
		myAssert.assertEquals(acualfirstName, expectFirstName);
		myAssert.assertEquals(acuallastName, expectlasttName);
		myAssert.assertEquals(acualCompany, expectCompany);
		myAssert.assertEquals(acualTitle, expectTitle);
		myAssert.assertEquals(acualTimeZone, expectTimeZone);
		
		myAssert.assertAll();
	}
	

	@Test(priority = 2)
	public void CheakUpdateImage () throws InvalidFormatException, IOException, InterruptedException {
		
		 test=  extent.createTest(" Update Image", "Verify Update Image");
		
		
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
		 
		 WebElement locateMyAccountButton =driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li[2]/button"));
		HighlightElement(locateMyAccountButton);
		locateMyAccountButton.click();
		Thread.sleep(3000);
		
		WebElement locateMyAccount = driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li[2]/ul/li[2]/a"));
		HighlightElement(locateMyAccount);
		locateMyAccount.click();
		Thread.sleep(4000);
		
		WebElement locateUploadNewImage = driver.findElement(By.xpath("//span[@class='button-upload']"));
		HighlightElement(locateUploadNewImage);
		locateUploadNewImage.click();
		Thread.sleep(4000);
		
		WebElement locateImage = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/form/div/div[1]/div/div/img"));
	     String imgSRC = locateImage.getAttribute("src");
	     System.out.println(imgSRC);
	Runtime.getRuntime().exec("C:\\Users\\huthaifa\\eclipse-workspace\\TestCourses\\dataExcel\\imagepath.exe");
		
		
	Thread.sleep(8000);
//	String expectImgSRC1 = locateImage.getAttribute("src");
//	System.out.println(expectImgSRC1);
	
	WebElement locateSaveButton = driver.findElement(By.xpath("//input[@value='Save Changes']"));
	HighlightElement(locateSaveButton);
	locateSaveButton.sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	
	String acualMessage= driver.findElement(By.xpath("//p[@class='message-text']")).getText();
	String expectMessage = "Your profile was successfully updated.";
	
	
	WebElement locateImage2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/form/div/div[1]/div/div/img"));
    String expectImgSRC = locateImage2.getAttribute("src");
	
	
	WebElement locateMyAccountButton1 =driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li[2]/button"));
	HighlightElement(locateMyAccountButton1);
	locateMyAccountButton1.click();
	Thread.sleep(3000);
	
	WebElement locateSignOut = driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li[2]/ul/li[4]/a"));
	HighlightElement(locateSignOut);
	locateSignOut.click();
	Thread.sleep(4000);
	
	myAssert.assertEquals(acualMessage, expectMessage);
    myAssert.assertNotEquals(imgSRC, expectImgSRC);
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
