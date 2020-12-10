package com.glc.design_pattern.seven_design_philosophy._1_single_responsibility.positive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 统计文本文件中有多少个单词
 */
public class AppTest {
    public static StringBuilder loadFile(String fileLocation) throws IOException {

        //读取文件的内容
        Reader in = new FileReader("E:\\IdeaProjects\\1.txt");
        BufferedReader bufferedReader = new BufferedReader(in);

        String line = null;
        StringBuilder sb = new StringBuilder("");

        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
            sb.append(" ");
        }

        bufferedReader.close();
        return sb;
    }

    public static String[] getWords(String regex, StringBuilder sb) {
        //对内容进行分割
        return sb.toString().split(regex);
    }

    public static void main(String[] args) throws IOException {

        //读取文件的内容
        StringBuilder sb = loadFile("E:\\1.txt");

        //对内容进行分割
        String[] words = getWords("[^a-zA-Z]+", sb);

        System.out.println(words.length);
    }
}

/*
    遵守单一原则，可以给我们带来的好处是，提高了代码的可重用性，
    同时还让得到的数据不再有耦合，可以用来完成我们的个性化需求
*/