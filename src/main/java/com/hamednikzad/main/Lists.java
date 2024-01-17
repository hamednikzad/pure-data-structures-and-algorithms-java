package com.hamednikzad.main;

import com.hamednikzad.lists.ArrayList;

public class Lists {
    private static void arrayListUsage() throws Exception {
        var arrayList = new ArrayList();
        arrayList.add("Item 1");
        arrayList.add(2);

        var exist = arrayList.contains(2);
        System.out.printf("Element 2 existence: %b", exist);
    }

    public static void use() throws Exception {
        arrayListUsage();
    }
}
