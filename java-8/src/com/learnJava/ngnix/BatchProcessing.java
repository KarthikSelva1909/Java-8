package com.learnJava.ngnix;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class BatchProcessing {

    public static void main(String[] args) {

        List<Integer>  intList = Arrays.asList(1,2,3,4,5);
        int BATCH = 3;
        IntStream.range(0, (intList.size()+BATCH-1)/BATCH)
                .mapToObj(i -> intList.subList(i*BATCH, Math.min(intList.size(), (i+1)*BATCH)))
                .forEach(batch -> process(batch));

    }

    private static void process(List<Integer> batch) {

        System.out.println("============" + batch);
    }
}
