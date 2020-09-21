package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GithubTests extends TestBase {

    @Test
    @DisplayName("Login with unverified email")
    void loginWithUnverifiedEmailTest() {
        step("Go to login page", () -> {
            open("/login");
            $(".auth-form-header").shouldBe(visible);
        });

        step("Fill the authorization form", () -> {
            $("#login_field").setValue(config.unverifiedUserName());
            $("#password").setValue(config.unverifiedUserPassword()).pressEnter();
        });

        step("Verify flagged authorization", () -> {
            $(".flash-error").shouldHave(text("Your account has been flagged."));
        });
    }
}
