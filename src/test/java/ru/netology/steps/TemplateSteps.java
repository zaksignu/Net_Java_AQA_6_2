package ru.netology.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;
import ru.netology.page.TransferPage;
import ru.netology.page.VerificationPage;

import static ru.netology.data.DataHelper.*;


public class TemplateSteps {
    private static LoginPage loginPage;
    private static DashboardPage dashboardPage;
    private static VerificationPage verificationPage;
    private static TransferPage transferPage;


    @Пусть("открыта страница с формой авторизации {string}")
    public void openAuthPage(String url) {
        loginPage = Selenide.open(url, LoginPage.class);
    }

    @Когда("пользователь пытается авторизоваться с именем {string} и паролем {string}")
    public void loginWithNameAndPassword(String login, String password) {
        verificationPage = loginPage.validLogin(login, password);
    }

    @И("пользователь вводит проверочный код 'из смс' {string}")
    public void setValidCode(String verificationCode) {
        dashboardPage = verificationPage.validVerify(verificationCode);
    }

    @Тогда("происходит успешная авторизация и пользователь попадает на страницу 'Личный кабинет'")
    public void verifyDashboardPage() {
        dashboardPage.verifyIsDashboardPage();
    }

    @Тогда("появляется ошибка о неверном коде проверки")
    public void verifyCodeIsInvalid() {
        verificationPage.verifyCodeIsInvalid();
    }

    @Когда("пользователь переводит {string} рублей с карты с номером {string} на свою {string} карту с главной страницы")
    public void moneyTransfer(String amount, String cardFrom, String cardTo) {

        int cardIn = Integer.parseInt(cardTo);
        if (cardIn == 1) {

            transferPage = dashboardPage.cardsTransferToFirst(cardFrom);
        } else {
            transferPage = dashboardPage.cardsTransferToFirst(cardFrom);
        }
        dashboardPage = transferPage.transition(amount);
        dashboardPage.verifyIsDashboardPage();
    }

    @Тогда("баланс его {string} карты из списка на главной странице должен стать {int} рублей.")
    public void balanceCheck(String cardId, Integer balance) {
        int cardIdForBalance = Integer.parseInt(cardId) - 1;
        int actualBalance = dashboardPage.getCardBalance(cardIdForBalance);
        Assertions.assertEquals(balance, actualBalance);
    }

}

