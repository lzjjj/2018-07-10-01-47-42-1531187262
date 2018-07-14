package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        List<Integer> result = new ArrayList <>(  );
        int randomNumber = random.nextInt(3);
        IntStream.range(1,number/randomNumber+1)
                .boxed().sorted(Comparator.reverseOrder())
                .reduce(number,(resultNum, i)->{
           int listValue = resultNum-randomNumber;
            result.add( listValue );
            return listValue;
        });
        return result;
    }
}
