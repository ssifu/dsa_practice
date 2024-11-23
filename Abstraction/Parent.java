package Abstraction;

public abstract class Parent {
    int age;

    abstract void career(String name);

    abstract void partner(String name, int age);

    static void hello() {
        System.out.println("Hello");
    }
}
