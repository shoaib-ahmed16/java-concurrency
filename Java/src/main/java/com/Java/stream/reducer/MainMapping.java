package com.Java.stream.reducer;

import com.Java.stream.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainMapping {

    public static void main(String[] args) {
        // List of Dishes with calories details
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        System.out.println("Printing only the dishes name after mapping into the List<string> using stream() on List<Dish> ");
        List<String > dishesName = specialMenu.stream().map(Dish::getDishName).map(String::toUpperCase).collect(Collectors.toList());
        int i=0;
        for (String dishName:dishesName){
            System.out.println(++i +" :" +dishName);
        }

        System.out.println("Printing only the dishes name after mapping into the List<string> using stream() on List<Dish> ");
        List<Integer> dishesNameLengths = specialMenu.stream().map(Dish::getDishName).map(String::length).collect(Collectors.toList());
        for (Integer dishNameLen:dishesNameLengths){
            System.out.println(dishNameLen);
        }
    }
}
