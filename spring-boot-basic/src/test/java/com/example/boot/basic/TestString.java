package com.example.boot.basic;

/**
 * @author dell
 * @date 2021/3/9
 * @description TestString
 **/
public class TestString {
    public static void main(String[] args) {
        String name = "111.jpg";
        int index = name.lastIndexOf(".");
        System.out.println(index);
        System.out.println(name.substring(3));
    }
}
