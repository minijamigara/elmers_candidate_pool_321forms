package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GeneralInfoPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //input fields
    private By HouseholdStreetAddress = By.id("qid_1_33");
    private By ApartmentNumber = By.id("qid_1_103");
    private By City = By.id("qid_1_34");
    private By Country = By.id("qid_1_246");
    private By StateAbbreviation = By.id("qid_1_35");
    private By ZipCode = By.id("qid_1_36");
    private By Additional4DigitsZipCode = By.id("qid_1_117591");
    private By HomePhone = By.id("qid_1_60");
    private By CellularPhone = By.id("qid_1_1925");
    private By PersonalEmail = By.id("qid_1_146");
    private By AlternateEmail = By.id("qid_1_45970");

    //button
    private By continueBtn = By.id("btnContinue");

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public GeneralInfoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Set a default wait time of 10 seconds
    }

    public String checkNullHouseAddress(){

        String HouseholdStreetAddressVal = (String) js.executeScript("return document.getElementById('qid_1_33').value;");
        if (HouseholdStreetAddressVal == null || HouseholdStreetAddressVal.trim().isEmpty()) {
            System.out.println("Household Street Address is empty.");
        } else {
            System.out.println("Household Street Address: " + HouseholdStreetAddressVal);
        }
        return HouseholdStreetAddressVal;
    }
    public String checkNullApartmentNo(){
        String ApartmentNumberVal = (String) js.executeScript("return document.getElementById('qid_1_103').value;");
        if (ApartmentNumberVal == null || ApartmentNumberVal.trim().isEmpty()) {
            System.out.println("Apartment Number is empty.");
        } else {
            System.out.println("Apartment Number: " + ApartmentNumberVal);
        }
        return ApartmentNumberVal;
    }

    public String checkNullCity(){
        String CityVal = (String) js.executeScript("return document.getElementById('qid_1_34').value;");
        if (CityVal == null || CityVal.trim().isEmpty()) {
            System.out.println("City is empty.");
        } else {
            System.out.println("City: " + CityVal);
        }
        return CityVal;
    }
    public String getCountryValue() {
        return (String) js.executeScript("return document.getElementById('qid_1_246').value;");
    }

    public GeneralInfoPage checkNullCountry(){
        WebElement countryElement = driver.findElement(Country);

        String countryVal = getCountryValue();
        if (countryVal == null || countryVal.trim().isEmpty()) {
            countryElement.sendKeys("USA");
        } else {
            System.out.println("Country: " + countryVal);
        }
        return new GeneralInfoPage(driver);
    }

    public String checkNullStateAbbreviation(){
        WebElement dropdownElement = driver.findElement(StateAbbreviation);
        Select dropdown = new Select(dropdownElement);

        WebElement selectedOption = dropdown.getFirstSelectedOption();
        String selectedValue = selectedOption.getText();

        if (selectedValue.equals("Select") || selectedValue.trim().isEmpty()) {
            System.out.println("No valid option is selected. Default option ('Select') is still selected.");
        } else {
            System.out.println("Selected option: " + selectedValue);
        }
        return selectedValue;
    }

    public GeneralInfoPage processZipCode() {
        // Locate the zip code field
        WebElement zipCodeElement = driver.findElement(ZipCode);
        String zipCodeValue = zipCodeElement.getAttribute("value");

        // Check if the zip code field is empty
        if (zipCodeValue == null || zipCodeValue.trim().isEmpty()) {
            System.out.println("Zip code field is empty.");
        } else {
            // Check if the zip code contains the additional 4 digits part
            if (zipCodeValue.contains("-")) {
                // Split the zip code into the main part and the 4 additional digits
                String[] parts = zipCodeValue.split("-");
                String mainZip = parts[0];  // The main 5-digit zip code
                String additionalZip = parts[1];  // The 4 additional digits

                // Set the main zip code back to the zip code field
                zipCodeElement.clear();
                zipCodeElement.sendKeys(mainZip);

                // Set the 4 additional digits to the respective field
                WebElement additionalZipElement = driver.findElement(Additional4DigitsZipCode);
                additionalZipElement.clear();
                additionalZipElement.sendKeys(additionalZip);

                System.out.println("Processed Zip Code: " + mainZip);
                System.out.println("Additional 4 Digits: " + additionalZip);
            } else {
                System.out.println("Zip code does not contain additional 4 digits: " + zipCodeValue);
            }
        }

        return new GeneralInfoPage(driver);
    }

    public String checkNullCellular(){

        String CellularVal = (String) js.executeScript("return document.getElementById('qid_1_1925').value;");
        if (CellularVal == null || CellularVal.trim().isEmpty()) {
            System.out.println("Cellular No is empty.");
        } else {
            System.out.println("Cellular No: " + CellularVal);
        }
        return CellularVal;
    }

    public String checkNullPersonalEmail(){

        String PersonalEmailVal = (String) js.executeScript("return document.getElementById('qid_1_146').value;");
        if (PersonalEmailVal == null || PersonalEmailVal.trim().isEmpty()) {
            System.out.println("Personal email is empty.");
        } else {
            System.out.println("Personal email: " + PersonalEmailVal);
        }
        return PersonalEmailVal;
    }

    public GeneralInfoPage clickContinueButton() {
        //wait.until(ExpectedConditions.elementToBeClickable(agreeBtn)).click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        return new GeneralInfoPage(driver);
    }
}
