import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities as DesiredCapabilities
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.support.events.EventFiringWebDriver as EventFiringWebDriver

//Initial Test Case Code (Navigate to URL, get PDF file downloaded):
CustomKeywords.'com.customChromeBrowser.pdfBrowser.launchBrowser'()

WebUI.navigateToUrl('http://www.pdf995.com/samples/')

WebUI.click(findTestObject('Page_Sample PDF/pdfSampleFile'))

WebUI.delay(3)

WebUI.closeBrowser()

// Locate recently downloaded PDF:
String downloadPath = '/Users/<yourusername>/Downloads/PDFDownloads'

File dir = new File(downloadPath)

File[] dirContents = dir.listFiles()

//For Windows, change value to dirContents[0]
//For Mac, leave as is
String url = 'file://' + (dirContents[1])

println('The file name is: ' + url)

// Parse PDF:
WebUI.openBrowser(url)

EventFiringWebDriver driver = DriverFactory.getWebDriver()

def pdf = CustomKeywords.'com.pdf.reader.ReadPdfFromBrowser.PdfReaderUtil'(url, driver)

def lines = pdf.split('\\r?\\n')

int count = 0
String pdfOrderNumber = ""
for (String line : lines) {
	pdfLine = line.toString()
	println(pdfLine)
}

//For Windows, change value to dirContents[0]
//For Mac, leave as is
// If you would like to delete the file after use, please uncomment the next line:
//dirContents[1].delete();

