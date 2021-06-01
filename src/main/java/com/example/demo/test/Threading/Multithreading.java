package com.example.demo.test.Threading;

import com.example.demo.controller.test;

/**
 * @Package: com.example.demo.test.Multithreading
 * @ClassName: Multithreading
 * @Author: cuiji
 * @CreateTime: 2021/6/1 16:24
 * @Description:
 */
public class Multithreading extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "执行" + i);
        }
    }

    public static void main(String[] args) {
        //Main创建的新线程
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + "执行" + i);
                }
            }
        }).start();

        //执行main方法的线程
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "执行" + i);
        }

        //创建test对象执行重写的run方法
        new test().start();
    }
}
