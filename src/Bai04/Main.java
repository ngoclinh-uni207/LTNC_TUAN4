package Bai04;
interface IData {
    void show(); // Mặc định là public abstract
}

class DataManager implements IData {
    // Cố tình KHÔNG ghi public
    public void show() {
        System.out.println("Show Data");
    }
}
// java: show() in Bai04.DataManager cannot implement show() in Bai04.IData
//  attempting to assign weaker access privileges; was public
public class Main {
    public static void main(String[] args) {
        System.out.println("+ Trước khi sửa:");
        System.out.println("Error...");
        System.out.println();
        System.out.println("+ Sau khi sửa:");
        DataManager x= new DataManager();
        x.show();
    }
}
