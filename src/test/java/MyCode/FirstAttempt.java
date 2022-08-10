package MyCode;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

public class FirstAttempt {

    @Test
    void FirstS() {
        Selenide.open("https://yandex.ru/");
    }
}
