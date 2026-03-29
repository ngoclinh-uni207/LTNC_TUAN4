package Bai07;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    public String id;
    public String name;
    public double gpa;
    public Student (String id, String name,double gpa) {
        this.gpa=gpa;
        this.name=name;
        this.id=id;
    }
    public String getName() {
        return name;
    }
    public double getGpa(){
        return gpa;
    }
    public String toString() {
        return id +" "+name+" "+gpa;
    }
}

@FunctionalInterface
interface Operation<T> {
    T execute(T a, T b);
}

public class Main {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("Nhập vào số lượng sinh viên: ");
        int n = sc.nextInt();
        for (int i=0;i<n; i++) {
            String id = sc.next();
            String name = sc.next();
            double gpa = sc.nextDouble();
            students.add(new Student(id, name, gpa));
        }
        System.out.println("\nAfter removing GPA < 5.0:");
        students.removeIf(student -> student.getGpa() < 5.0);
        students.forEach(student -> System.out.println(student));
        students.sort((sv1,sv2)->sv1.getName().compareTo(sv2.getName()));
        System.out.println("\nAfter sorting by name:");
        students.forEach(student -> System.out.println(student));


        //Lambda
        Operation<Double> add = (a, b) -> a + b;
        Operation<Double> sub = (a, b) -> a - b;
        Operation<Double> mul = (a, b) -> a * b;
        Operation<Double> div = (a, b) -> (b != 0) ? a / b : 0.0;

        double x = 10.0, y = 5.0;
        System.out.println("\n10 + 5 = " + add.execute(x, y));
        System.out.println("10 / 5 = " + div.execute(x, y));

        sc.close();
    }
}
