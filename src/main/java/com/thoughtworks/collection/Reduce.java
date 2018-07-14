package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
       return arrayList.stream()
               .sorted(  )
               .skip( arrayList.size() -1 )
               .reduce(0,(result,i)->result + i);
    }

    public double getMinimum() {
        return arrayList.stream()
                .sorted()
                .limit( 1 )
                .reduce(0,(result,i)->result + i);
    }

    public double getAverage() {
        return arrayList.stream()
                .reduce( 0,(result,i)->result+i )*1.0/arrayList.size();
    }

    public double getOrderedMedian() {
        int index = arrayList.size() / 2;
        if (index % 2 == 0) {
            return arrayList.stream().skip(index - 1).limit(2).reduce(0,(result, i)->result+i)*1.0/2;
        } else {
            return arrayList.stream().skip(index).findFirst().get();
        }
    }

    public int getFirstEven() {
        return arrayList.stream().filter( i->i%2==0 ).findFirst().get();
    }

    public int getIndexOfFirstEven() {
        int firstEvent = arrayList.stream().filter(num -> num % 2 == 0).findFirst().get();
        return arrayList.indexOf(firstEvent);
    }

    public boolean isEqual(List<Integer> objectList) {
        Boolean isEqual = false;
        if (objectList.size() == arrayList.size()) {
            isEqual = IntStream.range(0, arrayList.size())
                    .allMatch(index -> arrayList.get(index) == objectList.get(index));
        }
        return isEqual;
    }

    public Double getMedianInLinkList(SingleLink<Integer> singleLink) {
        int index = arrayList.size() / 2;

        if (arrayList.size() % 2 == 0) {
            return (singleLink.getNode(index) + singleLink.getNode(index + 1)) / 2.0;
        } else {
            return Double.valueOf( singleLink.getNode(index + 1) );
        }
    }

    public int getLastOdd() {
     List<Integer> resultList = arrayList.stream().filter( i->i%2!=0 ).collect(Collectors.toList());
        return resultList.get( resultList.size()-1 );
    }

    public int getIndexOfLastOdd() {
        List<Integer> resultList = arrayList.stream().filter( i->i%2!=0 ).collect(Collectors.toList());
        return  arrayList.indexOf( resultList.get( resultList.size()-1 ) ) ;
    }
}
