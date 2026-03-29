package Bai02;
interface CanFly {
    void fly();
}
interface CanSwim {
    void swim ();
}
interface CanFight {
    void fight();
}

class ActionCharacter {
    public void fight () {
        System.out.println("Đấm bốc...");
    }
}
class Hero extends ActionCharacter implements CanFly, CanSwim, CanFight {
    public Hero () {
    }
    public void fly() {
        System.out.println("Hero is flying");
    }
    public void swim() {
        System.out.println("Hero is swimming");
    }
//    public void fight() {
//        System.out.println("Hero is fighting");
    // Khong cần viết lại implement fight() vì Lớp cha ActionCharacter đã có sẵn hàm public void fight().
    // Khi Hero kế thừa ActionCharacter, nó nghiễm nhiên sở hữu hàm fight() đó.
    //Java nhận thấy Hero đã có một hàm khớp hoàn toàn với yêu cầu của interface CanFight, nên nó chấp nhận luôn.
}


public class Main {
    public static void main (String[] args) {
        Hero x= new Hero();
        ((CanSwim)x).swim();
        ((CanFight)x).fight();
    }
}
