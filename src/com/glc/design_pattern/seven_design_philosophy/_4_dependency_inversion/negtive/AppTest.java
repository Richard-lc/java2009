package com.glc.design_pattern.seven_design_philosophy._4_dependency_inversion.negtive;


//需求：人喂养动物
class Person {
    public void feed(Dog dog) {
        dog.eat();
    }
}

class Dog {
    public void eat() {
        System.out.println("主人喂我了。汪汪汪...");
    }
}

public class AppTest {
    public static void main(String[] args) {
        Person person = new Person();
        Dog dog = new Dog();
        person.feed(dog);
    }
}

/*
    这时候，Person内部的feed方法依赖于Dog，是上层方法中又依赖于下层的类。（人竟然依赖于一条狗？这算骂人吗？）
    当有需求变更，人的宠物不止有狗狗，还可以是猫等等，
    这时候需要修改上层类，这带来的是重用性的问题，
    同时还违反上面提到的开闭原则。
 */