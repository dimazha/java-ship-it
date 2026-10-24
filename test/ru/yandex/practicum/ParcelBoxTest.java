package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.Parcel;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandardParcel;

import static org.junit.jupiter.api.Assertions.*;

public class ParcelBoxTest {

    @Test
    void allowedAddingParcelWithEnoughFreeWeight() {
        ParcelBox box = new ParcelBox(10);
        Parcel parcel = new StandardParcel("Тест", "Тест", 5, 3);
        box.addParcel(parcel);
        assertEquals(1, box.getParcelCount());
    }

    @Test
    void notAllowedAddingParcelWithNotEnoughFreeWeight() {
        ParcelBox box = new ParcelBox(1);
        Parcel parcel = new StandardParcel("Тест", "Тест", 5, 3);
        box.addParcel(parcel);
        assertEquals(0, box.getParcelCount());
    }

    @Test
    void allowedAddingParcelWithExactFreeWeight() {
        ParcelBox box = new ParcelBox(10);
        Parcel parcel = new StandardParcel("Тест", "Тест", 10, 3);
        box.addParcel(parcel);
        assertEquals(1, box.getParcelCount());
    }
}
