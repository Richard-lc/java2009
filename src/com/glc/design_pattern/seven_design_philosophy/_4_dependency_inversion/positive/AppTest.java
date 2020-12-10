package com.glc.design_pattern.seven_design_philosophy._4_dependency_inversion.positive;


//需求：人喂养动物
class Person {
    public void feed(Animal animal) {
        animal.eat();
    }
}

interface Animal {
    public void eat();
}

class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("我是狗狗，主人喂我了。汪汪汪...");
    }
}

class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("我是猫咪，主人也喂我了。（我为什么要说也？）喵喵喵...");
    }
}


public class AppTest {
    public static void main(String[] args) {
        Person person = new Person();
        Animal dog = new Dog();
        Animal cat = new Cat();
        person.feed(dog);
        person.feed(cat);
    }
}

/*
    这时候，Person内部的feed方法不在依赖于依赖于Dog或者Cat，
    而是不管是Person，还是Dog或者Cat，他们都依赖与Animal这一抽象类，都依赖于抽象类。
    这时候，不管是曾经的上层代码，还是曾经的下层代码，都不会因为需求而改变。

    依赖倒转原则就是指：代码要依赖于抽象的类，而不要依赖于具体的类；
    要针对接口或抽象类编程，而不是针对具体类编程。
    通过面向接口编程，抽象不应该依赖于细节，细节应该依赖于抽象。
 */