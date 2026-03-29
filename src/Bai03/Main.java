
package Bai03;
import java.util.ArrayList;
import java.util.Scanner;

interface IWorkable {
    void work ();
}
abstract class Employee implements IWorkable {
    protected String id;
    protected String name;
    protected double baseSalary;
    public Employee (String id,String name,double baseSalary ) {
        this.baseSalary=baseSalary;
        this.id=id;
        this.name=name;
    }
    abstract public double calculatePay();
// ớp Abstract KHÔNG bắt buộc implement work()
    // Bản thân Employee là một lớp abstract (chưa hoàn thiện).\
    // Việc triển khai work() sẽ được "đẩy" xuống cho các lớp con cụ thể (như OfficeWorker hay Technician) thực hiện.
    // Điều này rất hợp lý vì mỗi loại nhân viên sẽ có cách làm việc (work) khác nhau hoàn toàn.
}

class OfficeWorker extends Employee {
    public OfficeWorker(String id, String name, double baseSalary) {
        super(id,name,baseSalary);
    }
    public double calculatePay(){
        return baseSalary;
    }
    public void work() {
        System.out.println("Soạn thảo văn bản");
    }
}


class Technician extends Employee {
    private double overtimeHours;
    public Technician(String id, String name, double baseSalary, double overtimeHours) {
        super(id,name,baseSalary);
        this.overtimeHours=overtimeHours;
    }
    public double calculatePay() {
        return baseSalary + overtimeHours * 20000;
    }
    public void work () {
        System.out.println("Lắp đặt thiết bị");
    }
}

public class Main {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        ArrayList<Employee> ds = new ArrayList<>();
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            String type= sc.next();
            String id= sc.next();
            String name= sc.next();
            double baseSalary=sc.nextDouble();
            if (type.equals("O")) {
                ds.add(new OfficeWorker(id, name, baseSalary));
            } else if (type.equals("T")) {
                int time = sc.nextInt();
                ds.add(new Technician(id, name, baseSalary, time));
            }
        }
        double totalPay=0;
        System.out.println();

        for (Employee e: ds) {
            double pay=e.calculatePay();
            totalPay +=pay;
            System.out.println(e.name + " - Pay: " + pay);
            e.work();
            System.out.println();
        }
        System.out.println("Total Pay = " + totalPay);

    }
}
