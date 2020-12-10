package com.glc.design_pattern.seven_design_philosophy._2_open_close.positive;

public class TestPen {
    public static void main(String[] args) {
        //输入商品信息，向上转型调用重写方法设置价格
        Pen redPen = new DiscountPen();
        redPen.setProd_name("英雄牌钢笔");
        redPen.setProd_origin("厂里");
        redPen.setProd_price(15.5);
        //输出商品信息
        System.out.println(redPen);
    }
}

/*
    需求：商品搞活动，打折8折销售。

    开闭原则并不是必须要一味地死守，需要结合开发场景进行使用，
    如果需要修改的源代码是自己写的，修改之后去完成需求，当然是简单快速的；
    但是如果源代码是别人写的，或者是别人的架构，修改是存在巨大风险的，
    这时候应该去遵守开闭原则，防止破坏结构的完整性。
 */