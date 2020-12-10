package com.glc.design_pattern.factory.factory_method;


/*===============服务端======================*/
//------------------------产品质检流程-----------------------、
class QualityInspection {

    public void checking(FoodFactory foodFactory) {
        System.out.println("我是人肉质检员。。。。。准备开吃 -_- ");
        Food food = foodFactory.getFood();
        food.eat();
    }
}

/*=================客户端===================*/
public class Supplement {

    public static void main(String[] args) {
        FoodFactory foodFactory01 = new SpaghettiFactory();
        FoodFactory foodFactory02 = new RiceFactory();

        QualityInspection inspection = new QualityInspection();
        inspection.checking(foodFactory02);
        inspection.checking(foodFactory01);
    }
}

/*
    这时候，如果Rice没有他的工厂类，甚至都没办法参加质检，那还怎么卖？

    所以编写工厂类并不只是单纯为了实例化某些产品类，而是能让配套服务通过工厂接口，得以调用工厂创建产品实例。

    有的小朋友大大的眼睛里还有疑惑：那为什么QualityInspection的checking方法不直接调用Food接口再进行产品的实例化呢？

    这时候回到简单工厂模式，产品类不同于工厂类，它是善变的，它会随着需求的变化而变化，
    这时候，直接依赖产品类的各种方法，将需要被修改，违反开闭原则。这是死路，小朋友别杠了。哈哈哈。

    当然，工厂方法模式也是有缺陷的：
        当业务需要的类型变多，目前只有食物，当产生饮料，日用品等类别时，我们又要创建新的工厂来实现，造成代码重复臃肿。
 */