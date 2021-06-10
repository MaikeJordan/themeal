package com.maike.meal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.LinkedHashMap;
import java.util.List;

import com.maike.meal.controller.MainController;
import com.maike.meal.domain.ListMeal;
import com.maike.meal.domain.Meal;
import com.maike.meal.service.JsonParsingService;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@WebMvcTest(MainController.class)
public class MealTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private JsonParsingService service;

  @BeforeEach
  public void setup () {
    RestAssuredMockMvc.standaloneSetup(this.service);
  }

  @Test
  public void testVerifyContructorObject () {
    ListMeal listMeal = new ListMeal();
    assertNotNull(listMeal.getMeals());
  }

  @Test
  public void testServiceNotNull () {
    Object obj = service.parse("https://www.themealdb.com/api/json/v1/1/search.php?s=");
    assertNotNull(obj);
  }

}
