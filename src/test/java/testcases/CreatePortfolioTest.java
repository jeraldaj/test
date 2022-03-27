package testcases;





import org.testng.annotations.Test;

import keywords.ApplicationKeywords;

public class CreatePortfolioTest {
	
@Test
	public void createPortFolioTest() {
	
	ApplicationKeywords app = new ApplicationKeywords();
	app.openBrowser("Chrome");
	app.navigate("url");
	app.type("username", "ashishthakur1983");
	app.type("password", "pass@1234");
	//validate submit button is present or not
	app.validateElementPersent("loginsubmit");
	app.quit();
//	app.click("login_submit");
//	app.validateLogin();
//	app.selectDateFromCalendar();
		
	}

}
