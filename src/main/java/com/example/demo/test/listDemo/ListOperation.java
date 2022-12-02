package com.example.demo.test.listDemo;

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.Collections;
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

        List<String> list = new ArrayList();

        list.add("a");

        list.add("b");

        list.add("c");

        list.add("d");

        list.add("e");

        list.add("f");

        list.add("g");

        for (String e : list) {

            System.out.print(e + " ");

        }

        System.out.println("");

        // 将第一个元素与第三个元素调换

        // CollectionsUtil.swap1(list, 0, 2);

        //CollectionsUtil.swap2(list, 0, 2);

        // 将第三个元素与第一个元素调换

        //CollectionsUtil.swap1(list, 2, 0);

        swap2(list, 6, 0);

        for (String e : list) {

            System.out.print(e + " ");

        }

        System.out.println("");



//        Long start = System.currentTimeMillis();
//
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
//        //  交集
//        List<String> intersection = list2.stream().filter(item -> list1.contains(item)).collect(toList());
//        System.out.println("---交集 intersection---");
//        intersection.parallelStream().forEach(System.out :: println);
//        Long end = System.currentTimeMillis();
//
//        System.out.println("耗时:"+(end-start));
//        // 差集 (list1 - list2)
//        List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(toList());
//        System.out.println("---差集 reduce1 (list1 - list2)---");
//        reduce1.parallelStream().forEach(System.out :: println);    // 并集
//        List<String> listAll = list1.parallelStream().collect(toList());
//        List<String> listAll2 = list2.parallelStream().collect(toList());
//        listAll.addAll(listAll2);
//        System.out.println("---并集 listAll---");
//        listAll.parallelStream().forEachOrdered(System.out :: println);
//
//        // 去重并集
//        List<String> listAllDistinct = listAll.stream().distinct().collect(toList());
//        System.out.println("---得到去重并集 listAllDistinct---");
//        listAllDistinct.parallelStream().forEachOrdered(System.out :: println);
//
//        System.out.println("---原来的List1---");
//        list1.parallelStream().forEachOrdered(System.out :: println);
//        System.out.println("---原来的List2---");
//        list2.parallelStream().forEachOrdered(System.out :: println);
    }

    /**

     * 调换集合中两个指定位置的元素, 若两个元素位置中间还有其他元素，需要实现中间元素的前移或后移的操作。

     * @param list 集合

     * @param oldPosition 需要调换的元素

     * @param newPosition 被调换的元素

     * @param

     */

    public static void swap1(List list, int oldPosition, int newPosition){

        if(null == list){

            throw new IllegalStateException("The list can not be empty...");

        }

        T tempElement = (T) list.get(oldPosition);

        // 向前移动，前面的元素需要向后移动

        if(oldPosition < newPosition){

            for(int i = oldPosition; i < newPosition; i++){

                list.set(i, list.get(i + 1));

            }

            list.set(newPosition, tempElement);

        }

        // 向后移动，后面的元素需要向前移动

        if(oldPosition > newPosition){

            for(int i = oldPosition; i > newPosition; i--){

                list.set(i, list.get(i - 1));

            }

            list.set(newPosition, tempElement);

        }

    }

    /**

     * 调换集合中两个指定位置的元素, 若两个元素位置中间还有其他元素，需要实现中间元素的前移或后移的操作。

     * @param list 集合

     * @param oldPosition 需要调换的元素

     * @param newPosition 被调换的元素

     * @param

     */

    public static void swap2(List list, int oldPosition, int newPosition){
        if(null == list){
            throw new IllegalStateException("The list can not be empty...");
        }
        // 向前移动，前面的元素需要向后移动
        if(oldPosition < newPosition){
            for(int i = oldPosition; i < newPosition; i++){
                Collections.swap(list, i, i + 1);
            }
        }
        // 向后移动，后面的元素需要向前移动
        if(oldPosition > newPosition){
            for(int i = oldPosition; i > newPosition; i--){
                Collections.swap(list, i, i - 1);
            }
        }
    }
}
