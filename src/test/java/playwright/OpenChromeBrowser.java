package playwright;

import com.microsoft.playwright.*;

public class OpenChromeBrowser {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(); // You can also use .firefox() or .webkit()

            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("https://www.google.com"); // Replace with the URL you want to open

            // Add your testing logic here

            page.close();
            context.close();
            browser.close();
        }
    }
}
