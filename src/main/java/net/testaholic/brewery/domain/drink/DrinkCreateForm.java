package net.testaholic.brewery.domain.drink;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class DrinkCreateForm {

    @NotEmpty
    private String drinkName = "";

    @NotNull
    @NotEmpty
    private String drinkImageUrl = "";

    @NotEmpty
    private String drinkIngredients = "";

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getDrinkImageUrl() {
        return drinkImageUrl;
    }

    public void setDrinkImageUrl(String drinkImageUrl) {
        this.drinkImageUrl = drinkImageUrl;
    }

    public String getDrinkIngredients() {
        return drinkIngredients;
    }

    public void setDrinkIngredients(String drinkIngredients) {
        this.drinkIngredients = drinkIngredients;
    }

    @Override
    public String toString() {
        return "DrinkCreateForm{" +
                "drinkName='" + drinkName + '\'' +
                ", drinkImageUrl='" + drinkImageUrl + '\'' +
                ", drinkIngredients='" + drinkIngredients + '\'' +
                '}';
    }
}
