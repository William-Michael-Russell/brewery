package net.testaholic.brewery.domain.appetizer;

import javax.persistence.*;

@Entity
@Table(name = "appetizer")
public class Appetizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "appetizer_name", nullable = false, length = 30, unique = true)
    private String appetizerName;

    @Column(name = "appetizer_image_url", nullable = false)
    private String appetizerImageUrl;

    @Column(name = "appetizer_ingredients", nullable = false)
    private String appetizerIngredients;

    public Long getId() {
        return id;

    }
    public void setId(Long id) {
        this.id = id;
    }

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
        return "Appetizer{" +
                "id=" + id +
                ", appetizerName='" + appetizerName + '\'' +
                ", appetizerImageUrl='" + appetizerImageUrl + '\'' +
                ", appetizerIngredients='" + appetizerIngredients + '\'' +
                '}';
    }
}
