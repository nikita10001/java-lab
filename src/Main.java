//Домашние электроприборы. Определить иерархию электроприборов.
//Включить некоторые в розетку. Подсчитать потребляемую мощность

import devices.DevicesList;
import devices.ElectricalDevice;
import validators.Validator;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import static validators.Validator.checkIsNum;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<ElectricalDevice> devices = new ArrayList<>();

        devices.add(new ElectricalDevice("Холодильник", 1000, false));
        devices.add(new ElectricalDevice("Телевизор", 500, false));
        devices.add(new ElectricalDevice("Стиральная машина", 20, false));
        devices.add(new ElectricalDevice("Утюг", 1000, false));
        devices.add(new ElectricalDevice("Микроволновка", 200, false));
        devices.add(new ElectricalDevice("Микроволновка", 200, false));
        devices.add(new ElectricalDevice("Микроволновка", 200, false));

        DevicesList deviceList = new DevicesList(devices);

        while (true) {
            System.out.println("\nВыберите пунк меню");
            System.out.println("1. Список устройств");
            System.out.println("2. Включить устройство ");
            System.out.println("3. Посчитать потребляемую мощность ");
            System.out.println("4. Сортировать устройства");
            System.out.println("5. Фильтрация, показать включённые устройства");
            System.out.println("6. Пропустить 2 первых элемента");
            System.out.println("7. Удалить повторяющиеся элементы");
            System.out.println("8. Вывести первых 2 элемента");
            System.out.println("0. Выйти из программы");
            switch (Validator.checkIsNum()) {
                case 1:
                    deviceList.showDevices();
                    break;
                case 2:
                    deviceList.showDevices(deviceList.deleteDevices());
                    System.out.println("Выберите устройство для включения: (Введите тип)");
                    deviceList.plugInDevice(scanner.next());
                    break;
                case 3:
                    System.out.println("Потребляемая мощность включённых устройств: ");
                    System.out.println(deviceList.calcGeneralPower());
                    break;
                case 4:
                    Thread th1 = new Thread(() -> deviceList.descSort());
                    Thread th2 = new Thread(() -> deviceList.ascSort());
                    th1.start();
                    th2.start();
                    try {
                        th1.join();
                        th2.join();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    deviceList.showDevices(deviceList.filterDevices());
                    break;
                case 6:
                    deviceList.showDevices(deviceList.skipDevices(2));
                    break;
                case 7:
                    deviceList.showDevices(deviceList.deleteDevices());
                    break;
                case 8:
                    deviceList.showDevices(deviceList.getLimit(2));
                    break;
                case 0:
                    return;

            }

        }
    }

}

