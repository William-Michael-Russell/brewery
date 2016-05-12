package net.testaholic.brewery.domain.drink;

import javax.persistence.*;

@Entity
@Table(name = "drink")
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "drink_name", nullable = false, length = 30, unique = true)
    private String drinkName;

    @Column(name = "drink_image_url", nullable = false)
    private String drinkImageUrl;

    @Column(name = "drink_ingredients", nullable = false)
    private String drinkIngredients;

    public Long getId() {
        return id;

    }
    public void setId(Long id) {
        this.id = id;
    }

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
        return "Drink{" +
                "id=" + id +
                ", drinkName='" + drinkName + '\'' +
                ", drinkImageUrl='" + drinkImageUrl + '\'' +
                ", drinkIngredients='" + drinkIngredients + '\'' +
                '}';
    }
}
