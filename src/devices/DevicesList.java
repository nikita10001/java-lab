package devices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DevicesList {
    private ArrayList<ElectricalDevice> devicesList;
    public DevicesList(ArrayList<ElectricalDevice> devicesList){
        this.devicesList = devicesList;
    }
    public ArrayList<ElectricalDevice> getDevicesList() {
        return devicesList;
    }
    public void setDevicesList(ArrayList<ElectricalDevice> devicesList) {
        this.devicesList = devicesList;
    }

    public void showDevices(){
        devicesList.stream().forEach(device -> System.out.println(device) );
    }

    public void showDevices(ArrayList<ElectricalDevice> deviceList){
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
        synchronized (this) {
            Collections.sort(devicesList, Comparator.comparing(ElectricalDevice::getPower));
            System.out.println("Сортировка по возрастанию:");
            showDevices();
        }
    }
    public void descSort() {
        synchronized (this){
            Collections.sort(devicesList, Comparator.comparing(ElectricalDevice::getPower).reversed());
            System.out.println("Сортировка по убыванию: ");
            showDevices();
        }
    }


    public ElectricalDevice findDevice(deviceCheck ch){
        for(ElectricalDevice device : devicesList){
            if(ch.check(device)){
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
    public List<ElectricalDevice> filterDevices() {
        return devicesList.stream()
                .filter(device -> device.getIsPluggedIn())
                .collect(Collectors.toList());

    }
    public List<ElectricalDevice> skipDevices(int num) {
        return null;
    }
    public ArrayList<ElectricalDevice> deleteDevices(){
        return devicesList.stream()
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));

    }
}

interface deviceCheck{
    boolean check(ElectricalDevice d);
}
