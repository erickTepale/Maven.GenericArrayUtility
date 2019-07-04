package com.zipcodewilmington.arrayutility;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private T[] arr;

    public ArrayUtility(T[] arr){
        this.arr = arr;
    }

    /*
    * Merge array using streams
    * set into map with counter for how many in the list
    * iterate through map and find the most common
    * */
    public T getMostCommonFromMerge(T[] arr){
        List<T> mergedArr =  Stream.concat(Arrays.stream(arr), Arrays.stream(this.arr)).collect(Collectors.toList());

        T value = mergedArr.get(0);
        Integer count = 0;
        Map<T, Integer> map = new HashMap<>();

        for(T each: mergedArr){
            Integer val = map.get(each);
            map.put(each, val == null ? 1 : val + 1);
        }

        for (T e : map.keySet()){
            if(map.get(e) > count){
                count = map.get(e);
                value = e;
            }
        }
            return value;
    }

    public Integer countDuplicatesInMerge(T[] arr, T val){
        return null;
    }

    public Integer getNumberOfOccurrences(T val){
        //WHHHOOOOAAAAAA how sway ?
        return Math.toIntExact(Arrays.stream(arr).filter(x -> x == val).count());
    }

    public T[] removeValue(T val){
        return null;
    }
}
