package ru.yandex.practicum.delivery;

public abstract class Parcel {
    protected String description;
    protected String deliveryAddress;
    protected int weight;
    protected int sendDay;
    protected ParcelType parcelType;

    public enum ParcelType {
        STANDARD(2),
        FRAGILE(3),
        PERISHABLE(4);

        private final int multiplier;

        ParcelType(int multiplier) {
            this.multiplier = multiplier;
        }

        public int getMultiplier() {
            return multiplier;
        }
    }

    public void packageItem() {
        System.out.println("Посылка " + description + " упакована");
    };

    public abstract void deliver();

    public int calculateDeliveryCost() {
        return parcelType.getMultiplier() * weight;
    }
}
