package com.projectwork.coordinationgame.model;

import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Type;

/**
 *
 * @author antti
 */
@Entity 
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "gamedata")
    @Type(type = "text")
    private String gameDataObject;
    
    // Database relation mappings - Game belongs to multiple categories
    /*@ManyToMany
    @JoinTable(name = "game_category",
            // Junction table key names to be updated to match the created database
            // Foreign key referencing game-table primary key
            joinColumns = {@JoinColumn(name = "fk_game")},
            // Foreign key referecing category-table primary key
            inverseJoinColumns = {@JoinColumn(name = "fk_category")}
    )
    private Set<Category> categories;*/
    
    // Database relation mappings - Game has multiple presentations
    /* @OneToMany(mappedBy = "game")   // Refers to "game" field in Presentation class mapping
    private List<Presentation> presentations; */

    // Constructor used only for initializing Set of categories and List of presentations
    public Game() {
        /*this.categories = new HashSet<Category>();
        this.presentations = new ArrayList<Presentation>();*/
    }

    // getters and setters auto-generated
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGameDataObject() {
        return gameDataObject;
    }

    public void setGameDataObject(String gameDataObject) {
        this.gameDataObject = gameDataObject;
    }

    // equals and hashCode auto-generated
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.id);
        hash = 11 * hash + Objects.hashCode(this.gameDataObject);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.gameDataObject, other.gameDataObject)) {
            return false;
        }
        return true;
    }
}
