package com.twein.thread.t2;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tweinyan on 29/03/2018.
 */
public class Demo7 {
    public int add (List<Integer> values) {
        return values.parallelStream().mapToInt(a -> a * 2).sum();
        //values.parallelStream().forEach(System.out::println);
        //return 0;
    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(10, 20, 30, 40);
        int res = new Demo7().add(values);
        System.out.println("计算的结果为：" + res);
    }

}
