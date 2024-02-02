package com.Java.stream;

public class Dish {
    private String dishName;
    private Integer calories;
    private Type type;

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Boolean getPureVeg() {
        return pureVeg;
    }

    public void setPureVeg(Boolean pureVeg) {
        this.pureVeg = pureVeg;
    }

    public  Boolean pureVeg;

    public Dish(String dishName,boolean pureVeg,Integer calories,Type type){
        this.dishName=dishName;
        this.pureVeg =pureVeg;
        this.type=type;
        this.calories=calories;
    }

    public static enum Type{
        OTHER,
        FISH,
        MEAT;
    }
}




