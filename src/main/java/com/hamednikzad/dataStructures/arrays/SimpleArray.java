package com.hamednikzad.dataStructures.arrays;

public class SimpleArray {
    private static <T> void print(String title, T[] array){
        System.out.print(title + ": ");

        for (T t : array) {
            System.out.printf("%s, ", t);
        }

        System.out.println();
    }

    public static void waysToCreateAnArray(){
        var simpleArray = new String[4];
        print("simpleArray", simpleArray);

        String[] withItemsAndTypeWithoutSize = new String[] { "Item1", "Item2", "Item3", "Item4" };
        print("withItemsAndTypeWithoutSize", withItemsAndTypeWithoutSize);

        String[] withOnlyItemsWithoutType = { "Volvo", "BMW", "Ford", "Mazda" };
        print("withOnlyItemsWithoutType", withOnlyItemsWithoutType);
    }
}
