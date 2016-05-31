package net.testaholic.brewery.domain.bartender;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bartender")
public class Bartender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "bartender_name", nullable = false, length = 30, unique = true)
    private String bartenderName;

    @Column(name = "bartender_image_url", nullable = false)
    private String bartenderImageUrl;

    @Column(name = "bartender_bio", nullable = false)
    private String bartenderBio;

    @Column(name = "bartender_join_date", nullable = false)
    private String bartenderJoinDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        return "Bartender{" +
                "id=" + id +
                ", bartenderName='" + bartenderName + '\'' +
                ", bartenderImageUrl='" + bartenderImageUrl + '\'' +
                ", bartenderBio='" + bartenderBio + '\'' +
                ", bartenderJoinDate='" + bartenderJoinDate + '\'' +
                '}';
    }
}
