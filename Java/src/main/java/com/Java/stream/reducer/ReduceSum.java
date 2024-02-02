package com.Java.stream.reducer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceSum {
    public static  void main(String[] args){
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        System.out.println("Printing the sum of n numbers from 1 to 10 using reduce() method of stream()");
        int numbersSum= numbers.stream().reduce(0,(a,b)->a+b);

        Optional<Integer> numbersSum2=numbers.stream().reduce(Integer::sum); // if don't want to provide the initial value.
        System.out.println(numbersSum);
        if ((numbersSum2.isPresent())) {
            System.out.println(numbersSum2.get());
        } else {
            System.out.println("Numbers List is empty");
        }
        System.out.println("Printing the multiplication of n numbers from 1 to 10 using reduce() method of stream()");
        int numbersMultiplication= numbers.stream().reduce(1,(a,b)->a* b);
        System.out.println(numbersMultiplication);

    }
}
