package selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WebElementsActions {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private static final String EXPLICIT_WAIT = PropertyLoader.loadProperty("selenium.explicit.timeout");

    private WebDriver driver;
    private WebDriverWait waitForElement;

    public WebElementsActions(WebDriver driver) {
        this.driver = driver;
        waitForElement = new WebDriverWait(driver, Long.parseLong(EXPLICIT_WAIT));
    }


    public WebElement getElement(String elementLocator) {
        return driver.findElement(UIMappingSingleton.ui(elementLocator));
    }

    public List<WebElement> getElements(String elementsLocator) {
        return driver.findElements(UIMappingSingleton.ui(elementsLocator));
    }

    public String getElementText(String elementsLocator) {
        return driver.findElement(UIMappingSingleton.ui(elementsLocator)).getText();
    }

    /**
     * Click a button
     */
    public void clickButton(String buttonLocator) {
        driver.findElement(UIMappingSingleton.ui(buttonLocator)).click();
        log.info("Click on button " + buttonLocator);
    }

    /**
     * Insert value into text input HTML field
     */
    public void input(String inputLocator, String inputData) {
        driver.findElement(UIMappingSingleton.ui(inputLocator)).clear();
        driver.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(inputData);
        log.info("Input in " + inputLocator + ", value - " + inputData);
    }

    /**
     * Insert value into text input HTML field without Clean
     */
    public void inputWithoutClean(String inputLocator, String inputData) {
        driver.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(inputData);
        log.info("Input in " + inputLocator + ", value - " + inputData);
    }

    /**
     * Insert value into text input HTML field and Click ENTER for Field which used "Value" in the xpath expression
     */
    public void inputAndClickEnter(String inputLocator, String inputData) {
        driver.findElement(UIMappingSingleton.ui(inputLocator)).clear();
        driver.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(inputData);
        driver.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(Keys.ENTER);
    }

    /**
     * Select value from drop down list
     */
    public void selectFromList(String listLocator, String listValue) {
        new Select(driver.findElement(UIMappingSingleton.ui(listLocator))).selectByValue(listValue);
    }

    /**
     * Select/deselect the checkbox, the second parameter should be "Y" or "N"
     */
    public void selectCheckbox(String checkboxLocator, String isSet) {
        if (driver.findElement(UIMappingSingleton.ui(checkboxLocator)).isSelected() & isSet.equals("N")) {
            driver.findElement(UIMappingSingleton.ui(checkboxLocator)).click();
        }
        if (!driver.findElement(UIMappingSingleton.ui(checkboxLocator)).isSelected() & isSet.equals("Y")) {
            driver.findElement(UIMappingSingleton.ui(checkboxLocator)).click();
        }
    }

    /**
     * Click link
     */
    public void clickLink(String linkLocator) {
        driver.findElement(UIMappingSingleton.ui(linkLocator)).click();
        log.info("Click on link - " + linkLocator);
    }

    /**
     * Method is used to check that element is present on page.
     */
    public boolean isElementPresent(String elementLocator) {
        List<WebElement> list = driver.findElements(UIMappingSingleton.ui(elementLocator));

        if (list.size() == 0) {
            log.warn("Element _" + elementLocator + "_is NOT Present!");
            return false;
        } else {
            log.info("Element _" + elementLocator + "_ is Present");
            return list.get(0).isDisplayed();
        }
    }

    public boolean isAllElementsPresent(String elementLocator) {
        List<WebElement> list = new ArrayList<>(
                driver.findElements(UIMappingSingleton.ui(elementLocator)));

        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).isDisplayed()) {
                log.warn("Element _" + list.get(i) + "_; element (" + i + ") _is NOT Present!");
                return false;
            }
        }

        log.info("Total quantity of " + elementLocator + " - " + list.size());
        return true;
    }

    /**
     * Wait the text in the element value specified time
     */
    public void waitTextPresent(WebElement elementLocator, String text) {
        log.info("*Start TO* Wait For Element _" + elementLocator + "_ Present");
        waitForElement.until(ExpectedConditions
                .textToBePresentInElement(elementLocator, text));
    }

    /**
     * Wait the text in the element (value tag!) specified time
     */
    public void waitTextPresentInElementValue(String elementLocator, int timeoutInS, String text) {
        log.info("*Start TO* Wait For Text Present In Element _" + elementLocator + "_ Value");

        new WebDriverWait(driver, timeoutInS).until(ExpectedConditions
                .textToBePresentInElementValue(
                        UIMappingSingleton.ui(elementLocator), text));
    }

    /**
     * An expectation for checking that an element is present on the DOM of a page and visible.
     * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
     * Advantages of this method over isElementPresent(By elementLocator); is that it expects the appearance of an element.
     */
    public void waitForElementPresent(String elementLocator) {
        log.info("*Start TO* Wait For Element _" + elementLocator + "_ Present");
        waitForElement.until(ExpectedConditions
                .visibilityOfElementLocated(UIMappingSingleton.ui(elementLocator)));
    }

    public void waitForElementDisappear(String elementLocator) {
        log.info("*Start TO* Wait For Element _" + elementLocator + "_ Present");
        waitForElement.until(ExpectedConditions
                .not(ExpectedConditions.visibilityOfElementLocated(
                        UIMappingSingleton.ui(elementLocator))));
    }

    /**
     * An expectation for checking that an element is present on the DOM of a
     * page. This does not necessarily mean that the element is visible.
     *
     * @param elementLocator used to find the element
     */
    public void waitForPresenceOfElementLocated(String elementLocator) {
        log.info("*Start TO* Wait For Presence Of Element Located _" + elementLocator + "_");
        waitForElement.until(ExpectedConditions
                .presenceOfElementLocated(UIMappingSingleton.ui(elementLocator)));
    }

    /**
     * An expectation for checking an element is visible and enabled such that you
     * can click it.
     *
     * @param elementLocator used to find the element
     */
    public void waitForElementToBeClickable(String elementLocator) {
        log.info("*Start TO* Wait For Element _" + elementLocator + "_ To Be Clickable");
        waitForElement.until(ExpectedConditions
                .elementToBeClickable(UIMappingSingleton.ui(elementLocator)));
    }

    /**
     * An expectation for checking that an element is becomes invisible, but stay on the DOM.
     */
    public void waitForInvisibilityOfElement(String elementLocator) {
        log.info("*Start TO* Wait For Invisibility Of Element _" + elementLocator + "_ ");
        waitForElement.until(ExpectedConditions.invisibilityOfElementLocated(UIMappingSingleton.ui(elementLocator)));
    }

    /**
     * Wait for invisibility Of Element on page specified time
     */
    public void waitForElementNotVisible(String elementLocator, int timeoutInS) {
        log.info("*Start TO* Wait For Element Not Visible _" + elementLocator + "_");

        new WebDriverWait(driver, timeoutInS)
                .until(ExpectedConditions
                        .invisibilityOfElementLocated(
                                UIMappingSingleton.ui(elementLocator)));
    }

    /**
     * Wait for invisibility Of Element on page
     */
    public void waitForElementNotVisible(String elementLocator) {
        log.info("*Start TO* Wait For Element Not Visible _" + elementLocator + "_");
        waitForElement.until(ExpectedConditions
                .invisibilityOfElementLocated(UIMappingSingleton.ui(elementLocator)));
    }

    /**
     * This method is used to agree messages on pop-up windows
     */
    public boolean isAlertPresent() {
        boolean alertPresence = false;

        try {
            Alert alert = driver.switchTo().alert();
            alertPresence = true;
            alert.accept();
        } catch (NoAlertPresentException ex) {
            ex.printStackTrace();
            return alertPresence;
        }
        return true;
    }

    /**
     * This method is used to get text from pop-up windows
     */
    public String getAlertText() {
        String alertText;
        try {
            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
            alert.accept();
            log.info("Alert text: " + alertText);
        } catch (NoAlertPresentException ex) {
            alertText = "Alert is not found";
            log.info("Alert is not found");
            ex.printStackTrace();
        }
        return alertText;
    }

    /**
     *Method for refresh page
     */
    public void refreshPage() {
        driver.navigate().refresh();
        log.info("Refresh page");
    }

    /**
     * This method is used to click on something and open window in New Tab
     * Use Actions class
     */
    public void clickOnSomethingAndOpenNewTab(String elementLocator) throws Exception {
        Set<String> oldWindowsSet = driver.getWindowHandles();
        clickButton(elementLocator);
        Set<String> newWindowsSet = driver.getWindowHandles();
        newWindowsSet.removeAll(oldWindowsSet);

        String newWindowHandle = newWindowsSet.iterator().next();
        driver.switchTo().window(newWindowHandle);
    }
}
