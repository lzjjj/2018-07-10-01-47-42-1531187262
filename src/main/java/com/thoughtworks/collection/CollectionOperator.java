package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        if(left<right){
            return IntStream.range( left,right+1 ).boxed().sorted().collect(Collectors.toList());
        } else {
            return IntStream.range( right,left+1 ).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        }

    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        if(left<right){
            return IntStream.range( left,right+1 ).boxed().sorted().filter( i->i%2==0 ).collect(Collectors.toList());
        } else {
            return IntStream.range( right,left+1 ).boxed().sorted(Comparator.reverseOrder()).filter( i->i%2==0 ).collect(Collectors.toList());
        }
    }

    public List<Integer> popEvenElments(int[] array) {
        return stream(array).boxed().filter( i->i%2==0 ).collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
       return  array[array.length-1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> listA =  stream(firstArray).boxed().collect(Collectors.toList());
        List<Integer> listB =  stream(secondArray).boxed().collect(Collectors.toList());
        return listA.stream().filter( i-> listB.contains( i )).collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> listA =  Arrays.stream(firstArray).collect(Collectors.toList());
        List<Integer> listB =  Arrays.stream(secondArray).collect(Collectors.toList());
        List<Integer> listC = listB.stream().filter( i-> !listA.contains( i )).collect(Collectors.toList());
        listA.addAll(listC);
        return  listA;
    }
}
