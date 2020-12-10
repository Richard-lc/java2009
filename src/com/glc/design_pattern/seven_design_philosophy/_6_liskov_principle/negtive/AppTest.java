package com.glc.design_pattern.seven_design_philosophy._6_liskov_principle.negtive;

//需求：将长方形的宽改成比长大 1
//在父类Rectangular下，业务场景符合逻辑。现有子类Square，替换后如何。
//反例：正方形不是长方形
class Rectangular {
    private Integer width;
    private Integer length;

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

}

class Square extends Rectangular {
    private Integer sideWidth;

    @Override
    public Integer getWidth() {
        return sideWidth;
    }

    @Override
    public void setWidth(Integer width) {
        this.sideWidth = width;
    }

    @Override
    public Integer getLength() {
        return sideWidth;
    }

    @Override
    public void setLength(Integer length) {
        this.sideWidth = length;
    }
}


class Utils {
    public void transform(Rectangular graph) {
        while (graph.getWidth() <= graph.getLength()) {
            graph.setWidth(graph.getWidth() + 1);
            System.out.println("长：" + graph.getLength() + " : " +
                    "宽：" + graph.getWidth());
        }
    }
}


public class AppTest {
    public static void main(String[] args) {
        // Rectangular graph = new Rectangular();
        Rectangular graph = new Square();
        graph.setWidth(20);
        graph.setLength(30);
        Utils utils = new Utils();
        utils.transform(graph);
    }
}


/*
    替换后运行将是无限死循环。
    要知道，在向上转型的时候，方法的调用只和new的对象有关，才会造成不同的结果。
    在使用场景下，需要考虑替换后业务逻辑是否受影响。

    由此引出里氏替换原则的使用需要考虑的条件：
        是否有is-a关系
        子类可以扩展父类的功能，但是不能改变父类原有的功能。
        这样的反例还有很多，如：鸵鸟非鸟，
        还有咱们老祖宗早就说过的的春秋战国时期--白马非马说，都是一个道理。
 */