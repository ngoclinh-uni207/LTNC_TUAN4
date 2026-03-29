package Bai08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Cha
abstract class Devices {
    protected String id;
    protected String name;
    protected boolean isOn;
    public Devices (String id, String name) {
        this.id=id;
        this.name=name;
        this.isOn=true;
    }
    public void turnOff(){
        this.isOn=false;
        System.out.println(name + " turned off");
    }
    public String getName() {
        return name;
    }
}
//Chức năng
interface WifiConnectable {
    void connectWifi();
}
interface Adjustable {
    void adjust(int level);
}
//Con
class SmartLight extends Devices implements Adjustable {
    public SmartLight(String id, String name) {
        super(id,name);
    }
    public void adjust(int level) {
        System.out.println(name + " adjusted brightness to " + level );
    }
}

class AirConditioner extends Devices implements WifiConnectable {
    public AirConditioner(String id,String name) {
        super(id,name);
    }
    public void connectWifi() {
        System.out.println(name + " connected to wifi");
    }
}

class SmartSpeaker extends Devices implements WifiConnectable, Adjustable {
    public SmartSpeaker(String id, String name) {
        super(id, name);
    }
    public void connectWifi() {
        System.out.println(name + " connected to wifi");
    }
    public void adjust(int level) {
        System.out.println(name + " adjusted volume to " + level );
    }
}
class Curtain extends Devices {
    public Curtain(String id, String name) {
        super(id, name);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        List<Devices> devices= new ArrayList<>();
        System.out.println("Nhập số thiết bị trong nhà: ");
        int n= sc.nextInt();

        for (int i=0; i<n; i++) {
            String type= sc.next();
            String id=sc.next();
            String name=sc.next();

            switch (type) {
                case "L" : devices.add(new SmartLight(id,name));break;
                case "AC": devices.add(new AirConditioner(id,name));break;
                case "S": devices.add(new SmartSpeaker(id,name));break;
                case "C": devices.add(new Curtain(id,name));break;
            }
        }
        System.out.println("\nTurn Off All Devices: ");
        for (Devices d: devices) {
            d.turnOff();
        }
        System.out.println("\nSetup Wifi:");
        for (Devices d: devices) {
            if (d instanceof WifiConnectable){
                ((WifiConnectable) d).connectWifi();
            }
        }
        sc.close();
    }

}
