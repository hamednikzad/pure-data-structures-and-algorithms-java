package com.hamednikzad.main;

import com.hamednikzad.lists.ArrayList;
import com.hamednikzad.lists.List;

public class Lists {
    private static void arrayListUsage() throws Exception {
        var arrayList = new ArrayList();
        arrayList.add("Item 1");
        arrayList.add(2);

        var exist = arrayList.contains(2);
        System.out.printf("Element 2 existence: %b", exist);
    }

    private static void listUsage() throws Exception {
        var list = new List<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("List usage:");

        for (Integer i: list){
            System.out.println(i);
        }
    }

    public static void use() throws Exception {
//        arrayListUsage();
        listUsage();
    }
}
