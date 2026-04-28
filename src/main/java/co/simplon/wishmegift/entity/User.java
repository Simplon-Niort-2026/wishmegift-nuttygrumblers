package co.simplon.wishmegift.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;

    @Column(nullable = false)
    @Nonnull
    private String name;

    @Column(nullable = false)
    @Nonnull
    private String firstname;

    @Column(nullable = false)
    @Nonnull
    private String email;

    @Column(nullable = false)
    @Nonnull
    private String password;

    @OneToMany(mappedBy = "id")
    private List<Gifts> gifts;

    @ManyToMany
    @JoinTable(name="shared_wishlist",joinColumns = @JoinColumn(name="wishlist_id"), inverseJoinColumns = @JoinColumn(name="user_id"))
    private List<Wishlist> wishlistList = new ArrayList<>();


    public User(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

}
