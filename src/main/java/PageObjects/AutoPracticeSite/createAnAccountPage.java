package PageObjects.AutoPracticeSite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class createAnAccountPage
{
    @FindBy(id = "id_gender1")
    public WebElement radiobtn_Mr;

    @FindBy(id = "id_gender2")
    public WebElement radiobtn_Mrs;

    @FindBy(id = "customer_firstname")
    public WebElement txt_firstName;

    @FindBy(id = "customer_lastname")
    public WebElement txt_lastName;

    @FindBy(id = "email")
    public WebElement txt_email;

    @FindBy(id = "passwd")
    public WebElement txt_password;

    @FindBy(id = "days")
    public WebElement dropdown_days;

    @FindBy(id = "months")
    public WebElement dropdown_months;

    @FindBy(id = "years")
    public WebElement dropdown_years;

    @FindBy(id = "firstname")
    public WebElement txt_firstNameForAddress;

    @FindBy(id = "lastname")
    public WebElement txt_lastNameForAddress;

    @FindBy(id = "company")
    public WebElement txt_company;

    @FindBy(id = "address1")
    public WebElement txt_addressMandatory;

    @FindBy(id = "city")
    public WebElement txt_city;

    @FindBy(id = "id_state")
    public WebElement dropdown_state;

    @FindBy(id = "id_country")
    public WebElement dropdown_country;

    @FindBy(id = "postcode")
    public WebElement txt_postcode;

    @FindBy(id = "phone")
    public WebElement txt_phone;

    @FindBy(id = "alias")
    public WebElement txt_alias;

    @FindBy(id = "submitAccount")
    public WebElement btn_submitAccount;







}
