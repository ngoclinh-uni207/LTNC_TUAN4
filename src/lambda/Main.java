package lambda;

@FunctionalInterface
 interface Animal {
    String speak(String firstName,String lastName);
}

public class Main {
    public static void main(String[] args) {
        Animal cat2 = (firstName,lastName) -> "Họ và tên: "+ firstName+ " " + lastName ;
        System.out.println(cat2.speak("Linh","Vo"));
    }
}