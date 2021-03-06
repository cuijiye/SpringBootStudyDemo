package com.example.demo.test.listDemo;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @Package: com.example.demo.test.listDemo
 * @ClassName: ListOperation
 * @Author: cuiji
 * @CreateTime: 2021/6/1 16:27
 * @Description:
 */
public class ListOperation {

    public static void main(String[] args) {

        Long start = System.currentTimeMillis();

        List<String> list1 = new ArrayList<String>();
        for (int i=0; i<10; i++){
            list1.add(i+"");
        }

        List<String> list2 = new ArrayList<String>();
        for (int i=20; i<25; i++){
            list2.add(i+"");
        }

        //  交集
        List<String> intersection = list2.stream().filter(item -> list1.contains(item)).collect(toList());
        System.out.println("---交集 intersection---");
        intersection.parallelStream().forEach(System.out :: println);
        Long end = System.currentTimeMillis();

        System.out.println("耗时:"+(end-start));
        // 差集 (list1 - list2)
        List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(toList());
        System.out.println("---差集 reduce1 (list1 - list2)---");
        reduce1.parallelStream().forEach(System.out :: println);    // 并集
        List<String> listAll = list1.parallelStream().collect(toList());
        List<String> listAll2 = list2.parallelStream().collect(toList());
        listAll.addAll(listAll2);
        System.out.println("---并集 listAll---");
        listAll.parallelStream().forEachOrdered(System.out :: println);

        // 去重并集
        List<String> listAllDistinct = listAll.stream().distinct().collect(toList());
        System.out.println("---得到去重并集 listAllDistinct---");
        listAllDistinct.parallelStream().forEachOrdered(System.out :: println);

        System.out.println("---原来的List1---");
        list1.parallelStream().forEachOrdered(System.out :: println);
        System.out.println("---原来的List2---");
        list2.parallelStream().forEachOrdered(System.out :: println);
    }
}
