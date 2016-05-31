package net.testaholic.brewery.domain.bartender;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class BartenderCreateForm {

    @NotEmpty
    private String bartenderName = "";

    @NotNull
    @NotEmpty
    private String bartenderImageUrl = "";

    @NotEmpty
    private String bartenderBio = "";

    @NotEmpty
    private String bartenderJoinDate = "";


    public String getBartenderName() {
        return bartenderName;
    }

    public void setBartenderName(String bartenderName) {
        this.bartenderName = bartenderName;
    }

    public String getBartenderImageUrl() {
        return bartenderImageUrl;
    }

    public void setBartenderImageUrl(String bartenderImageUrl) {
        this.bartenderImageUrl = bartenderImageUrl;
    }

    public String getBartenderBio() {
        return bartenderBio;
    }

    public void setBartenderBio(String bartenderBio) {
        this.bartenderBio = bartenderBio;
    }

    public String getBartenderJoinDate() {
        return bartenderJoinDate;
    }

    public void setBartenderJoinDate(String bartenderJoinDate) {
        this.bartenderJoinDate = bartenderJoinDate;
    }


    @Override
    public String toString() {
        return "BartenderCreateForm{" +
                "bartenderName='" + bartenderName + '\'' +
                ", bartenderImageUrl='" + bartenderImageUrl + '\'' +
                ", bartenderBio='" + bartenderBio + '\'' +
                ", bartenderJoinDate='" + bartenderJoinDate + '\'' +
                '}';
    }
}
