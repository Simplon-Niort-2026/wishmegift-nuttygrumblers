package co.simplon.wishmegift.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Gifts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    private String link;

    private Integer wishLevel;

    @Column(nullable = false)
    private Integer price;

}
