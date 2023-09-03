//Домашние электроприборы. Определить иерархию электроприборов.
//Включить некоторые в розетку. Подсчитать потребляемую мощность

public class Main {
    public static void main(String[] args) {
    }
}
enum deviceType {
    TV,
    FRIDGE,

}
abstract class ElectricalDevice{
    protected int divicePower;
    protected boolean isPluggedIn;

    public ElectricalDevice(int devicePower, boolean isPluggedIn){
        this.divicePower = devicePower;
        this.isPluggedIn = isPluggedIn;
    }

    public int getDivicePower() {
        return divicePower;
    }
    public boolean getIsPluggedIn(){
        return isPluggedIn;
    }

    @Override
    public abstract String toString();

}