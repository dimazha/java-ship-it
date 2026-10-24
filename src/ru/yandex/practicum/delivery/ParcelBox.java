package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    private final int maxWeight;
    private int currentWeight;
    private final List<T> parcels = new ArrayList<>();

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
    }

    public int getParcelCount() {
        return parcels.size();
    }

    public void addParcel(T parcel) {
        if (currentWeight + parcel.getWeight() <= maxWeight) {
            parcels.add(parcel);
            currentWeight += parcel.getWeight();
            System.out.println("Посылка " + parcel.getDescription() + " добавлена в коробку");
        } else {
            System.out.println("Эта посылка не влезет в коробку");
        }
    }

    public void getAllParcels() {
        System.out.println("Содержимое коробки:");
        for (T parcel : parcels) {
            System.out.println(parcel.getDescription());
        }
    }
}
