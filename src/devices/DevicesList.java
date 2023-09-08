package devices;

import java.util.ArrayList;

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
        devicesList.forEach(device -> System.out.println(device) );
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

    public ElectricalDevice findDeviceByType(String type){
        for(ElectricalDevice device : devicesList){
            if(device.getType().equals(type)){
                return device;
            }
        }
        return null;
    }

    public void plugInDevice(String type){
        ElectricalDevice foundDevice = findDeviceByType(type);
        if(foundDevice == null){
            System.out.println("Такого устройства нет");
            return;
        }
        if(foundDevice.getIsPluggedIn()){
            System.out.println("Устройство " + type +  " уже включено");
            return;
        }
        foundDevice.plugIn();
    }

}

