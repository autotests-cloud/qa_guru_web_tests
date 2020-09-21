package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubTests extends TestBase {

    @Test
    void loginWithUnverifiedEmailTest() {
        open("/login");

        $("#login_field").setValue(config.unverifiedUserName());
        $("#password").setValue(config.unverifiedUserPassword()).pressEnter();

        $(".flash-error").shouldHave(text("Your account has been flagged."));
    }
}
