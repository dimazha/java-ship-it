package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

import static org.junit.jupiter.api.Assertions.*;

public class ExpirationTest {

    PerishableParcel parcel = new PerishableParcel("Тест", "Тест", 10, 3, 5);

    @Test
    void expiredIfCurrentIsAfterExpiration() {
        assertTrue(parcel.isExpired(12));
    }

    @Test
    void notExpiredIfCurrentIsBeforeExpiration() {
        assertFalse(parcel.isExpired(6));
    }

    @Test
    void notExpiredIfCurrentIsOnExpiration() {
        assertFalse(parcel.isExpired(8));
    }
}
