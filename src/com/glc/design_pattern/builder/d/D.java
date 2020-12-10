package com.glc.design_pattern.builder.d;

import com.glc.design_pattern.builder.a.Computer;


//建造者模式
/*=============服务端==========================*/
interface ComputerBuilder {
    Computer getComputer();

    void setCpu();

    void setGpu();

    void setHd();

    void setRAM();
}

class HighComputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();

    @Override
    public Computer getComputer() {
        return computer;
    }

    @Override
    public void setCpu() {
        computer.setCpu("9700k");
    }

    @Override
    public void setGpu() {
        computer.setGpu("gtx2080ti");
    }

    @Override
    public void setHd() {
        computer.setHd("SSD--1T");
    }

    @Override
    public void setRAM() {
        computer.setRAM("32G");
    }
}

class High_02ComputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();

    @Override
    public Computer getComputer() {
        return computer;
    }

    @Override
    public void setCpu() {
        computer.setCpu("9600k");
    }

    @Override
    public void setGpu() {
        computer.setGpu("gtx1080ti");
    }

    @Override
    public void setHd() {
        computer.setHd("SSD--500G");
    }

    @Override
    public void setRAM() {
        computer.setRAM("16G");
    }
}

//指挥者
class Director {

    public Computer build(ComputerBuilder builder) {
        builder.setCpu();
        builder.setGpu();
        builder.setRAM();
        builder.setHd();
        return builder.getComputer();
    }
}

/*==============客户端=====================================*/
public class D {

    public static void main(String[] args) {
        Director director = new Director();

        Computer computer_01 = director.build(new HighComputerBuilder());
        Computer computer_02 = director.build(new High_02ComputerBuilder());

        System.out.println(computer_01);
        System.out.println(computer_02);
    }
}
/*
    此时在需要增加一个不同配置的A_Computer类型计算机，只需要编写一个A_Builder类实现ComputerBuilder接口，
    再传给指挥者Director进行创建即可得到一个A_Computer类型的Computer对象。符合开闭原则。

    总结一下建造者模式的优点：
        创建对象的过程保持稳定。（通过ComputerBuilder接口保持稳定
        创建过程只需要编写一次（通过实现ComputerBuilder接口的类保持稳定）
        保持扩展性，需要创建新类型的对象时，只需要创建新的Builder，再使用指挥者Director进行调用进行创建即可。
        增加指挥者Director保证步骤稳定执行，客户端不需要知道创建对象的具体步骤，符合迪米特法则。

    建造者模式和工厂模式的区别：
        工厂模式注重new一个对象就可以，是否得到了这一对象，更多地关注new的结果。
        建造者模式注重保证new的对象稳定可用，保证不出现细节缺漏，更多关注new的细节、过程。

 */
