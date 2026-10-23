package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {

    public StandardParcel(String description, String deliveryAddress, int weight, int sendDay) {
        this.description = description;
        this.deliveryAddress = deliveryAddress;
        this.weight = weight;
        this.sendDay = sendDay;
        this.parcelType = ParcelType.STANDARD;
    }

    @Override
    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress);
    }
}
