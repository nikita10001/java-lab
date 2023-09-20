//Домашние электроприборы. Определить иерархию электроприборов.
//Включить некоторые в розетку. Подсчитать потребляемую мощность

import devices.DevicesList;
import devices.ElectricalDevice;
import devices.SortingThread;

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



        DevicesList deviceList = new DevicesList(devices);

        while (true) {
            System.out.println("\nВыберите пунк меню");
            System.out.println("1. Список устройств");
            System.out.println("2. Включить устройство ");
            System.out.println("3. Посчитать потребляемую мощность ");
            System.out.println("4. Сортировать устройства");
            System.out.println("0. Выйти из программы");
            switch (checkIsNum()) {
                case 1:
                    deviceList.showDevices();
                    break;
                case 2:
                    deviceList.showDevices();
                    System.out.println("Выберите устройство для включения: (Введите тип)");
                    deviceList.plugInDevice(scanner.next());
                    break;
                case 3:
                    System.out.println("Потребляемая мощность включённых устройств: ");
                    System.out.println(deviceList.calcGeneralPower());
                    break;
                case 4:
                    SortingThread firstThread = new SortingThread(deviceList, false);
                    SortingThread secondThread = new SortingThread(deviceList, true);
                    Thread th1 = new Thread(firstThread);
                    Thread th2 = new Thread(secondThread);
                    th1.start();
                    th2.start();

                    try {
                        th1.join();
                        th2.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 0:
                    return;

            }

        }
    }
}

