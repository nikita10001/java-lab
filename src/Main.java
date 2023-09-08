//Домашние электроприборы. Определить иерархию электроприборов.
//Включить некоторые в розетку. Подсчитать потребляемую мощность

import devices.DevicesList;
import devices.ElectricalDevice;

import java.util.ArrayList;
import java.util.Scanner;

import static validators.Validator.checkIsNum;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<ElectricalDevice> devices = new ArrayList<>();
//        devices.add(new ElectricalDevice("Fridge", 1000, false));
//        devices.add(new ElectricalDevice("TV", 500, false));
//        devices.add(new ElectricalDevice("Washing Machine", 20, false));
//        devices.add(new ElectricalDevice("Iron", 1000, false));
//        devices.add(new ElectricalDevice("Microwave", 200, false));
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
                case 0:
                    return;

            }

        }
    }
}


//
//class Fridge extends ElectricalDevice {
//    private int compressorsNumber;
//    public Fridge(int power, boolean  isPluggedIn, int compressorsNumber){
//        super(power, isPluggedIn);
//        this.compressorsNumber = compressorsNumber;
//    }
//    @Override
//    public String toString() {
//        return "Fridge.  Power: " + this.power + ", pluggedIn: " + this.isPluggedIn + ", compressorsNumber: " + this.compressorsNumber;
//    }
//}
//class TV extends ElectricalDevice {
//    private double diagonal;
//    public TV(int power, boolean  isPluggedIn, double diagonal){
//        super(power, isPluggedIn);
//        this.diagonal = diagonal;
//    }
//    @Override
//    public String toString() {
//        return "TV.  Power: " + this.power + ", pluggedIn: " + this.isPluggedIn + ", diagonal: " + this.diagonal;
//    }
//}
//class Microwave extends ElectricalDevice {
//    private double volume;
//    public Microwave(int power, boolean  isPluggedIn, double volume){
//        super(power, isPluggedIn);
//        this.volume = volume;
//    }
//    @Override
//    public String toString() {
//        return "Microwave.  Power: " + this.power + ", pluggedIn: " + this.isPluggedIn + ", volume: " + this.volume;
//    }
//}