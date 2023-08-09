package com.qa.rationarium.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage  {

    Page page=null;

    public LoginPage(Page page){
        this.page = page;
    }

    public void setSigninBtn(String signinBtn) {
        this.signinBtn = signinBtn;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLoginBtn(String loginBtn) {
        this.loginBtn = loginBtn;
    }

    public void setErrormessageEmail(String errormessageEmail) {
        this.errormessageEmail = errormessageEmail;
    }

    public String getErrormessageEmail() {
        return errormessageEmail;
    }

    public String getSigninBtn() {
        return signinBtn;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getLoginBtn() {
        return loginBtn;
    }

    public String getErrormessage() {
        return errormessageEmail;
    }

    // Selectors
    private String signinBtn =  "//button[text()='Sign In']";
    private  String  username = "input[formcontrolname='username']";
    private String password ="input[formcontrolname='password']";
    private String loginBtn = "button[type='submit']";
    private String errormessageEmail ="snack-bar-container.mat-snack-bar-container"; //Invalid Email and Pwd

    private String errormessageValidEmail = "snack-bar-container span.mat-simple-snack-bar-content";
    private String passwordAlert = "div.p-toast-summary";
    private String emptyUserError = "div.p-toast-summary";

    public void setErrormessageValidEmail(String errormessageValidEmail) {
        this.errormessageValidEmail = errormessageValidEmail;
    }

    public void setPasswordAlert(String passwordAlert) {
        this.passwordAlert = passwordAlert;
    }

    public void setEmptyUserError(String emptyUserError) {
        this.emptyUserError = emptyUserError;
    }

    public void setEmptyUserPwd(String emptyUserPwd) {
        this.emptyUserPwd = emptyUserPwd;
    }

    public String getErrormessageValidEmail() {
        return errormessageValidEmail;
    }

    public String getPasswordAlert() {
        return passwordAlert;
    }

    public String getEmptyUserError() {
        return emptyUserError;
    }

    public String getEmptyUserPwd() {
        return emptyUserPwd;
    }

    String emptyUserPwd = "div.p-toast-summary";


    //Login Page fill method and click method

    public void pageEmailFill(String username ,String emailId){
        page.fill(username,emailId);
    }
    public void pageEmailclear(String username ){
        page.fill(username,null);
    }
    public void pagePwdFill(String password ,String pwd){
        page.fill(password,pwd);
    }
    public void pagePwdclear(String password) {
        page.fill(password,null);
    }

    public void signinClick(String signinBtn) {
        page.click(signinBtn);
    }
    public void loginBtnClick(String loginBtn) {
        page.click(loginBtn);
    }

    public String getErrorValidationText(String errormessage){
       String errormessagevalid = page.textContent(errormessage);
       return  errormessagevalid;
    }
    public void pageEmailBack(String username ){
        page.locator(username).press("Backspace");
    }


}
