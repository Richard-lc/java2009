package com.glc.design_pattern.prototype.a;


//浅拷贝

/*==============服务端=======================*/
//实现Cloneable接口标记为可被克隆的，才能被克隆
class Resume implements Cloneable {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //重写克隆方法需要将protected修饰符改为public
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


/*==============客户端=========================*/
public class a {

    public static void main(String[] args) throws CloneNotSupportedException {
        Resume resume01 = new Resume();
        resume01.setName("ling001");
        resume01.setAge(20);

        Resume resume02 = (Resume) resume01.clone();
        resume02.setName("li666");

        System.out.println(resume01);
        System.out.println(resume02);
        //克隆出来的对象地址不一致
        System.out.println(resume01.equals(resume02));
    }
}

/*
    不需要new，只需要服务端先实现一个Cloneable，并重写clone方法即可。
    而且作用堪比new一个新的对象，因为克隆和被克隆的对象并不是同一个，equals的时候得到的是false的。

    这时候，新需求来了（这次没有产品经理，别拿刀K自己）：为简历增加一个工作经历的内容，这时候:
 */