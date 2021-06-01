package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * @Package: com.example.demo.controller
 * @ClassName: test
 * @Author: cuiji
 * @CreateTime: 2021/4/6 16:12
 * @Description:
 */
public class test extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "执行" + i);
        }
    }

    public static void main(String[] args) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map = new HashMap<>();
        map.put("orgId","1");
        map.put("parentId","0");
        list.add(map);

        map = new HashMap<>();
        map.put("orgId","2");
        map.put("parentId","1");
        list.add(map);

        map = new HashMap<>();
        map.put("orgId","3");
        map.put("parentId","1");
        list.add(map);

        map = new HashMap<>();
        map.put("orgId","4");
        map.put("parentId","2");
        list.add(map);

        map = new HashMap<>();
        map.put("orgId","5");
        map.put("parentId","2");
        list.add(map);

        map = new HashMap<>();
        map.put("orgId","6");
        map.put("parentId","2");
        list.add(map);

        map = new HashMap<>();
        map.put("orgId","7");
        map.put("parentId","3");
        list.add(map);

        map = new HashMap<>();
        map.put("orgId","8");
        map.put("parentId","5");
        list.add(map);

        System.out.println(list.size());
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + "执行" + i);
                }
            }
        }).start();
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "执行" + i);
        }

        new test().start();
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "执行" + i);
        }
//        Long start = System.currentTimeMillis();
//        List<String> list1 = new ArrayList<String>();
//        for (int i=0; i<10; i++){
//            list1.add(i+"");
//        }
//
//        List<String> list2 = new ArrayList<String>();
//        for (int i=20; i<25; i++){
//            list2.add(i+"");
//        }
//
//
//        //  交集
//        List<String> intersection = list2.stream().filter(item -> list1.contains(item)).collect(toList());
//        System.out.println("---交集 intersection---");
//        intersection.parallelStream().forEach(System.out :: println);
//        Long end = System.currentTimeMillis();
//
//        System.out.println("耗时:"+(end-start));
        // 差集 (list1 - list2)
//        List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(toList());
//        System.out.println("---差集 reduce1 (list1 - list2)---");
//        reduce1.parallelStream().forEach(System.out :: println);    // 并集
//        List<String> listAll = list1.parallelStream().collect(toList());
//        List<String> listAll2 = list2.parallelStream().collect(toList());
//        listAll.addAll(listAll2);
//        System.out.println("---并集 listAll---");123456
//        listAll.parallelStream().forEachOrdered(System.out :: println);
//
//        // 去重并集
//        List<String> listAllDistinct = listAll.stream().distinct().collect(toList());
//        System.out.println("---得到去重并集 listAllDistinct---");
//        listAllDistinct.parallelStream().forEachOrdered(System.out :: println);

//        System.out.println("---原来的List1---");
//        list1.parallelStream().forEachOrdered(System.out :: println);
//        System.out.println("---原来的List2---");
//        list2.parallelStream().forEachOrdered(System.out :: println);

    }

    public List<Map<String, String>> digui(List<Map<String, String>> list){
        return list;
    }
}
