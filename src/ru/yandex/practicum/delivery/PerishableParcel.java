package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    private int timeToLive;

    public PerishableParcel(String description, String deliveryAddress, int weight, int sendDay, int timeToLive) {
        this.description = description;
        this.deliveryAddress = deliveryAddress;
        this.weight = weight;
        this.sendDay = sendDay;
        this.timeToLive = timeToLive;
        this.parcelType = ParcelType.PERISHABLE;
    }

    @Override
    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress);
    }

    public boolean isExpired(int currentDay) {
        return sendDay + timeToLive < currentDay;
    }
}
