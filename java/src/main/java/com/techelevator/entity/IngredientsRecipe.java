package com.techelevator.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ingredients_recipe")
public class IngredientsRecipe {
    @EmbeddedId
    private IngredientsRecipeId id;

    @MapsId("ingredientsId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ingredients_id", nullable = false)
    private Ingredient ingredients;

    @MapsId("recipeId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    public IngredientsRecipeId getId() {
        return id;
    }

    public void setId(IngredientsRecipeId id) {
        this.id = id;
    }

    public Ingredient getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient ingredients) {
        this.ingredients = ingredients;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}