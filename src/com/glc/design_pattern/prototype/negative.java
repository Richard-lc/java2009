package com.glc.design_pattern.prototype;

//简述：用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
/*==============服务端=======================*/
class Resume {
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
}


/*==============客户端=========================*/
public class negative {

    public static void main(String[] args) {
        Resume resume01 = new Resume();
        resume01.setName("ling001");
        resume01.setAge(20);

        System.out.println(resume01);

        Resume resume02 = new Resume();
        resume02.setName("ling002");
        resume02.setAge(23);

        System.out.println(resume02);
    }
}

/*
    复制多份简历需要一个个去new。
    咱们都是IT人士了，得专业点，重复无用功怎么能做呢？
    程序员要说最熟的，难道不是Ctrl+C+Ctrl+V吗？（手动滑稽保命）

    Java就提供了这种复制粘贴的办法，不过他有自己的名字--Clone。
*/