package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Введите номер пункта меню от 0 до 3. Вы ввели: " + choice);
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        System.out.println("Введите краткое описание посылки:");
        String insertedDescription = scanner.nextLine();

        System.out.println("Введите адрес доставки:");
        String insertedAddress = scanner.nextLine();

        System.out.println("Введите вес посылки:");
        int insertedWeight = scanner.nextInt();

        System.out.println("Введите день отправки посылки:");
        int insertedSendDay = scanner.nextInt();

        System.out.println("Укажите тип посылки:");
        System.out.println("1 — Обычная");
        System.out.println("2 — Хрупкая");
        System.out.println("3 — Скоропортящаяся");
        int insertedType = scanner.nextInt();

        switch (insertedType) {
            case 1:
                StandardParcel standardParcel = new StandardParcel
                        (insertedDescription,
                        insertedAddress,
                        insertedWeight,
                        insertedSendDay);
                allParcels.add(standardParcel);
                break;
            case 2:
                FragileParcel fragileParcel = new FragileParcel
                        (insertedDescription,
                        insertedAddress,
                        insertedWeight,
                        insertedSendDay);
                allParcels.add(fragileParcel);
                break;
            case 3:
                System.out.println("Укажите срок годности посылки:");
                int insertedExpireTime = scanner.nextInt();
                PerishableParcel perishableParcel = new PerishableParcel
                        (insertedDescription,
                        insertedAddress,
                        insertedWeight,
                        insertedSendDay,
                        insertedExpireTime);
                allParcels.add(perishableParcel);
                break;
            case 0:
                System.out.println("Возврат в главное меню");
                break;
            default:
                System.out.println("Введите номер типа посылки от 0 до 3. Вы ввели: " + insertedType);
        }

        System.out.println("Посылка успешно добавлена в систему");
    }

    private static void sendParcels() {
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        int totalCost = 0;
        for (Parcel parcel : allParcels) {
            totalCost = totalCost + parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость всех доставок: " + totalCost);
    }

}

