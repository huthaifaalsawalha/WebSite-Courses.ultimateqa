package courses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class Setup {

	WebDriver driver = new ChromeDriver();
	
	public SoftAssert myAssert = new SoftAssert();
	public static  XSSFWorkbook excelFile;
	
  
	public	static ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\huthaifa\\Desktop\\report\\") ;
	public	static ExtentReports extent= new ExtentReports();
	public ExtentTest test;


	
	@BeforeTest
	public void OpenDrive() {
		
		driver.get("https://courses.ultimateqa.com/");
		driver.manage().window().maximize();
		   extent.attachReporter(spark);
	}
	
	
	public void HighlightElement(WebElement element) throws InterruptedException  {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].setAttribute('style' , 'background: #FF5F00 !important')", element);
		Thread.sleep(1000);
		jse.executeScript("arguments[0].setAttribute('style' , 'background: none !important')", element);
		Thread.sleep(1000);
	}
	
	

	public static XSSFSheet ExcelSheet(String nameSheet) throws InvalidFormatException, IOException {
		
		File fileName = new File("C:\\Users\\huthaifa\\eclipse-workspace\\TestCourses\\dataExcel\\login.xlsx");
	     excelFile = new XSSFWorkbook(fileName);
		XSSFSheet sheetName =  excelFile.getSheet(nameSheet);
		
	     return sheetName;
		
		
		
		}
	
	
	
	
	public static void WriteExcelSheet(String nameSheet , String value) throws InvalidFormatException, IOException {
		
		  FileInputStream fileName = new FileInputStream("C:\\Users\\huthaifa\\eclipse-workspace\\TestCourses\\dataExcel\\login.xlsx");
		  XSSFWorkbook  excelFile1 = new XSSFWorkbook(fileName);
		 XSSFSheet sheetName =  excelFile1.getSheet(nameSheet);
		
		   XSSFCell cell=sheetName.getRow(2).createCell(1);
		    cell.setCellValue(value);
		    
		   FileOutputStream outputStream = new FileOutputStream("C:\\Users\\huthaifa\\eclipse-workspace\\TestCourses\\dataExcel\\login.xlsx");
		    excelFile1.write(outputStream);
		    excelFile1.close();
		
		    
		 
		
		
		}
	
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		}
	
	
	
	@AfterTest
	public void EndTest() {
		
		 extent.flush();
		driver.quit();
		
		
	}
	
}
