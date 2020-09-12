package com.akv.volume.one.ch06;

import java.util.Arrays;
import java.util.Comparator;

public class StringLengthComparatorTest {

    public static void main(String[] Args){

        StringLengthComparator slc = new StringLengthComparator();

        String[] array = {"Amit","Shubh","Prisha","Swati Srivastava"};

        Arrays.sort(array,slc);

        System.out.println(Arrays.toString(array));

    }


}


class StringLengthComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}