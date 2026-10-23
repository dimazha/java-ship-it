package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel {

    public FragileParcel(String description, String deliveryAddress, int weight, int sendDay) {
        this.description = description;
        this.deliveryAddress = deliveryAddress;
        this.weight = weight;
        this.sendDay = sendDay;
        this.parcelType = ParcelType.FRAGILE;
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + description + " обёрнута в защитную плёнку");
        super.packageItem();
    }

    @Override
    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress);
    }
}
