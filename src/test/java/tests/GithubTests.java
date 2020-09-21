package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubTests {

    @Test
    void loginWithUnverifiedEmailTest() {
        open("https://github.com/login");

        $("#login_field").setValue("");
        $("#password").setValue("").pressEnter();

        $(".flash-error").shouldHave(text("Your account has been flagged."));
    }
}
