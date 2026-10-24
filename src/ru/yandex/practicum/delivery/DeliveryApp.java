package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<FragileParcel> trackableParcels = new ArrayList<>();

    //создаём три коробки по заданию
    private static ParcelBox boxForStandard = new ParcelBox(100);
    private static ParcelBox boxForFragile = new ParcelBox(50);
    private static ParcelBox boxForPerishable = new ParcelBox(200);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = (Integer.parseInt(scanner.nextLine()));

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
                case 4:
                    printTrackingStatuses();
                    break;
                case 5:
                    printBoxContents();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Введите номер пункта меню от 0 до 5. Вы ввели: " + choice);
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Указать новое местоположение посылок");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        System.out.println("Введите краткое описание посылки:");
        String insertedDescription = scanner.nextLine();

        System.out.println("Введите адрес доставки:");
        String insertedAddress = scanner.nextLine();

        System.out.println("Введите вес посылки:");
        int insertedWeight = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Введите день отправки посылки:");
        int insertedSendDay = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Укажите тип посылки:");
        System.out.println("1 — Обычная");
        System.out.println("2 — Хрупкая");
        System.out.println("3 — Скоропортящаяся");
        System.out.println("0 — Вернуться в главное меню");
        int insertedType = Integer.parseInt(scanner.nextLine().trim());

        switch (insertedType) {
            case 1:
                StandardParcel standardParcel = new StandardParcel
                        (insertedDescription,
                        insertedAddress,
                        insertedWeight,
                        insertedSendDay);
                allParcels.add(standardParcel);
                boxForStandard.addParcel(standardParcel);
                break;
            case 2:
                FragileParcel fragileParcel = new FragileParcel
                        (insertedDescription,
                        insertedAddress,
                        insertedWeight,
                        insertedSendDay);
                allParcels.add(fragileParcel);
                trackableParcels.add(fragileParcel);
                boxForFragile.addParcel(fragileParcel);
                break;
            case 3:
                System.out.println("Укажите срок годности посылки:");
                int insertedExpireTime = Integer.parseInt(scanner.nextLine().trim());
                PerishableParcel perishableParcel = new PerishableParcel
                        (insertedDescription,
                        insertedAddress,
                        insertedWeight,
                        insertedSendDay,
                        insertedExpireTime);
                allParcels.add(perishableParcel);
                boxForPerishable.addParcel(perishableParcel);
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

    private static void printTrackingStatuses() {
        System.out.println("Введите новое местоположение посылок:");
        String insertedNewLocation = scanner.nextLine();

        for (FragileParcel fragileParcel : trackableParcels) {
            fragileParcel.reportStatus(insertedNewLocation);
        }
    }

    private static void printBoxContents() {
        System.out.println("Укажите тип коробки, в которую хотите заглянуть:");
        System.out.println("1 — Коробка для стандартных посылок");
        System.out.println("2 — Коробка для хрупких посылок");
        System.out.println("3 — Коробка для скоропортящихся посылок");
        System.out.println("0 — Вернуться в главное меню");
        int insertedBoxType = Integer.parseInt(scanner.nextLine().trim());

        switch (insertedBoxType) {
            case 1:
                boxForStandard.getAllParcels();
                break;
            case 2:
                boxForFragile.getAllParcels();
                break;
            case 3:
                boxForPerishable.getAllParcels();
                break;
            case 0:
                System.out.println("Возврат в главное меню");
                break;
            default:
                System.out.println("Введите номер типа коробки с посылками от 0 до 3. Вы ввели: " + insertedBoxType);
        }
    }

}

