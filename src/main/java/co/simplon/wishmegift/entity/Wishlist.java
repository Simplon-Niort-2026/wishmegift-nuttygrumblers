package co.simplon.wishmegift.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "wishlist")
public class Wishlist {

    // DEFINING TABLE COLUMNS
    @Id @Column(nullable = false) @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private ThemeEnum theme;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private Date eventDate;

    @Column(nullable = false)
    private Boolean forAuthor;

    // DEFINING RELATIONS
    @ManyToMany(mappedBy = "wishlistList")
    private List<User> guests = new ArrayList<>();

    @ManyToOne
    private User creator;

    @OneToMany(mappedBy = "wishlist")
    private List<Gifts> gifts = new ArrayList<>();

    // GETTERS
    public Long getWishlistId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ThemeEnum getTheme() {
        return theme;
    }

    public String getDescription() {
        return description;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public Boolean getForAuthor() {
        return forAuthor;
    }

    // SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setTheme(ThemeEnum theme) {
        this.theme = theme;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public void setForAuthor(Boolean forAuthor) {
        this.forAuthor = forAuthor;
    }
}