package net.testaholic.brewery.domain.drink;


public class CurrentDrink {

    private Drink drink;

    public CurrentDrink(Drink drink) {
        this.drink = drink;
    }

    public Drink getDrink() {
        return drink;
    }

    public Long getId() {
        return drink.getId();
    }


    @Override
    public String toString() {
        return "CurrentBartender{" +
                "drink=" + drink +
                "} " + super.toString();
    }
}
