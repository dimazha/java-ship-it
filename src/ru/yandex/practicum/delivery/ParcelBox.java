package ru.yandex.practicum.delivery;

import java.util.List;

public class ParcelBox<T extends Parcel> {
    private int maxWeight;
    List<T> parcels;

    public void addParcel(T parcel) {
        if (parcels == null) {
            parcels = List.of(parcel);
        } else {
            parcels.add(parcel);
        }
    }
}
