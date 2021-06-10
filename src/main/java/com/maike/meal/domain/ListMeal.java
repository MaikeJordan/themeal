package com.maike.meal.domain;

import java.util.ArrayList;

public class ListMeal<M> {

    private ArrayList<Meal> meals;

    public ListMeal () {
        this.meals = new ArrayList<Meal>();
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public void setMealList(ArrayList<Meal> meals) {
        this.meals = meals;
    }

}
