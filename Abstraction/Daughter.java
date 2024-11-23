package Abstraction;

public class Daughter extends Parent {

    @Override
    void career(String name) {
        System.out.println(name);
    }

    @Override
    void partner(String name, int age) {
        System.out.println("Name: " + name + ", Age" + age);
    }

}
