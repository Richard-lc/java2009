package com.glc.design_pattern.factory.factory_method;

/**
 * 简述：为了进行扩展，不违反开闭原则。
 * <p>
 * 这里是基于简单工厂模式进行改进。
 */

/*===============服务端======================*/
//-----------------------产品--------------------
interface Food {
    void eat();
}

class Spaghetti implements Food {
    @Override
    public void eat() {
        System.out.println("吃西餐面条。。。。。");
    }
}

//--------------------------工厂-----------------------
interface FoodFactory {
    Food getFood();
}

class SpaghettiFactory implements FoodFactory {

    @Override
    public Food getFood() {
        return new Spaghetti();
    }
}

/*=================客户端===================*/
//新增产品
class Rice implements Food {
    @Override
    public void eat() {
        System.out.println("吃米饭。。。。。");
    }
}

//新增产品工厂
class RiceFactory implements FoodFactory {

    @Override
    public Food getFood() {
        return new Rice();
    }
}


public class Positive {

    public static void main(String[] args) {
        FoodFactory foodFactory = new SpaghettiFactory();
        Food food = foodFactory.getFood();
        food.eat();
    }

}

/*
    针对简单工厂违反开闭原则的这一缺陷，工厂方法模式进行优化。
    可以看到此时再去增加产品，不再需要修改工厂类，而是增加相应的产品类和工厂类即可。这是符合开闭原则的。

    这里就会有聪明的小问号有很多朋友了：

        如果源代码作者修改相关工厂类的类名，那这时候调用工厂类的客户端代码就需要修改了，这不如简单工厂呢？
        首先这里要明确一个概念，工厂类在实际使用中，是相当于接口类的，接口类一般不允许进行修改（非必须），
        工厂类作者有责任，有义务保证工厂类的类名是稳定的，也就是说，工厂类是比产品类更加稳定的。

        既然使我们后面自己扩展的Rice类，为什么不直接实例化它，直接使用。我们就是作者，为什么不能直接使用？
        这里需要扩展一下，有时候一个产品类并不是孤立的，它和其他类一起组成一个服务框架。

    下面增加一个Supplement类进行补充：
 */