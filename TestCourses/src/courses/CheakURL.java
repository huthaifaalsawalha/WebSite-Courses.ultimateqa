package courses;

import java.util.Random;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class CheakURL extends Setup{
	
	
	@Test()
	public void CheakNavegateURL() throws InterruptedException {
		
		 test=  extent.createTest("Cheak Navegate URL", "Verify Navegate URL");
		Thread.sleep(5000);
		String acualURL = driver.getCurrentUrl();
		
		String expectURL="https://courses.ultimateqa.com/";
		myAssert.assertEquals(acualURL, expectURL);
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
