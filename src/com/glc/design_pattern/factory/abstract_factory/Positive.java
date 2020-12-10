package com.glc.design_pattern.factory.abstract_factory;

/*===============服务端======================*/

//-----------------------产品--------------------
/*----------------螺丝---------------------*/
interface Screw {
    void createScrew();
}

class Screw_06 implements Screw {
    @Override
    public void createScrew() {
        System.out.println("create Screw_06 666666。。。。。");
    }
}

class Screw_08 implements Screw {
    @Override
    public void createScrew() {
        System.out.println("create Screw_08 8888888。。。。。");
    }
}

/*----------------螺母---------------------*/
interface Nut {
    void createNut();
}

class Nut_06 implements Nut {
    @Override
    public void createNut() {
        System.out.println("create Nut_06 666666。。。。。");
    }
}

class Nut_08 implements Nut {
    @Override
    public void createNut() {
        System.out.println("create Nut_08 8888888。。。。。");
    }
}


//--------------------------工厂-----------------------
interface ComponentsFactory {
    Screw getScrew();

    Nut getNut();
}

/*----------------6号工厂---------------------*/
class Factory_666 implements ComponentsFactory {

    @Override
    public Screw getScrew() {
        return new Screw_06();
    }

    @Override
    public Nut getNut() {
        return new Nut_06();
    }
}

/*----------------8号工厂---------------------*/
class Factory_888 implements ComponentsFactory {

    @Override
    public Screw getScrew() {
        return new Screw_08();
    }

    @Override
    public Nut getNut() {
        return new Nut_08();
    }
}

//------------------------产品质检流程-----------------------、
class QualityInspection {

    public void checking(ComponentsFactory Factory) {
        System.out.println("我是人肉质检员。。。。。等待产出零件 -_- ");
        Screw screw = Factory.getScrew();
        Nut nut = Factory.getNut();
        screw.createScrew();
        nut.createNut();
        System.out.println("开始质检.......");
        System.out.println("      ");
    }
}

/*=================客户端===================*/
public class Positive {

    public static void main(String[] args) {
        ComponentsFactory Factory01 = new Factory_666();
        ComponentsFactory Factory02 = new Factory_888();

        QualityInspection inspection = new QualityInspection();
        inspection.checking(Factory01);
        inspection.checking(Factory02);
    }
}

/*
    可以看到，如果在需要进行一种N号螺丝或者螺母的扩展，
    只需要增加一个实现N号螺丝或者螺母接口的产品类，利用一个新增N号工厂进行创建即可。
 */