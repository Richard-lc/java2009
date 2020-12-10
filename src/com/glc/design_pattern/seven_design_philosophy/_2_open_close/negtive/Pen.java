package com.glc.design_pattern.seven_design_philosophy._2_open_close.negtive;

/**
 * Pen实体类
 */
public class Pen {

    private String prod_name;//名称
    private String prod_origin;//来源
    private double prod_price;//价格

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getProd_origin() {
        return prod_origin;
    }

    public void setProd_origin(String prod_origin) {
        this.prod_origin = prod_origin;
    }

    public double getProd_price() {
        return prod_price;
    }

    public void setProd_price(double prod_price) {
        this.prod_price = prod_price * 0.8;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "prod_name='" + prod_name + '\'' +
                ", prod_origin='" + prod_origin + '\'' +
                ", prod_price=" + prod_price +
                '}';
    }
}
