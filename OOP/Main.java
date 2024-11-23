package OOP;

public class Main {
    public static void main(String[] args) {
        Parent parent = new Parent(40);
        Child child = new Child(20);
        Child2 child2 = new Child2();
        System.out.println(child.age);
        System.out.println(child2.age);
        System.out.println(parent.age);
        GrandChild grandChild = new GrandChild();
    }
}
