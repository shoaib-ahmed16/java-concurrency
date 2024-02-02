package com.Java.stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args){
        // List of Dishes with calories details
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        // Filtering the specialMenu and obtaining new list of dishes with calories value less than 320.
        List<Dish> filteredMenu
                = specialMenu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .collect(toList());

        // Printing the result.
        for(Dish d:filteredMenu){
            System.out.println(d.getDishName()+" : "+d.getCalories());
        }

        // Use case of takeWhile when we have sorted list on th bases of clories in this case according to the condition define in the filter
        // we will take all values whose values meeting the condition once the condition is failed then we truncate the stream and stop the process.
        List<Dish> slicedMenu1
                = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .skip(1)
                .collect(toList());

        System.out.println("Printing the result after using takeWhile");
        for(Dish d:slicedMenu1){
            System.out.println(d.getDishName()+" : "+d.getCalories());
        }

        List<Dish> slicedMenu2
                = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .skip(1) // skip first element meet the above condition
                .limit(2) // add the element to the list which is continues after the skipped element
                .collect(toList());

        System.out.println("Printing the result after using dropWhile");
        for(Dish d:slicedMenu2){
            System.out.println(d.getDishName()+" : "+d.getCalories());
        }



    }
}

