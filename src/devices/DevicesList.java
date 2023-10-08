package devices;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DevicesList implements Serializable {
    private ArrayList<ElectricalDevice> devicesList;
    public DevicesList(ArrayList<ElectricalDevice> devicesList){
        this.devicesList = devicesList;
    }
    public DevicesList(){}
    public ArrayList<ElectricalDevice> getDevicesList() {
        return devicesList;
    }
    public void setDevicesList(ArrayList<ElectricalDevice> devicesList) {
        this.devicesList = devicesList;
    }

    public void showDevices(){
        devicesList.forEach(device -> System.out.println(device) );
    }

    public void showDevices(List<ElectricalDevice> deviceList){
        if(deviceList.isEmpty()){
            System.out.println("Список пуст");
            return;
        }
        deviceList.forEach(device -> System.out.println(device));
    }

    public int calcGeneralPower(){
        int sum = 0;
        for(ElectricalDevice device : devicesList){
            if(device.getIsPluggedIn()){
                sum += device.getPower();
            }
        }
        return sum;
    }

    public void ascSort() {
            ArrayList<ElectricalDevice> copy = devicesList;
            synchronized (this){
                Collections.sort(copy, Comparator.comparing(ElectricalDevice::getPower));
                System.out.println("Сортировка по возрастанию:");
                showDevices();
            }
    }
    public void descSort() {
            ArrayList<ElectricalDevice> copy = devicesList;
            synchronized (this) {
                Collections.sort(copy, Comparator.comparing(ElectricalDevice::getPower).reversed());
                System.out.println("Сортировка по убыванию: ");
                showDevices();
            }
    }

    public ElectricalDevice findDevice(deviceCheck ch){
        for(ElectricalDevice device : devicesList){
            if(ch.check(device)) {
                return device;
            }
        }
        return null;
    }
    public void plugInDevice(String type){
        ElectricalDevice foundDevice = findDevice(device ->  device.getType().equals(type));
        if(foundDevice == null){
            System.out.println("Такого устройства нет");
            return;
        }
        if(foundDevice.getIsPluggedIn()){
            System.out.println("Устройство " + type +  " уже включено");
            return;
        }
        foundDevice.plugIn();
        System.out.println("Устройство " + type +  " включено");

    }
    public ArrayList<ElectricalDevice> filtfghvcerDevices() {
        return devicesList.stream()
                .filter(device -> device.getIsPluggedIn())
                .collect(Collectors.toCollection(ArrayList::new));


    }
    public ArrayList<ElectricalDevice> skipDevices(int num) {
        return devicesList.stream()
                .skip(num)
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<ElectricalDevice> getLimit(int num) {
        return devicesList.stream()
                .limit(num)
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<ElectricalDevice> deleteDevices(){
        return devicesList.stream()
                .collect(Collectors.toMap(ElectricalDevice::getType, item -> item, (a, b) -> a))
                .values()
                .stream()
                .collect(Collectors.toCollection(ArrayList::new));


    }

}

interface deviceCheck{
    boolean check(ElectricalDevice d);
}
