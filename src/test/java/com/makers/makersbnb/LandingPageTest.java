package com.makers.makersbnb;

import com.microsoft.playwright.*;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LandingPageTest {
    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    @Test
    public void usersAreWelcomeToTheApp() {
        page.navigate("localhost:8080/");
        Locator pageBody = page.locator("body");
        assertThat(pageBody).containsText("Welcome to MakersBnB!");
    }

    @Test
    public void fakeEmailAddressIsShownOnContactUsPage() {
        page.navigate("localhost:8080/contactus");
        Locator pageBody = page.locator("body");
        assertThat(pageBody).containsText("fakeEmailAddress@makers.com");
    }

    @Test
    public void showsAlistOfStaffWhenUserVisitsTeamPage() {
        page.navigate("localhost:8080/team");
        Locator pageBody = page.locator("body");
        assertThat(pageBody).containsText("Toby, Katerina, Sandy");
    }

    @Test
    public void showsTermsAndConditionsWhenUserVisitsPage() {
        page.navigate("localhost:8080/termsAndConditions");
        Locator pageBody = page.locator("body");
        assertThat(pageBody).containsText("Coming soon! In the meantime, please behave yourselves.");
    }

}
