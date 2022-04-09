package ru.netology.data;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
// Данный класс как пример генерации тестовых данных
// Вместа передачи данных через сценарий (feature)
// можно вызывать подобные методы непосредственно в шагах сценария (steps)
public class DataHelper {

    public static VerificationCode getVerificationCode() {
        return new VerificationCode("12345");
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        String code;
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }
    @Value
    public static class Cards {
        private String firstCard;
        private String secondCard;
        private int firstCardId;
        private int secondCardId;
    }

    public static Cards getCardsInfo() {

        return new Cards("5559000000000001", "5559000000000002",0,1);
    }

}