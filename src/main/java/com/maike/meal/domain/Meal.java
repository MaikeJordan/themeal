package com.maike.meal.domain;

import lombok.AllArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@AllArgsConstructor
@JsonIgnoreProperties
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idMeal;
    private String nameMeal;
    private String Category;
    private String Area;
    private String Instructions;

    public Integer getIdMeal() {
        return idMeal;
    }
    public String getInstructions() {
        return Instructions;
    }
    public void setInstructions(String instructions) {
        this.Instructions = instructions;
    }
    public String getArea() {
        return Area;
    }
    public void setArea(String area) {
        this.Area = area;
    }
    public String getCategory() {
        return Category;
    }
    public void setCategory(String category) {
        this.Category = category;
    }
    public String getNameMeal() {
        return nameMeal;
    }
    public void setNameMeal(String nameMeal) {
        this.nameMeal = nameMeal;
    }
    public void setIdMeal(Integer idMeal) {
        this.idMeal = idMeal;
    }

}
