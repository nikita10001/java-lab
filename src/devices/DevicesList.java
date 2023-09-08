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

    public void plugInDevice(String type){
        boolean isExist = false;
        for(ElectricalDevice device : devicesList){
            if(device.getType().equals(type)){
                device.plugIn();
                isExist = true;
                break;
            }
        }
        if(!isExist){
            System.out.println("Такого устройства нет");
        }
    }

}

