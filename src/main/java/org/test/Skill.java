package org.test;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Skill")
public class Skill extends AbstractTimestampEntity implements Serializable {

    private static final long serialVersionUID = -2967904843715939261L;

    @NotNull
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "shortDescription")
    private String shortDescription;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "keyAbilityId", nullable = false)
    private Ability keyAbility;


    public Skill() {
        super();
    }

    public Skill(String name, Ability ability) {
        this();
        this.name = name;
        this.keyAbility = ability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Ability getKeyAbility() {
        return keyAbility;
    }

    public void setKeyAbility(Ability keyAbility) {
        this.keyAbility = keyAbility;
    }

    @Override
    public String toString() {
        return getName();
    }

}
