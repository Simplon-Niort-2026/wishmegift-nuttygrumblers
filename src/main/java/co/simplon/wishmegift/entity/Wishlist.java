package co.simplon.wishmegift.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "wishlist")
public class Wishlist {

    // DEFINING TABLE COLUMNS
    @Id @Column(name = "wishlist_id", nullable = false) @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wishlistId;
    
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "theme", nullable = false)
    private ThemeEnum theme;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "event_date", nullable = true)
    private Date eventDate;

    @Column(name = "for_author", nullable = false)
    private Boolean forAuthor;

    // DEFINING RELATIONS
}