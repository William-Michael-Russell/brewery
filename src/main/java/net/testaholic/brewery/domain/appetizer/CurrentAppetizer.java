package net.testaholic.brewery.domain.appetizer;


public class CurrentAppetizer {

    private Appetizer appetizer;

    public CurrentAppetizer(Appetizer appetizer) {
        this.appetizer = appetizer;
    }

    public Appetizer getAppetizer() {
        return appetizer;
    }

    public Long getId() {
        return appetizer.getId();
    }


    @Override
    public String toString() {
        return "CurrentAppetizer{" +
                "appetizer=" + appetizer +
                "} " + super.toString();
    }
}
