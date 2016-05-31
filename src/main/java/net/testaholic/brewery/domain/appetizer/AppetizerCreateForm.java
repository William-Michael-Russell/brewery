package net.testaholic.brewery.domain.appetizer;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class AppetizerCreateForm {

    @NotEmpty
    private String appetizerName = "";

    @NotNull
    @NotEmpty
    private String appetizerImageUrl = "";

    @NotEmpty
    private String appetizerIngredients = "";

    public String getAppetizerName() {
        return appetizerName;
    }

    public void setAppetizerName(String appetizerName) {
        this.appetizerName = appetizerName;
    }

    public String getAppetizerImageUrl() {
        return appetizerImageUrl;
    }

    public void setAppetizerImageUrl(String appetizerImageUrl) {
        this.appetizerImageUrl = appetizerImageUrl;
    }

    public String getAppetizerIngredients() {
        return appetizerIngredients;
    }

    public void setAppetizerIngredients(String appetizerIngredients) {
        this.appetizerIngredients = appetizerIngredients;
    }

    @Override
    public String toString() {
        return "AppetizerCreateForm{" +
                "appetizerName='" + appetizerName + '\'' +
                ", appetizerImageUrl='" + appetizerImageUrl + '\'' +
                ", appetizerIngredients='" + appetizerIngredients + '\'' +
                '}';
    }
}
