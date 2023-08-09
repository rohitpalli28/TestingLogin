package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class InvalidEmail {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setViewportSize(800, 600));
            Page page = context.newPage();
            page.navigate("https://prod.rationarium.com/");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();
            page.locator("input[type=\"text\"]").click();
            page.locator("input[type=\"text\"]").fill("rohitpalli@gmail.com");
            page.locator("input[type=\"text\"]").press("Tab");
            page.locator("input[type=\"password\"]").fill("testing");
            page.locator("form").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Sign In")).click();
            page.getByText("User does not exist!").click();
        }
    }
}
