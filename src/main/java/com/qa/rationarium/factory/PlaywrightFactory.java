package com.qa.rationarium.factory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext context;

    Page page;
    Properties prop;

   /*
   Method :browserUtil is to set context and page
   it is returns page reference
    */
    public   Page browserUtil(Properties prop) {
       String browsername= prop.getProperty("browser").trim();

        System.out.println("Browser name is " + browsername);

        playwright = Playwright.create();

            switch (browsername.toLowerCase()) {


                case "chrome":
                    browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    System.out.println("Chrome browser");
                    break;

                case "firefox":
                    browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    System.out.println("firefox browser");
                    break;

                case "safari":
                    browser=playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    System.out.println("Safari browser");
                    break;
                default:
                    System.out.println("Incrorect browser suggested");
                    //throw new RuntimeException("Incrorect browser suggested");

            }

        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,1080));
            page = context.newPage();
          String url=  prop.getProperty("url").trim();
            page.navigate(url);

            return page;

        }
/*

//Method to use data from properties file
Browser
Url details
Headless details


*/

        //Method to initilize properties of the file


    public Properties init_prop() {
        try {
            FileInputStream fileInputStream = new FileInputStream("./src/test/resources/config.properties");
            prop = new Properties();
            prop.load(fileInputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return prop;
    }

    }

