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
        Map<T, Integer> map = getMap(mergedArr);
        T value = mergedArr.get(0);
        Integer count = 0;

        for (T e : map.keySet()){
            if(map.get(e) > count){
                count = map.get(e);
                value = e;
            }
        }
            return value;
    }

    private Map<T, Integer> getMap(List<T> arr){
        Map<T, Integer> map = new HashMap<>();

        for(T each: arr){
            Integer val = map.get(each);
            map.put(each, val == null ? 1 : val + 1);
        }

        return map;
    }

    public Integer countDuplicatesInMerge(T[] arr, T val){
        Map<T, Integer> map = getMap(
                Stream.concat(Arrays.stream(arr), Arrays.stream(this.arr)).collect(Collectors.toList())
        );

        return map.get(val);
    }

    public Integer getNumberOfOccurrences(T val){
        //WHHHOOOOAAAAAA how sway ?
        return Math.toIntExact(Arrays.stream(arr).filter(x -> x == val).count());
    }

    public T[] removeValue(T val){

        List<T>arr = Arrays.stream(this.arr).collect(Collectors.toList());
        for (int i = 0; i < getNumberOfOccurrences(val); i++) {
            arr.remove(val);
        }

        T[] newArr = Arrays.copyOf(this.arr, this.arr.length - getNumberOfOccurrences(val));

        for (int i = 0; i < arr.size(); i++) {
             newArr[i] = arr.get(i);
        }
        return newArr ;
    }
}
