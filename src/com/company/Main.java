package com.company;

import java.util.Comparator;

public class Main {

    /*
    public static int sum(int... arr) {
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
        }
        return s;
    }
    */

    public static void main(String[] args) {

        //sum(34, 5, 55, 5, 3);

        //MyCollection<String> cc= new MyCollection<String>(String.class);

        MyCollection<Integer> collection = new MyCollection<>(Integer.class);

        collection.add(10);
        collection.add(867);
        collection.add(3);

        for (int item : collection) {
            System.out.print(item + " ");
        }
        System.out.println();

        MyCollection<Integer> filtered = collection.getIfEqual(item -> item >= 10);

        for (int item : filtered) {
            System.out.print(item + " ");
        }
        System.out.println();

        collection.sort((a, b) -> b - a);
        /*
        collection.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        */

        for (int item : collection) {
            System.out.print(item + " ");
        }
    }
}
