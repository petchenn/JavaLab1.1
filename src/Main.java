

public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.add(10);
        container.add(20);
        System.out.println(container.get(1)); // 20
        container.remove(0);
        System.out.println(container.getSize()); // 1
    }
}