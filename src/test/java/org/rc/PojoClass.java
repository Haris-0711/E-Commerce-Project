package org.rc;

import org.bs.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PojoClass extends BaseClass {

public PojoClass() {
	PageFactory.initElements(driver, this);
}

@FindBy(xpath = "//input[@class = 'desktop-searchBar']")
private WebElement srch;

@FindBy(xpath = "//a[@class = 'desktop-submit']" )
private WebElement srchbtn;

@FindBy(xpath = "(//div[@class = 'product-sliderContainer'])[1]")
private WebElement product;

@FindBy(xpath = "(//p[@class = 'size-buttons-unified-size'])[2]")
private WebElement size;

@FindBy(xpath = "//span[@class= 'myntraweb-sprite pdp-whiteBag sprites-whiteBag pdp-flex pdp-center']")
private WebElement addbag;

@FindBy(xpath = "(//span[@class = 'desktop-userTitle'])[3]" )
private WebElement bagicon;

public WebElement getSrch() {
	return srch;
}

public WebElement getSrchbtn() {
	return srchbtn;
}

public WebElement getProduct() {
	return product;
}

public WebElement getSize() {
	return size;
}

public WebElement getAddbag() {
	return addbag;
}

public WebElement getBagicon() {
	return bagicon;
}





}
