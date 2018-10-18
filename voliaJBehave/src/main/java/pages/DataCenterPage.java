package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DataCenterPage extends BasePage {

	public DataCenterPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="#article tr:nth-child(5) > td:nth-child(2)")
	private WebElement serverPrice;
	
	@FindBy(css="#article li.last > a")
	private WebElement cloudLink;
	
	
    public String serverPriceString(){
        return serverPrice.getText();
    }
    
    public void clickCloudPage() {
    	cloudLink.click();
    }
}
