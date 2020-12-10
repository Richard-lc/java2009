package com.glc.design_pattern.prototype.b;


import java.io.*;
import java.util.Date;


//原型模式
/*==============服务端=======================*/
class Resume implements Cloneable, Serializable {
    private String name;
    private Integer age;
    private Date workExperience;

    public Date getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(Date workExperience) {
        this.workExperience = workExperience;
    }

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
                ", workExperience=" + workExperience +
                '}';
    }

    //浅拷贝
    /*@Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/

    //手动把浅拷贝出来的Date拿出来拷贝一份复制给拷贝出来的对象
    //问题是：如果对象中的引用类型层次很复杂，手动复制起来就非常麻烦，该怎么办？
    /*@Override
    public Object clone() throws CloneNotSupportedException {
        Resume clone = (Resume) super.clone();
        Date cloneDate = (Date) clone.getWorkExperience().clone();
        clone.setWorkExperience(cloneDate);
        return clone;
    }*/

    //通过序列化与反序列化，实现深拷贝，同时解决以上问题
    //实现Serializable接口：标记可序列化的
    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            //这样写，目标位置是写死的，与windows耦合了，无法跨平台，需要改进
            //改进思路：写到内存中
//            OutputStream out = new FileOutputStream("F:\\a.txt");
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);

            oos.writeObject(this);//序列化时，对象的所有属性层级关系会被序列化自动处理！

            oos.close();

            //从内存中取数据
            byte[] bb = out.toByteArray();
            InputStream in = new ByteArrayInputStream(bb);
//            InputStream in = new FileInputStream("F:\\a.txt");
            ObjectInputStream ois = new ObjectInputStream(in);
            Object clone = ois.readObject();
            return clone;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

/*==============客户端=========================*/

public class b {
    public static void main(String[] args) throws CloneNotSupportedException {
        Resume resume01 = new Resume();
        Date date = new Date();
        resume01.setName("ling001");
        resume01.setAge(20);
        resume01.setWorkExperience(date);

        Resume resume02 = (Resume) resume01.clone();
        resume02.getWorkExperience().setTime(0);

        //由于是浅拷贝，拷贝出来的Date类型是引用类型，所指向的地址是一致的
        //所以其中的内容也是共享的，不符合我们的需求，需要改进，应该使用深拷贝
        System.out.println(resume02);
        System.out.println(resume01);

        System.out.println(resume01.equals(resume02));
    }
}
