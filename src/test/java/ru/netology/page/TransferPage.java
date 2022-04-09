package ru.netology.page;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private String cardNumber;
    private SelenideElement cardNumbers = $("[data-test-id=\"from\"] .input__control");
    private SelenideElement inputSumm = $("[data-test-id=\"amount\"] .input__control");
    private SelenideElement submitButton = $("[data-test-id=\"action-transfer\"]");


    public TransferPage(String card) {
        this.cardNumber = card;
    }


    public DashboardPage transition(String money) {

        inputSumm.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        inputSumm.setValue(money);

        cardNumbers.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        cardNumbers.sendKeys(cardNumber);

        submitButton.click();
        return new DashboardPage();
    }


}
