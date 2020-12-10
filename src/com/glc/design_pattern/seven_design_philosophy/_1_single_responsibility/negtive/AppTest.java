package com.glc.design_pattern.seven_design_philosophy._1_single_responsibility.negtive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 统计文本文件中有多少个单词
 */
public class AppTest {
    public static void main(String[] args) {

        //读取文件内容
        try {
            Reader in = new FileReader("E:\\IdeaProjects\\1.txt");
            BufferedReader bufferedReader = new BufferedReader(in);

            String line = null;
            StringBuilder sb = new StringBuilder("");

            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
                sb.append(" ");
            }

            //对内容进行分割
            String[] words = sb.toString().split("[^a-zA-Z]+");
            System.out.println(words.length);

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

/*
    上面代码违反单一职责原则，
    同一个方法我们让它去做文件读取，还让他去做内容分割；
    当有需求变更（需要更换加载文件，统计文本文件中有多少个句子）时，
    我们需要重写整个方法。
 */