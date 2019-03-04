package com.projectwork.coordinationgame.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
/**
 *
 * @author antti
 */
/*@Entity
@Table(name = "category")*/
public class Category {
   /* @Id
    @GeneratedValue(generator = "category_generator")
    @SequenceGenerator(
            name = "category_generator",
            sequenceName = "category_sequence",
            initialValue = 1
    )
    private Long id;
    
    @NotBlank
    @Column(name = "name")
    private String name;
    
    // Database relation mappings
    @ManyToMany(mappedBy = "game")
    private Set<Game> games;
    
    // Constructor (used only for initializing Set of games
    public Category() {
        this.games = new HashSet<Game>();
    }
    
    // Getters and setters auto-generated
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
    
    // equals and hashCode auto-generated
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.name);
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
        final Category other = (Category) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    */
}
