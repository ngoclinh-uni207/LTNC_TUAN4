package Bai05;
class Pair<K,V> {
    private K key;
    private V value;
    public Pair( K key, V value) {
        this.key=key;
        this.value=value;
    }
    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
    public void setKey(K key) {
        this.key=key;
    }
    public void setValue(V value) {
        this.value=value;
    }
    public String toString() {
        return key + "-" + value;
    }
}

public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> s1 =new Pair<>("Tuổi",20);
        Pair<String, String> s2= new Pair<>("Mã SV","SV001");
        Pair<Integer, Double> s3= new Pair<>(105,21.5);
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.toString());
    }
}
