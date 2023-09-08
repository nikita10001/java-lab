package devices;
public class ElectricalDevice {
    protected String type;
    protected int power;
    protected boolean isPluggedIn;

    public ElectricalDevice(String type, int power, boolean isPluggedIn) {
        this.type = type;
        this.power = power;
        this.isPluggedIn = isPluggedIn;
    }

    public int getPower() {
        return power;
    }
    public String getType(){
        return type;
    }
    public boolean getIsPluggedIn() {
        return isPluggedIn;
    }

    public void plugIn() {
        this.isPluggedIn = true;
    }
    public void unplug() {
        this.isPluggedIn = false;
    }
    @Override
    public String toString() {
        return "Тип: " + this.type + ".  мощность: " + this.power + ", состояние: " +  (this.isPluggedIn ? "включён" : "выключен" );
    }
}
