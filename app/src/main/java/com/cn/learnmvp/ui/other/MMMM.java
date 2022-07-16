package com.cn.learnmvp.ui.other;

/**
 * description: none
 *
 * @author yan.w.s@qq.com
 * time: 2022/7/16
 * version: 1.0
 * update: none
 */
public class MMMM {

    public static void main(String[] args) {
        Student student = new Student(18, "aaa");
        Student stu = student;
        student.name = "bbb";
        System.out.println(stu.name);
    }

    static class Student {
        public int age;
        public String name;

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
