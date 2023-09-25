package ru.netology;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {
    String currentDate = String.valueOf(LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

    @Test
    void ShouldDoneTest() {
        open("http://localhost:9999/");
        $("[data-test-id=city] input").setValue("Белгород");
        $("[data-test-id=date] input").doubleClick().sendKeys(currentDate);
        $("[data-test-id=name] input").setValue("Петров Максим");
        $("[name='phone']").setValue("+79310016666");
        $("[data-test-id=agreement]").click();
        $(byText("Забронировать")).click();
        $(withText("Встреча успешно забронирована")).shouldBe(visible, Duration.ofSeconds(15));
    }

}
