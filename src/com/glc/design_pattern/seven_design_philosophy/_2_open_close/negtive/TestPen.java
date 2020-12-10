package com.glc.design_pattern.seven_design_philosophy._2_open_close.negtive;

public class TestPen {
    public static void main(String[] args) {

        //输入商品信息
        Pen redPen = new Pen();
        redPen.setProd_name("英雄牌钢笔");
        redPen.setProd_origin("厂里");
        redPen.setProd_price(15.5);
        //输出商品信息
        System.out.println(redPen);
    }
}

/*
    需求：商品搞活动，打折8折销售。

    反例：在实体类的源代码，修改 setProd_price方法

    违反了开闭原则，在源代码中修改，对显示原价这一功能进行了修改。

    在开发时，我们应该，必须去考虑可能会变化的需求，
    属性在任何时候都可能发生改变，
    对于需求的变化，在要求遵守开闭原则的前提下，
    我们应该在开发中去进行扩展，而不是修改源代码。
 */