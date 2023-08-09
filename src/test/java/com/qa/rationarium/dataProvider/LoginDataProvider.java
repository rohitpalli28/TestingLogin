package com.qa.rationarium.dataProvider;

import com.qa.rationarium.base.BaseClass;
import org.testng.annotations.DataProvider;

/*

Data provider send data for the test class
*/


public  class LoginDataProvider extends BaseClass {
    @DataProvider(name = "loginData")
    public  Object[][] loginData(){





        return new Object[][]{
                {"Nullpwd","sa,","sample"},
                {"valid","sa,","sample"},
                {"valid1","mple@gmail.com","sample"}


               // {"Pwd","pwd","Pwd"}
        };
    }
}
