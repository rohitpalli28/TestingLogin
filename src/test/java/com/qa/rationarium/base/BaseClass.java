package com.qa.rationarium.base;

import com.microsoft.playwright.Page;
import com.qa.rationarium.factory.PlaywrightFactory;
import com.qa.rationarium.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

/*
Before Test
After test
Parameter initialization
 */

public class BaseClass {
    protected   PlaywrightFactory pf;
   protected LoginPage lp;
    protected Page page;
    protected Properties prop;

    @BeforeTest
    public void setup(){
        pf = new PlaywrightFactory();
        prop=  pf.init_prop();
        page = pf.browserUtil(prop);
        lp = new LoginPage(page);

    }

   @AfterTest
   public void tearDown()
   {
       page.context().browser().close();



    }
}
