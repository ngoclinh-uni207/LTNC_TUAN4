package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Vihicle {
    protected String bienSo;
    protected String brand;
    public Vihicle (String bienSo,String brand) {
        this.bienSo=bienSo;
        this.brand=brand;
    }
    public abstract String inFo();
}

class XeMay extends Vihicle {
    public double dungTich;
    public XeMay (String bienSo, String brand, double dungTich) {
        super(bienSo,brand);
        this.dungTich=dungTich;
    }
    public String inFo() {
        return brand+ " - "+ bienSo+ " - "+ dungTich+"L";
    }
}
class OTo extends Vihicle {
    public int soGhe;
    public OTo (String bienSo, String brand, int soGhe) {
        super(bienSo,brand);
        this.soGhe=soGhe;
    }
    public String inFo() {
        return brand+ " - "+ bienSo+ " - "+ soGhe+ " chỗ";
    }
}
class GarageSection<T extends Vihicle> {
    private List<T> xe = new ArrayList<>();

    public void addXe(T x) {
        xe.add(x);
    }
    public void display() {
        for ( T x: xe) {
            System.out.println(x.inFo());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        GarageSection<XeMay> xemay= new GarageSection<>();
        GarageSection<OTo> oto= new GarageSection<>();
        Scanner sc =new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n= sc.nextInt();

        for (int i=0; i<n; i++) {
            String type= sc.next();
            String bienSo= sc.next();
            String brand= sc.next();
            if (type.equals("M")) {
                double dungTich=sc.nextDouble();
                xemay.addXe(new XeMay(bienSo,brand,dungTich));
            } else if (type.equals("C")) {
                int soGhe= sc.nextInt();
                oto.addXe(new OTo(bienSo,brand,soGhe));
            }
        }
        System.out.println("\nKhu vực Xe máy:");
        xemay.display();

        System.out.println("\nKhu vực Ô tô:");
        oto.display();

        sc.close();

    }
}
