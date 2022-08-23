package modularDrivenFrameWork00;

import org.testng.annotations.Test;

public class TC1 extends Config {
	
	//Create a method for sign in - instead of Void Main
	
	LocatorsValue locatorsvalue = new LocatorsValue();
	Locators locators = new Locators();
	@Test(priority = 0)
	public void Signin() {
		
		System.out.println("Signing in FB");
		
		//UserName for Sign in
		typeByXpath(locators.UserNameLoc,locatorsvalue.UserNameVal);
		//Password for sign in
		typeByXpath(locators.PasswordLoc,locatorsvalue.PasswordVal);
		
		clickByXpath(locators.LoginButtonLoc);
	
	}
	@Test(priority = 1)
public void Signout() {
		
		System.out.println("Sign Out from FB");

	}

}
