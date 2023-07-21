package uk.co.library.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import uk.co.library.customlisteners.CustomListeners;
import uk.co.library.utility.Utility;

public class HomePage extends Utility {

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "gdpr-consent-notice")
    WebElement getInToIFrame;
    @CacheLookup
    @FindBy(xpath = "//button[@id='save']")
    WebElement acceptAllBtn;

    @CacheLookup
    @FindBy(id = "keywords")
    WebElement jobTitle;

    @CacheLookup
    @FindBy(id = "location")
    WebElement location;

    @CacheLookup
    @FindBy(id = "distance")
    WebElement distanceDropDown;

    @CacheLookup
    @FindBy(id = "toggle-hp-search")
    WebElement searchOptionLink;

    @CacheLookup
    @FindBy(id = "salarymin")
    WebElement salaryMin;

    @CacheLookup
    @FindBy(id = "salarymax")
    WebElement salaryMax;

    @CacheLookup
    @FindBy(id = "salarytype")
    WebElement salaryTypeDrop;

    @CacheLookup
    @FindBy(id = "tempperm")
    WebElement jobTypeDrop;

    @CacheLookup
    @FindBy(id = "hp-search-btn")
    WebElement findJobsBtn;
    @CacheLookup
    @FindBy(xpath = "//span[@class='mat-button-wrapper']//span[text()='Accept All']")
    WebElement acceptCookies;

    public void enterJobTitle(String enterJobTitle) {
        sendTextToElement(jobTitle, enterJobTitle);
        CustomListeners.test.log(Status.PASS, "Enter the Job Title" + jobTitle);
    }

    public void enterTheLocation(String enterJobLocation) {
        sendTextToElement(location,enterJobLocation);
        CustomListeners.test.log(Status.PASS, "Enter the Job Location" + location);
    }

    public void selectTheDistance(String distance) {
        selectByVisibleTextFromDropDown(distanceDropDown, distance);
        CustomListeners.test.log(Status.PASS,"Enter the location"+ distanceDropDown);

    }

    public void clickOnTheSearchOptionLink() {
        clickOnElement(searchOptionLink);
    }

    public void enterTheMinimumSalary(String salaryMinimum) {
        sendTextToElement(salaryMin,salaryMinimum);
    }

    public void enterTheMaximumSalary(String salaryMaximum) {
        sendTextToElement(salaryMax, salaryMaximum);

    }

    public void salaryTypeSelect(String select) {
        selectByVisibleTextFromDropDown(salaryTypeDrop, select);
    }

    public void jobTypeSelect(String selectJobType) {
        selectByVisibleTextFromDropDown(jobTypeDrop, selectJobType);
    }

    public void clickOnTheFindBtn() {
        clickOnElement(findJobsBtn);
    }


    ResultPage resultPage = new ResultPage();

    public void jobSearch (String jobTitle, String location, String distance, String salaryMin, String salaryMax, String salaryType, String jobType, String result) {

        Reporter.log("Job Search Results");
        enterJobTitle(jobTitle);
        enterTheLocation(location);
        selectTheDistance(distance);
        clickOnTheSearchOptionLink();
        enterTheMinimumSalary(salaryMin);
        enterTheMaximumSalary(salaryMax);
        salaryTypeSelect(salaryType);
        jobTypeSelect(jobType);
        clickOnTheFindBtn();
    }

    public void acceptIFrameAlert() throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().frame(getInToIFrame);
        clickOnElement(acceptAllBtn);
        driver.switchTo().defaultContent();
        //log.info("Accepting cookies: " + acceptAllBtn.toString());
    }

}
