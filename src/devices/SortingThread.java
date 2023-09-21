package devices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SortingThread implements Runnable {
    private DevicesList list;
    private boolean ascending;
    public SortingThread(DevicesList list, boolean ascending) {
        this.list = list;
        this.ascending = ascending;
    }
    @Override
    public void run() {
        synchronized (list){
            if (ascending) {
                Collections.sort(list.getDevicesList(), Comparator.comparing(ElectricalDevice::getPower));
                System.out.println("Сортировка по возрастанию:");
                list.showDevices();
            } else {
                Collections.sort(list.getDevicesList(), Comparator.comparing(ElectricalDevice::getPower).reversed());
                System.out.println("Сортировка по убыванию: ");
                list.showDevices();
            }
        }

    }

}
