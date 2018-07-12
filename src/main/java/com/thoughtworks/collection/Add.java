package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        if(leftBorder>rightBorder){
            int tep = leftBorder;
            leftBorder = rightBorder;
            rightBorder =  tep;
        }
        return range(leftBorder,rightBorder).filter(i->(i%2)==0)
                .reduce(rightBorder%2==0 ? rightBorder:0,(result,j)->result+j);
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        if(leftBorder>rightBorder){
            int tep = leftBorder;
            leftBorder = rightBorder;
            rightBorder =  tep;
        }
        return range(leftBorder,rightBorder).filter(i->(i%2)!=0)
                .reduce(rightBorder%2!=0 ? rightBorder:0,(result,j)->result+j);
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().reduce(0,(result,i)->result+i*3+2);
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(i->i%2!=0?i*3+2:i).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(i->i%2!=0)
                .reduce(0,(result,j)->result + j*3+5);
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> s = arrayList.stream().filter(i->i%2==0).collect(Collectors.toList());
        double median;
        if(s.size()%2==0){
            median = (s.get( s.size()/2-1 )+s.get( s.size()/2 ))/2.0;
        } else {
            median = s.get(((s.size()-1)/2)+1)*1.0;
        }
        return median;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        List<Integer> otherList  = arrayList.stream()
                .filter( i->i %2 ==0 ).collect(Collectors.toList());
        return otherList.stream()
                .reduce(0, (result,j)-> result + j)*1.0/otherList.size();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return  arrayList.stream()
                .filter( i->i%2==0 )
                .anyMatch(j->j==specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return  arrayList.stream()
                .filter( i->i%2==0 )
                .distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> list = new ArrayList <>(  );
        List<Integer> arrayListOdd = arrayList.stream()
                .filter( i->i%2==0 )
                .sorted()
                .collect(Collectors.toList());
        List<Integer> arrayListEven = arrayList.stream()
                .filter( i->i%2!=0 )
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        arrayListOdd.addAll( arrayListEven );
        return arrayListOdd;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        return  null;
//        return arrayList.stream()
//                .map( i->(i+ (arrayList.indexOf(i) < arrayList.size() ? arrayList.get(arrayList.indexOf(i)): 0) *3)
//                .collect(Collectors.toList());
    }
}
