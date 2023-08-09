package com.qa.rationarium.test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.qa.rationarium.base.BaseClass;
import com.qa.rationarium.dataProvider.LoginDataProvider;
import com.qa.rationarium.factory.PlaywrightFactory;
import com.qa.rationarium.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {


    /*
    Login Test case
     */


    /*
#1 TC if users does not enter password
#2 TC if users enters invalid email id like sample
#3 TC if users tries to login with user which does not exists
 */
    @Test(dataProvider = "loginData",dataProviderClass = LoginDataProvider.class)
    public void logintest(String scenario,String email,String pwd)
    {
         String invalid_Email_Error = "Email must be a valid email";
         //String validEmaidPwd = "User does not exist!";
         //String emptyUserError ="Please fill in all mandatory fields";
         String pwdError ="Please fill in all mandatory fields";

         if (scenario.equalsIgnoreCase("Nullpwd"))
    {
        lp.signinClick(lp.getSigninBtn());
        lp.pageEmailFill(lp.getUsername(),email);
        lp.loginBtnClick(lp.getLoginBtn());
        String errormsg2 = lp.getErrorValidationText(lp.getEmptyUserPwd());
        System.out.println(errormsg2);
        Assert.assertEquals(errormsg2.trim(),pwdError );
    }

         else if (scenario.equalsIgnoreCase("valid"))
         {
             System.out.println(scenario);
             lp.signinClick(lp.getSigninBtn());
             lp.pageEmailFill(lp.getUsername(),email);
             lp.pagePwdFill(lp.getPassword(),pwd);
             lp.loginBtnClick(lp.getLoginBtn());
             System.out.println(lp.getErrormessageEmail());
             String errormsg1 = lp.getErrorValidationText(lp.getErrormessageEmail());
             System.out.println(errormsg1);
             Assert.assertEquals(errormsg1.substring(0,errormsg1.length()-1).trim(),invalid_Email_Error);

         }
        else if(scenario.equalsIgnoreCase("valid1"))
        {
            System.out.println(scenario);
            lp.signinClick(lp.getSigninBtn());
            lp.pageEmailFill(lp.getUsername(),email);
            lp.pagePwdFill(lp.getPassword(),pwd);
            lp.loginBtnClick(lp.getLoginBtn());
            String errormsg = lp.getErrorValidationText(lp.getErrormessageValidEmail());
            System.out.println(errormsg);
            Assert.assertEquals(errormsg.trim(),invalid_Email_Error);

        }
        }
        }




