package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.Parcel;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryCostTest {

    @Test
    void standardCostIsWeightByTwo() {
        Parcel parcel = new StandardParcel("Тест", "Тест", 10, 3);
        assertEquals(20, parcel.calculateDeliveryCost());
    }

    @Test
    void fragileCostIsWeightByThree() {
        Parcel parcel = new FragileParcel("Тест", "Тест", 10, 3);
        assertEquals(30, parcel.calculateDeliveryCost());
    }

    @Test
    void perishableCostIsWeightByFour() {
        Parcel parcel = new PerishableParcel("Тест", "Тест", 10, 3, 5);
        assertEquals(40, parcel.calculateDeliveryCost());
    }

    @Test
    void zeroWeightIsZeroCost() {
        Parcel parcel1 = new StandardParcel("Тест", "Тест", 0, 3);
        Parcel parcel2 = new FragileParcel("Тест", "Тест", 0, 3);
        Parcel parcel3 = new PerishableParcel("Тест", "Тест", 0, 3, 5);
        assertEquals(0, parcel1.calculateDeliveryCost());
        assertEquals(0, parcel2.calculateDeliveryCost());
        assertEquals(0, parcel3.calculateDeliveryCost());
    }
}
