package Bai10;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class MediaItem {
    protected String maTaiLieu;
    protected String tenTaiLieu;
    public MediaItem(String maTaiLieu,String tenTaiLieu) {
        this.maTaiLieu=maTaiLieu;
        this.tenTaiLieu=tenTaiLieu;
    }
    public abstract String getInfo();
}

class Book extends MediaItem {
    public String tacGia;
    public int soTrang;
    public Book( String tacGia, int soTrang, String maTaiLieu, String tenTaiLieu) {
        super(maTaiLieu,tenTaiLieu);
        this.tacGia=tacGia;
        this.soTrang=soTrang;
    }
    public String getInfo() {
        return tenTaiLieu + " - "+ tacGia+ " - " + soTrang;
    }
}
class DVD extends MediaItem {
    public String daoDien;
    public int thoiLuong;

    public DVD(String daoDien, int thoiLuong, String maTaiLieu, String tenTaiLieu) {
        super(maTaiLieu, tenTaiLieu);
        this.daoDien = daoDien;
        this.thoiLuong = thoiLuong;
    }

    public String getInfo() {
        return tenTaiLieu + " - " + daoDien + " - " + thoiLuong;
    }
}


class LibrarySection< T extends MediaItem> {
        private List<T> items = new ArrayList<>();
        public void addItem(T item){
            items.add(item);
        }
        public void display() {
        for (T item : items) {
            System.out.println(item.getInfo());
        }
    }
}



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong:");

        LibrarySection<Book> bookSection = new LibrarySection<>();
        LibrarySection<DVD> dvdSection = new LibrarySection<>();

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String maTaiLieu = sc.next();
            String tenTaiLieu = sc.next();

            if (type.equals("B")) {
                String tacGia = sc.next();
                int soTrang = sc.nextInt();
                bookSection.addItem(new Book(tacGia, soTrang,  maTaiLieu,  tenTaiLieu));
            } else if (type.equals("D")) {
                String daoDien = sc.next();
                int thoiLuong = sc.nextInt();
                dvdSection.addItem(new DVD( daoDien, thoiLuong, maTaiLieu, tenTaiLieu));
            }
        }

        System.out.println("\nKhu vực Sách:");
        bookSection.display();

        System.out.println("\nKhu vực DVD:");
        dvdSection.display();

        sc.close();
    }
}

