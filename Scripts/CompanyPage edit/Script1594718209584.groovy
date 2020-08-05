import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.SelectorMethod as SelectorMethod
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//String company = "361 Degrees"
String company = 'Abbvie'

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://editor.qa.creditsights.com/workspace/login.qsp')

WebUI.setText(findTestObject('Page_Quark Publishing Platform Web Client/input_User Name_userName'), 'PublisherQA', FailureHandling.STOP_ON_FAILURE)

WebUI.setEncryptedText(findTestObject('Page_Quark Publishing Platform Web Client/input_Password_Password'), '78qjfIw6l1RHr02AibSyVQ==', 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Quark Publishing Platform Web Client/button_Log On'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Quark Publishing Platform Web Client/span_Company Page'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

TestObject companyRowObject = findTestObject('Object Repository/Page_Quark Publishing Platform Web Client/div_Progroupxml')

println(companyRowObject.getSelectorCollection())

println(companyRowObject.getSelectorCollection().keySet())

String path = companyRowObject.getSelectorCollection().get(SelectorMethod.XPATH)

companyRowObject.setSelectorValue(SelectorMethod.XPATH, String.format(path, company))

println(companyRowObject.getSelectorCollection().get(SelectorMethod.XPATH))

WebUI.setText(findTestObject('Object Repository/Page_Quark Publishing Platform Web Client/input_Your session will expire inseconds()_quickSearch_tb'), 
    company)

WebUI.sendKeys(findTestObject('Object Repository/Page_Quark Publishing Platform Web Client/input_Your session will expire inseconds()_quickSearch_tb'), 
    Keys.chord(Keys.ENTER))

WebUI.waitForElementClickable(companyRowObject, 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.rightClick(companyRowObject)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Quark Publishing Platform Web Client/span_Check Out'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_Quark Publishing Platform Web Client/span_Check Out'))

WebUI.switchToWindowTitle(company + '.xml')

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Progroupxml/span_ add Relative Value'), 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Progroupxml/span_ add Relative Value'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Progroupxml/a_Yes'))

WebUI.click(findTestObject('Object Repository/Page_Progroupxml/div_'))

WebUI.setText(findTestObject('Object Repository/Page_Progroupxml/div_Company Page Progroup Authoring (Author_44faee_1_2_3'), 
    'This is testing')

