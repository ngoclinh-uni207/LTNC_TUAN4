package Bai06;


class ArrayUtils {
    // swap
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i]=array[j];
        array[j]= temp;
    }
    // sort
    public static <T extends Comparable <T>> void sort(T[] array) {
        int n = array.length;
        for (int i=0; i<n-1; i++) {
            for (int j=0; j<n-1-i; j++) {
                if (array[j].compareTo(array[j+1]) >0 ) {
                    swap(array, j, j+1);
                }
            }
        }
    }
}
class Student implements Comparable<Student> {
    String name;
    public Student(String name) {
        this.name=name;
    }
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }
    public String toString() {
        return this.name;
    }
}

public class Main {
    public static void main(String[] args) {
        Integer[] intArray = {5, 1, 3, 2};
        System.out.println("Sắp xếp mảng Integer: ");
        ArrayUtils.sort(intArray);
        printArray(intArray);

        String[] strArray = {"Java", "C++", "Python"};
        System.out.println("Sắp xếp mảng String: ");
        ArrayUtils.sort(strArray);
        printArray(strArray);

        Student[] stuArray = { new Student("Võ"),
        new Student("Ngọc"),
        new Student("Linh")
        };
        System.out.println("Sắp xếp mảng Student: ");
        ArrayUtils.sort(stuArray);
        printArray(stuArray);

    }
    public static <T> void printArray(T[] array) {
        for (T i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}