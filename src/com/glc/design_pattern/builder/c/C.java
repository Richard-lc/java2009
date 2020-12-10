package com.glc.design_pattern.builder.c;


import com.glc.design_pattern.builder.a.Computer;

/*=============服务端==========================*/
interface ComputerBuilder {
    Computer build();

    void setCpu();

    void setGpu();

    void setHd();

    void setRAM();
}

class HighComputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();

    @Override
    public Computer build() {
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
    public Computer build() {
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

/*==============客户端=====================================*/
public class C {

    public static void main(String[] args) {
        HighComputerBuilder builder_01 = new HighComputerBuilder();
        builder_01.setCpu();
        builder_01.setGpu();
        builder_01.setHd();
        builder_01.setRAM();
        Computer computer_01 = builder_01.build();

        High_02ComputerBuilder builder_02 = new High_02ComputerBuilder();
        builder_02.setCpu();
        builder_02.setGpu();
        builder_02.setHd();
        builder_02.setRAM();
        Computer computer_02 = builder_02.build();

        System.out.println(computer_01);
        System.out.println(computer_02);
    }
}
//创造了建造者接口，创建者不会再遗漏步骤。

/*
    缺陷：
    每一个builder都要自己去调用setXXX方法进行创建，造成代码重复。
    需要客户端自己执行创建步骤，建造复杂对象的时候，容易造成客户端代码臃肿，且违反迪米特法则。
    而且客户端会出现遗漏步骤的情况。又回到了原点的感觉？？？
 */
