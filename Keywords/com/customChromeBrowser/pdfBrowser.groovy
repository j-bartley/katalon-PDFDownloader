package com.customChromeBrowser

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory

public class pdfBrowser {
	@Keyword
	def launchBrowser() {
		// ARGS
		//RunConfiguration.setWebDriverPreferencesProperty('args', ['--no-sandbox', '--disable-dev-shm-usage'])

		// PREFS
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory","/Users/jordanbartley/Downloads/PDFDownloads");
		prefs.put('download.directory_upgrade',true);
		prefs.put('download.prompt_for_download',false);
		prefs.put('plugins.always_open_pdf_externally',true);
		prefs.put('profile.default_content_settings.popups','0');
		prefs.put('profile.content_settings.exceptions.automatic_downloads.*.setting','1');

		// Set PREFS Options
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);

		// ADDITIONAL SETTINGS
		//RunConfiguration.setWebDriverPreferencesProperty('useAutomationExtension', ['false'])

		// Previous way of setting PREFS
		//Map caps = RunConfiguration.getDriverPreferencesProperties()

		// Set Desired Capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability('goog:chromeOptions', options);

		// Locate ChromeDriver (Note this must be manually updated)
		System.setProperty("webdriver.chrome.driver", "/Applications/Katalon Studio 9.3.1.app/Contents/Eclipse/configuration/resources/drivers/chromedriver_mac/chromedriver");

		// Create and Start Custom Chrome Driver with desired capabilities
		ChromeDriver driver = new ChromeDriver(capabilities);
		DriverFactory.changeWebDriver(driver)
	}
}
