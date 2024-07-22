package courses;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class SignUp extends Setup {
	
	

	@Test(priority = 8)
	public void CheckSignUp () throws InvalidFormatException, IOException, InterruptedException {
		
		test=  extent.createTest("SignUp", "Verify SignUp");
	XSSFSheet sheetName =  Setup.ExcelSheet("SignUp");
		
	driver.get("https://courses.ultimateqa.com/");
	
		WebElement locateSginIn = driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a"));
		HighlightElement(locateSginIn);
		locateSginIn.click();
		Thread.sleep(5000);
		
		WebElement locateCreateNewAccount = driver.findElement(By.xpath("/html/body/main/div/div/aside/a"));
		HighlightElement(locateCreateNewAccount);
		locateCreateNewAccount.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		
		WebElement locateFirstName = driver.findElement(By.xpath("//div[@class='sign-up__wrapper']//div[1]//div[1]//input[1]"));
		 HighlightElement(locateFirstName);	
		 locateFirstName.sendKeys(sheetName.getRow(1).getCell(0).getStringCellValue());
			Thread.sleep(3000);
		
		
			
			WebElement locateLastName = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[1]/div[2]/input"));
			 HighlightElement(locateLastName);	
			 locateLastName.sendKeys(sheetName.getRow(1).getCell(1).getStringCellValue());
				Thread.sleep(3000);
				
				WebElement locateEmail = driver.findElement(By.xpath("//input[@placeholder='Email']"));
				 HighlightElement(locateEmail);	
				 locateEmail.sendKeys(sheetName.getRow(1).getCell(2).getStringCellValue());
					Thread.sleep(3000);
		
					
					WebElement locatePass = driver.findElement(By.xpath("//div[3]//input[1]"));
					 HighlightElement(locatePass);	
					 locatePass.sendKeys(sheetName.getRow(1).getCell(3).getStringCellValue());
						Thread.sleep(3000);

						
						WebElement locateCheak = driver.findElement(By.xpath("//input[@value='1']"));
						 HighlightElement(locateCheak);	
						 locateCheak.click();
							Thread.sleep(3000);
							
							WebElement locateButton = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[6]/button"));
							 HighlightElement(locateButton);	
							 locateButton.sendKeys(Keys.ENTER);
								Thread.sleep(10000);
								
								 String acualText = driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li[2]/button")).getText();
									
								 String expectedText= "ali2 a";
							  myAssert.assertEquals(acualText, expectedText);
							  myAssert.assertAll();
						
						
		
	}
	
	



	
	@Test(priority = 2)
	public void CheckSignUpValidationLastName () throws InvalidFormatException, IOException, InterruptedException {
		
		test=  extent.createTest("SignUp Validation LastName", "Verify SignUp Validation LastName");
	XSSFSheet sheetName =  Setup.ExcelSheet("SignUp");
	
	driver.get("https://courses.ultimateqa.com/");
	Thread.sleep(5000);
		WebElement locateSginIn = driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a"));
		HighlightElement(locateSginIn);
		locateSginIn.click();
		Thread.sleep(5000);
		
		WebElement locateCreateNewAccount = driver.findElement(By.xpath("/html/body/main/div/div/aside/a"));
		HighlightElement(locateCreateNewAccount);
		locateCreateNewAccount.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		
		WebElement locateFirstName = driver.findElement(By.xpath("//div[@class='sign-up__wrapper']//div[1]//div[1]//input[1]"));
		 HighlightElement(locateFirstName);	
		 locateFirstName.sendKeys(sheetName.getRow(1).getCell(0).getStringCellValue());
			Thread.sleep(3000);
		
		
			
			//WebElement locateLastName = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[1]/div[2]/input"));
			// HighlightElement(locateLastName);	
			// locateLastName.sendKeys(sheetName.getRow(1).getCell(1).getStringCellValue());
			//	Thread.sleep(3000);
				
				WebElement locateEmail = driver.findElement(By.xpath("//input[@placeholder='Email']"));
				 HighlightElement(locateEmail);	
				 locateEmail.sendKeys(sheetName.getRow(1).getCell(2).getStringCellValue());
					Thread.sleep(3000);
		
					
					WebElement locatePass = driver.findElement(By.xpath("//div[3]//input[1]"));
					 HighlightElement(locatePass);	
					 locatePass.sendKeys(sheetName.getRow(1).getCell(3).getStringCellValue());
						Thread.sleep(3000);

						
						WebElement locateCheak = driver.findElement(By.xpath("//input[@value='1']"));
						 HighlightElement(locateCheak);	
						 locateCheak.click();
							Thread.sleep(3000);
							
							WebElement locateButton = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[6]/button"));
							 HighlightElement(locateButton);	
							 locateButton.sendKeys(Keys.ENTER);
								Thread.sleep(10000);
								
								 String acualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
									
								 String expectedText= "Last name can't be blank";
							  myAssert.assertEquals(acualText, expectedText);
							  myAssert.assertAll();
						
						
		
	}
	

	@Test(priority = 3)
	public void CheckSignUpValidationFirstName () throws InvalidFormatException, IOException, InterruptedException {
		
		test=  extent.createTest("SignUp Validation FirstName", "Verify SignUp Validation FirstName");
	XSSFSheet sheetName =  Setup.ExcelSheet("SignUp");

	
		WebElement locateSginIn = driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a"));
		HighlightElement(locateSginIn);
		locateSginIn.click();
		Thread.sleep(5000);
		
		WebElement locateCreateNewAccount = driver.findElement(By.xpath("/html/body/main/div/div/aside/a"));
		HighlightElement(locateCreateNewAccount);
		locateCreateNewAccount.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		
	//	WebElement locateFirstName = driver.findElement(By.xpath("//div[@class='sign-up__wrapper']//div[1]//div[1]//input[1]"));
		// HighlightElement(locateFirstName);	
		// locateFirstName.sendKeys(sheetName.getRow(1).getCell(0).getStringCellValue());
		//	Thread.sleep(3000);
		
		
			
			WebElement locateLastName = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[1]/div[2]/input"));
			 HighlightElement(locateLastName);	
			 locateLastName.sendKeys(sheetName.getRow(1).getCell(1).getStringCellValue());
				Thread.sleep(3000);
				
				WebElement locateEmail = driver.findElement(By.xpath("//input[@placeholder='Email']"));
				 HighlightElement(locateEmail);	
				 locateEmail.sendKeys(sheetName.getRow(1).getCell(2).getStringCellValue());
					Thread.sleep(3000);
		
					
					WebElement locatePass = driver.findElement(By.xpath("//div[3]//input[1]"));
					 HighlightElement(locatePass);	
					 locatePass.sendKeys(sheetName.getRow(1).getCell(3).getStringCellValue());
						Thread.sleep(3000);

						
						WebElement locateCheak = driver.findElement(By.xpath("//input[@value='1']"));
						 HighlightElement(locateCheak);	
						 locateCheak.click();
							Thread.sleep(3000);
							
							WebElement locateButton = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[6]/button"));
							 HighlightElement(locateButton);	
							 locateButton.sendKeys(Keys.ENTER);
								Thread.sleep(10000);
								
								 String acualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
									
								 String expectedText= "First name can't be blank";
							  myAssert.assertEquals(acualText, expectedText);
							  myAssert.assertAll();
						
						
		
	}


	@Test(priority = 4)
	public void CheckSignUpValidationEmail () throws InvalidFormatException, IOException, InterruptedException {
		
	XSSFSheet sheetName =  Setup.ExcelSheet("SignUp");
	 test=  extent.createTest("SignUp Validation Email", "Verify SignUp Validation Email");
	

	 
	 WebElement locateSginIn = driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a"));
		HighlightElement(locateSginIn);
		locateSginIn.click();
		Thread.sleep(5000);
		
		WebElement locateCreateNewAccount = driver.findElement(By.xpath("/html/body/main/div/div/aside/a"));
		HighlightElement(locateCreateNewAccount);
		locateCreateNewAccount.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		
		WebElement locateFirstName = driver.findElement(By.xpath("//div[@class='sign-up__wrapper']//div[1]//div[1]//input[1]"));
		 HighlightElement(locateFirstName);	
	       locateFirstName.sendKeys(sheetName.getRow(1).getCell(0).getStringCellValue());
			Thread.sleep(3000);
		
		
			
			WebElement locateLastName = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[1]/div[2]/input"));
			 HighlightElement(locateLastName);	
			 locateLastName.sendKeys(sheetName.getRow(1).getCell(1).getStringCellValue());
				Thread.sleep(3000);
				
			//	WebElement locateEmail = driver.findElement(By.xpath("//input[@placeholder='Email']"));
				// HighlightElement(locateEmail);	
				// locateEmail.sendKeys(sheetName.getRow(1).getCell(2).getStringCellValue());
				//	Thread.sleep(3000);
		
					
					WebElement locatePass = driver.findElement(By.xpath("//div[3]//input[1]"));
					 HighlightElement(locatePass);	
					 locatePass.sendKeys(sheetName.getRow(1).getCell(3).getStringCellValue());
						Thread.sleep(3000);

						
						WebElement locateCheak = driver.findElement(By.xpath("//input[@value='1']"));
						 HighlightElement(locateCheak);	
						 locateCheak.click();
							Thread.sleep(3000);
							
							WebElement locateButton = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[6]/button"));
							 HighlightElement(locateButton);	
							 locateButton.sendKeys(Keys.ENTER);
								Thread.sleep(10000);
								
								 String acualText = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[1]/ul/li")).getText();
									
								 String expectedText= "Email can't be blank";
							  myAssert.assertEquals(acualText, expectedText);
							  myAssert.assertAll();
						
						
		
	}
	

	
	@Test(priority = 5)
	public void CheckSignUpValidationPassword () throws InvalidFormatException, IOException, InterruptedException {
		
		 test=  extent.createTest("SignUp Validation Password", "Verify SignUp Validation Password");
	XSSFSheet sheetName =  Setup.ExcelSheet("SignUp");
		

	
		WebElement locateSginIn = driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a"));
		HighlightElement(locateSginIn);
		locateSginIn.click();
		Thread.sleep(5000);
		
		WebElement locateCreateNewAccount = driver.findElement(By.xpath("/html/body/main/div/div/aside/a"));
		HighlightElement(locateCreateNewAccount);
		locateCreateNewAccount.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		
		WebElement locateFirstName = driver.findElement(By.xpath("//div[@class='sign-up__wrapper']//div[1]//div[1]//input[1]"));
		 HighlightElement(locateFirstName);	
	       locateFirstName.sendKeys(sheetName.getRow(1).getCell(0).getStringCellValue());
			Thread.sleep(3000);
		
		
			
			WebElement locateLastName = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[1]/div[2]/input"));
			 HighlightElement(locateLastName);	
			 locateLastName.sendKeys(sheetName.getRow(1).getCell(1).getStringCellValue());
				Thread.sleep(3000);
				
				WebElement locateEmail = driver.findElement(By.xpath("//input[@placeholder='Email']"));
				 HighlightElement(locateEmail);	
				 locateEmail.sendKeys(sheetName.getRow(1).getCell(2).getStringCellValue());
					Thread.sleep(3000);
		
					
				//	WebElement locatePass = driver.findElement(By.xpath("//div[3]//input[1]"));
					// HighlightElement(locatePass);	
					// locatePass.sendKeys(sheetName.getRow(1).getCell(3).getStringCellValue());
					//	Thread.sleep(3000);

						
						WebElement locateCheak = driver.findElement(By.xpath("//input[@value='1']"));
						 HighlightElement(locateCheak);	
						 locateCheak.click();
							Thread.sleep(3000);
							
							WebElement locateButton = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[6]/button"));
							 HighlightElement(locateButton);	
							 locateButton.sendKeys(Keys.ENTER);
								Thread.sleep(10000);
								
								 String acualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
									
								 String expectedText= "Password can't be blank";
							  myAssert.assertEquals(acualText, expectedText);
							  myAssert.assertAll();
						
						
		
	}

	
	@Test(priority = 6)
	public void CheckSignUpValidationReadAndAgree () throws InvalidFormatException, IOException, InterruptedException {
		 test=  extent.createTest("SignUp Validation Read And Agree", "Verify SignUp Validation Read And Agree");
	XSSFSheet sheetName =  Setup.ExcelSheet("SignUp");
		

	
		WebElement locateSginIn = driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a"));
		HighlightElement(locateSginIn);
		locateSginIn.click();
		Thread.sleep(5000);
		
		WebElement locateCreateNewAccount = driver.findElement(By.xpath("/html/body/main/div/div/aside/a"));
		HighlightElement(locateCreateNewAccount);
		locateCreateNewAccount.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		
		WebElement locateFirstName = driver.findElement(By.xpath("//div[@class='sign-up__wrapper']//div[1]//div[1]//input[1]"));
		 HighlightElement(locateFirstName);	
	       locateFirstName.sendKeys(sheetName.getRow(1).getCell(0).getStringCellValue());
			Thread.sleep(3000);
		
		
			
			WebElement locateLastName = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[1]/div[2]/input"));
			 HighlightElement(locateLastName);	
			 locateLastName.sendKeys(sheetName.getRow(1).getCell(1).getStringCellValue());
				Thread.sleep(3000);
				
				WebElement locateEmail = driver.findElement(By.xpath("//input[@placeholder='Email']"));
				 HighlightElement(locateEmail);	
				 locateEmail.sendKeys(sheetName.getRow(1).getCell(2).getStringCellValue());
					Thread.sleep(3000);
		
					
					WebElement locatePass = driver.findElement(By.xpath("//div[3]//input[1]"));
					 HighlightElement(locatePass);	
					 locatePass.sendKeys(sheetName.getRow(1).getCell(3).getStringCellValue());
						Thread.sleep(3000);

						
						//WebElement locateCheak = driver.findElement(By.xpath("//input[@value='1']"));
					//	 HighlightElement(locateCheak);	
						// locateCheak.click();
						//	Thread.sleep(3000);
							
							WebElement locateButton = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[6]/button"));
							 HighlightElement(locateButton);	
							 locateButton.sendKeys(Keys.ENTER);
								Thread.sleep(10000);
								
								 String acualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
									
								 String expectedText= "Terms must be accepted";
							  myAssert.assertEquals(acualText, expectedText);
							  myAssert.assertAll();
						
						
		
	}
	
	
	
	@Test(priority = 7)
	public void CheckSignUpValidationPasswordleast_8_Characters () throws InvalidFormatException, IOException, InterruptedException {
		
		 test=  extent.createTest("SignUp Validation Passwordleast_8_Characters", "Verify SignUp Validation Passwordleast_8_Characters");
	XSSFSheet sheetName =  Setup.ExcelSheet("SignUp");
		

	
		WebElement locateSginIn = driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a"));
		HighlightElement(locateSginIn);
		locateSginIn.click();
		Thread.sleep(5000);
		
		WebElement locateCreateNewAccount = driver.findElement(By.xpath("/html/body/main/div/div/aside/a"));
		HighlightElement(locateCreateNewAccount);
		locateCreateNewAccount.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		
		WebElement locateFirstName = driver.findElement(By.xpath("//div[@class='sign-up__wrapper']//div[1]//div[1]//input[1]"));
		 HighlightElement(locateFirstName);	
	       locateFirstName.sendKeys(sheetName.getRow(1).getCell(0).getStringCellValue());
			Thread.sleep(3000);
		
		
			
			WebElement locateLastName = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[1]/div[2]/input"));
			 HighlightElement(locateLastName);	
			 locateLastName.sendKeys(sheetName.getRow(1).getCell(1).getStringCellValue());
				Thread.sleep(3000);
				
				WebElement locateEmail = driver.findElement(By.xpath("//input[@placeholder='Email']"));
				 HighlightElement(locateEmail);	
				 locateEmail.sendKeys(sheetName.getRow(1).getCell(2).getStringCellValue());
					Thread.sleep(3000);
		
					
					WebElement locatePass = driver.findElement(By.xpath("//div[3]//input[1]"));
					 HighlightElement(locatePass);	
					 locatePass.sendKeys("hhh");
						Thread.sleep(3000);

						
						WebElement locateCheak = driver.findElement(By.xpath("//input[@value='1']"));
						 HighlightElement(locateCheak);	
						 locateCheak.click();
							Thread.sleep(3000);
							
							WebElement locateButton = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[6]/button"));
							 HighlightElement(locateButton);	
							 locateButton.sendKeys(Keys.ENTER);
								Thread.sleep(10000);
								
								 String acualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
									
								 String expectedText= "Password must be at least 8 characters.";
							  myAssert.assertEquals(acualText, expectedText);
							  myAssert.assertAll();
						
						
		
	}
	
	
	@Test(priority = 1)
	public void CheckSignUpValidationEmailReady () throws InvalidFormatException, IOException, InterruptedException {
		
		 test=  extent.createTest("SignUp Validation Email Ready", "Verify SignUp Validation Email Ready");
	XSSFSheet sheetName =  Setup.ExcelSheet("SignUp");
		

	
		WebElement locateSginIn = driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a"));
		HighlightElement(locateSginIn);
		locateSginIn.click();
		Thread.sleep(5000);
		
		WebElement locateCreateNewAccount = driver.findElement(By.xpath("/html/body/main/div/div/aside/a"));
		HighlightElement(locateCreateNewAccount);
		locateCreateNewAccount.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		
		WebElement locateFirstName = driver.findElement(By.xpath("//div[@class='sign-up__wrapper']//div[1]//div[1]//input[1]"));
		 HighlightElement(locateFirstName);	
	       locateFirstName.sendKeys(sheetName.getRow(1).getCell(0).getStringCellValue());
			Thread.sleep(3000);
		
		
			
			WebElement locateLastName = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[1]/div[2]/input"));
			 HighlightElement(locateLastName);	
			 locateLastName.sendKeys(sheetName.getRow(1).getCell(1).getStringCellValue());
				Thread.sleep(3000);
				
				WebElement locateEmail = driver.findElement(By.xpath("//input[@placeholder='Email']"));
				 HighlightElement(locateEmail);	
				 locateEmail.sendKeys(sheetName.getRow(2).getCell(2).getStringCellValue());
					Thread.sleep(3000);
		
					
					WebElement locatePass = driver.findElement(By.xpath("//div[3]//input[1]"));
					 HighlightElement(locatePass);	
					 locatePass.sendKeys("123456789");
						Thread.sleep(3000);

						
						WebElement locateCheak = driver.findElement(By.xpath("//input[@value='1']"));
						 HighlightElement(locateCheak);	
						 locateCheak.click();
							Thread.sleep(3000);
							
							WebElement locateButton = driver.findElement(By.xpath("/html/body/main/div/div/article/form/div[6]/button"));
							 HighlightElement(locateButton);	
							 locateButton.sendKeys(Keys.ENTER);
								Thread.sleep(10000);
								
								 String acualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
									
								 String expectedText= "The username and/or password entered are incorrect, please try again.";
							  myAssert.assertEquals(acualText, expectedText);
							  myAssert.assertAll();
						
						
		
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		  Random random =new Random();
		  int num = random.nextInt();
		String path="‪C:\\Users\\huthaifa\\Desktop\\report"+num+".png";
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
