package lambda;

public class test {
    int a;
    int b;
    public test(int a, int b) {
        this.a=a;
        this.b=b;
    }
    public int print() {
        return a+b;
    }
    public static void main (String[] args) {
        test sum= new test(3,4);
        System.out.println(sum.print());
    }
}
