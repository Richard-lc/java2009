package com.glc.design_pattern.decorator;


//在装饰器模式中，违反了继承的“is a”关系和里氏替换原则（特定情况）
//尽管调料不是饮料，调料不光要继承饮料，还要关联饮料
public abstract class Condiment extends Beverage {

    protected Beverage beverage;

    public Condiment(Beverage beverage) {
        super("调料");
        this.beverage = beverage;
    }
}

class Soy extends Condiment {

    public Soy(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " 豆浆";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.3;
    }
}

class Mocha extends Condiment {

    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " moka";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.5;
    }
}

class Bubble extends Condiment {

    public Bubble(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " 泡沫";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.1;
    }
}

class Milk extends Condiment {

    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " 牛奶";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.2;
    }
}