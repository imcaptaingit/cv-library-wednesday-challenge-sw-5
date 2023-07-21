package uk.co.library.testsuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;
import uk.co.library.customlisteners.CustomListeners;
import uk.co.library.pages.HomePage;
import uk.co.library.pages.ResultPage;
import uk.co.library.testbase.BaseTest;

/**
 * Created by Jay Vaghani
 */
@Listeners(CustomListeners.class)
public class JobSearchTest extends BaseTest {
    HomePage homePage;
    ResultPage resultPage;

    @BeforeMethod
//    public void switchToIframe(){
//        driver.switchTo().frame("gdpr-consent-notice");
//        clickOnElement(By.xpath("//iframe[@id='gdpr-consent-notice']"));
//        driver.switchTo().defaultContent();
//    }

    public void inIt() {
        homePage = new HomePage();
        resultPage = new ResultPage();
    }


    @Test(dataProvider = "Job Search", dataProviderClass = TestData.class)
    public void verifyJobSearchResultUsingDifferentDataSet(String jobTitle, String location, String distance, String salaryMin, String salaryMax, String salaryType, String jobType,
                                                           String result) throws InterruptedException {
//        homePage.acceptingTheCookies();
        homePage.acceptIFrameAlert();
        Thread.sleep(2000);
        homePage.enterJobTitle(jobTitle);
        Thread.sleep(1000);
        homePage.enterTheLocation(location);
        Thread.sleep(1000);
        homePage.selectTheDistance(distance);
        Thread.sleep(1000);
        homePage.clickOnTheSearchOptionLink();
        Thread.sleep(1000);
        homePage.enterTheMinimumSalary(salaryMin);
        Thread.sleep(1000);
        homePage.enterTheMaximumSalary(salaryMax);
        Thread.sleep(1000);
        homePage.salaryTypeSelect(salaryType);
        Thread.sleep(1000);
        homePage.jobTypeSelect(jobType);
        Thread.sleep(1000);
        homePage.clickOnTheFindBtn();
        Thread.sleep(1000);
        resultPage.verifyTheResults(result);
    }



}
