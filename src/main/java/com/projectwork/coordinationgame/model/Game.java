package com.projectwork.coordinationgame.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="game_id")
    private Integer gameID;

    @Column(name = "gamedata")
    @Type(type = "text")
//    private List<Component> gameData;
    private String gameDataObject;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "games", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Presentation> presentations;
    
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name="game_category",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = 
                    {
                        @JoinColumn(name = "category_id"),
                    }
            
    )
    private Set<Category> categories;

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
    
    private boolean enabled;

    public Set<Presentation> getPresentations() {    
        return presentations;

    }

    // Database relation mappings - Game belongs to multiple categories
    public void setPresentations(Set<Presentation> presentations) {
        this.presentations = presentations;
    }

    /*@ManyToMany
    @JoinTable(name = "game_category",
    // Junction table key names to be updated to match the created database
    // Foreign key referencing game-table primary key
    joinColumns = {@JoinColumn(name = "fk_game")},
    // Foreign key referecing category-table primary key
    inverseJoinColumns = {@JoinColumn(name = "fk_category")}
    )
    private Set<Category> categories;*/
    public boolean isEnabled() {    
        return enabled;
        /*this.categories = new HashSet<Category>();
        this.presentations = new ArrayList<Presentation>();*/
    }

    // Database relation mappings - Game has multiple presentations
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /* @OneToMany(mappedBy = "game")   // Refers to "game" field in Presentation class mapping
    private List<Presentation> presentations; */
    // Constructor used only for initializing Set of categories and List of presentations
    public Game() {
    }

    // getters and setters auto-generated
    public Integer getGameID() {
        return gameID;
    }

    public void setId(Integer id) {
        this.gameID = id;
    }
    
//    public List<Component> getGameData() {
//        return gameData;
//    }
    
    public String getGameDataObject() {
        return gameDataObject;
    }
    public void setGameDataObject(String gameDataObject) {
        this.gameDataObject = gameDataObject;
    }

//    public void setGameDataObject(List<Component> gameData) {
//        this.gameData = gameData;
//    }

    // equals and hashCode auto-generated
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.gameID);
//        hash = 11 * hash + Objects.hashCode(this.gameData);
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
        if (!Objects.equals(this.gameID, other.gameID)) {
            return false;
        }
        if (!Objects.equals(this.gameDataObject, other.gameDataObject)) {
//        if (!Objects.equals(this.gameData, other.gameData)) {
            return false;
        }
        return true;
    }
}
