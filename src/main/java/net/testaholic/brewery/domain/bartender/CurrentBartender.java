package net.testaholic.brewery.domain.bartender;


public class CurrentBartender {


    private Bartender bartender;

    public CurrentBartender(Bartender bartender) {
        this.bartender = bartender;
    }

    public Bartender getBartender() {
        return bartender;
    }

    public Long getId() {
        return bartender.getId();
    }


    @Override
    public String toString() {
        return "CurrentBartender{" +
                "bartender=" + bartender +
                "} " + super.toString();
    }
}
