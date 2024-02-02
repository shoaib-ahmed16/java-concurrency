package com.Java.stream.reducer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceMaxAndMin {
    public static  void main(String[] args){
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,-19,19,100,234,21,32,432,-90,0,-7,-1));

        System.out.println("Printing the smallest/Minimum Number in the List using numbers.stream().reduce() method of stream");
        int minimumNumber = numbers.stream().reduce(Integer.MAX_VALUE,(a, b) -> Math.min(a, b)); // with initial value.
        Optional<Integer> minimumNumber2 = numbers.stream().reduce(Integer::min); // without initial value but have to use Optional class to check if value exist in the list or not.
        System.out.println("Minimum Number is :"+minimumNumber);
        if ((minimumNumber2.isPresent())) {
            System.out.println("Minimum Number is:"+minimumNumber2.get());
        } else {
            System.out.println("Numbers List is empty");
        }

        System.out.println("Printing the Largest/Maximum Number in the List using numbers.stream()  .reduce() method of stream");
        int maximumNumber = numbers.stream().reduce(Integer.MIN_VALUE,(a, b) -> Math.max(a, b)); // with initial value.
        Optional<Integer> maximumNumber2 = numbers.stream().reduce(Integer::max); // without initial value but have to use Optional class to check if value exist in the list or not.
        System.out.println("Maximum Number is :"+maximumNumber);
        if ((maximumNumber2.isPresent())) {
            System.out.println("Maximum Number is:"+maximumNumber2.get());
        } else {
            System.out.println("Numbers List is empty");
        }

        System.out.println("How would you count the number of numbers in the List numbers in a stream using the map and reduce methods?");
        int countNumbers = numbers.stream().map(c->1).reduce(0,(a,b)->a+b);
        System.out.println(countNumbers);

        //A chain of map and reduce is commonly known as the map-reduce pattern,
    }
}
