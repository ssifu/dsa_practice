package Abstraction;

public class Son extends Parent {

    Son(int age) {
        this.age = age;
    }

    @Override
    void career(String name) {
        System.out.println(name);
    }

    @Override
    void partner(String name, int age) {
        System.out.println("Name: " + ", Age: " + age);
    }
}
