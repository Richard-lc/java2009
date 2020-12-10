package com.glc.design_pattern.seven_design_philosophy._2_open_close.positive;

public class DiscountPen extends Pen {

    //用重写方法设置价格
    @Override
    public void setProd_price(double prod_price) {
        super.setProd_price(prod_price * 0.8);
    }
}