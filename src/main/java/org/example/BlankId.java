package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class BlankId {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setViewportSize(800, 600));
            Page page = context.newPage();
            page.navigate("https://prod.rationarium.com/");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();
            page.locator("input[type=\"password\"]").click();
            page.locator("input[type=\"password\"]").fill("Best123$$");
            page.locator("form").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Sign In")).click();
            page.getByText("Please fill in all mandatory fields").click();
        }
    }
}