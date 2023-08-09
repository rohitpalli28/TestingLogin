package com.qa.rationarium.test;

import com.qa.rationarium.base.BaseClass;
import com.qa.rationarium.dataProvider.LoginDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
#1 TC if users does not enter PWD

 */

public class LoginPageTestNullPWD extends BaseClass {
    @Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
    public void logintest(String scenario, String email, String pwd) {
       // String invalid_Email_Error = "Email must be a valid email";
       // String validEmaidPwd = "User does not exist!";
        //String emptyUserError = "Please fill in all mandatory fields";
        String pwdError = "Please fill in all mandatory fields";


        if (scenario.equalsIgnoreCase("UID")) {
            System.out.println(scenario);
            lp.signinClick(lp.getSigninBtn());
            lp.pageEmailFill(lp.getUsername(), email);
            //lp.pagePwdFill(lp.getPassword(), pwd);
            lp.loginBtnClick(lp.getLoginBtn());
            String errorMsgPwd = lp.getErrorValidationText(lp.getEmptyUserPwd());
            System.out.println(errorMsgPwd);
            Assert.assertEquals(errorMsgPwd.trim(), pwdError);
            // page.close();

        }
    }
}
