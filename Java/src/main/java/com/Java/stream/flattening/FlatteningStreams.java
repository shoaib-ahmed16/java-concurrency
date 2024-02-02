package com.Java.stream.flattening;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FlatteningStreams {
    public static void main(String[] args){
        List<String> words = new ArrayList<>(Arrays.asList("Hello","word"));

        System.out.println("With this approach we are splitting the word in to string[]. Not a suitable approach");
        var uniqueSplit1 =words.stream()
                .map(word ->word.split(""))
                .distinct()
                .collect(toList());
        for(String[] s: uniqueSplit1){
            System.out.println(new ArrayList<>(Arrays.asList(s)));
        }

        System.out.println("With this approach we are splitting the word in to string[]. And buy pipelining .map(Array::stream) converting each String[] array into a separate stream.");
        var uniqueSplit2 =words.stream()
                .map(word ->word.split("")) // 1. Converts each word into an array of its individual letters
                .map(Arrays::stream) // 2. Makes each array into a separate stream
                .distinct()
                .collect(toList());
        for(Stream<String> s: uniqueSplit2){
            System.out.println(s.toList());
        }

        System.out.println("With this approach we are splitting the word in to string[]. And buy pipelining .flatMap(Array::stream) Flattens each generated stream into a single stream");
        List<String> uniqueCharacters =
                words.stream().map(word -> word.split(""))  //1. Converts each word into an array of its individual letters
                        .flatMap(Arrays::stream) // 2. Flattens each generated stream into a single stream
                        .distinct()
                        .collect(toList());
        for(String c: uniqueCharacters){
            System.out.println(c);
        }

        questionSolve();
    }

    public  static void questionSolve(){
        // 1. 1. Given a list of numbers, how would you return a list of the square of each number? For example, given [1, 2, 3, 4, 5] you should return [1, 4, 9, 16, 25].

        System.out.println("Answer 1: ");
        var list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));

        List<Integer> squares =list.stream().map(n->n*n).collect(Collectors.toUnmodifiableList());
        for(int s:squares){
            System.out.print(s+" ");
        }

        System.out.println("\n");
//        2. Given two lists of numbers, how would you return all pairs of numbers? For example, given a list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. For simplicity, you can represent a pair as an array with two
        System.out.println("Answer 2: ");
        List<Integer> numbs1= new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> numbs2= new ArrayList<>(Arrays.asList(3,4));

        List<int[]> pairs =numbs1.stream().flatMap(i ->numbs2.stream().map(j ->new int[]{i,j})).collect(Collectors.toUnmodifiableList());
        for (int[] pair:pairs){
            System.out.println("("+pair[0]+","+pair[1]+")");
        }

//       3. How would you extend the previous example to return only pairs whose sum is divisible by 3?
        System.out.println("Answer 3: ");
        List<int[]> pairsWithSumDivisibleBy3 =numbs1.stream()
                .flatMap(i ->   numbs2.stream()
                        .filter(j->(i+j)%3==0)
                        .map(j ->new int[]{i,j}))
                .collect(Collectors.toUnmodifiableList());
        for (int[] pair:pairsWithSumDivisibleBy3){
            System.out.println("("+pair[0]+","+pair[1]+")");
        }
    }
}
