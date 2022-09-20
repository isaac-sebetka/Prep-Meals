package com.techelevator.repository;

import com.techelevator.entity.Meal;
import com.techelevator.entity.Recipe;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Integer> {

    @Query(
            value="SELECT m.* FROM meal m " +
                    "JOIN users_meal mu ON m.meal_id = mu.meal_id " +
                    "WHERE mu.user_id = ?1 " +
                    "ORDER By m.meal_id DESC",
            nativeQuery=true
    )
    List<Meal> findMealsByUserId(Integer id);

    @Query(
            value="select * from meal m " +
                    "join meal_plan_meal mpm on mpm.meal_id = m.meal_id " +
                    "where mpm.meal_plan_id = ?1;",
            nativeQuery = true
    )
    List<Meal> findMealByMealPlan(Integer id);

    @Modifying
    @Transactional
    @Query(
            value="INSERT INTO users_meal (meal_id, user_id) VALUES (?1, ?2)",
            nativeQuery = true
    )
    void addMealToUser(Integer mealId, Integer userId);




}