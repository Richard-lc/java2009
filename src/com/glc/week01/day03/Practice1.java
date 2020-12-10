package com.glc.week01.day03;

public class Practice1 {
    public static void main(String[] args) {

        String[] student = {"张三", "李四", "王五", "赵六", "陈七"};
//        String student1 = "张三";
//        String student2 = "李四";
//        String student3 = "王五";
//        String student4 = "赵六";
//        String student5 = "陈七";
        double[] grade = {50, 60, 78, 88, 90};
//        int grade1 = 50;
//        int grade2 = 60;
//        int grade3 = 78;
//        int grade4 = 88;
//        int grade5 = 90;

        double sum = 0;
        for (int i = 0; i < grade.length; i++) {
            sum += grade[i];
        }
        double avg = sum / grade.length;
        String str = avg % 2 == 0 ? "平均成绩为偶数" : "平均成绩不为偶数";

        for (int i = 0; i < grade.length; i++) {
            System.out.println("姓名：" + student[i] + "\t成绩：" + grade[i]);
        }
//        System.out.println("姓名："+student1+"\t成绩："+grade1);
//        System.out.println("姓名："+student2+"\t成绩："+grade2);
//        System.out.println("姓名："+student3+"\t成绩："+grade3);
//        System.out.println("姓名："+student4+"\t成绩："+grade4);
//        System.out.println("姓名："+student5+"\t成绩："+grade5);

        System.out.println("==============================");
        System.out.println("平均成绩为：" + avg);
        System.out.println(str);

    }
}
