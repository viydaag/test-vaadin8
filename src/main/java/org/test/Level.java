package org.test;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.eclipse.persistence.annotations.Customizer;

@Entity
@Table(name = "Level")
@Customizer(OrderCustomizer.class)
public class Level implements org.test.Entity, Serializable {

    private static final long serialVersionUID = 4749488433122909200L;

    @Id
    @NotNull
    @Column(name = "id")
    private Long id; // id is the level number

    @NotNull
    @Min(value = 0)
    @Column(name = "maxExperience")
    private long maxExperience;

    @NotNull
    @Min(value = 0)
    @Column(name = "proficiencyBonus")
    private int proficiencyBonus;
    
    @Version
    @Column(name = "version")
    private int version;

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;

    public Level() {
        super();
    }

    public Level(long id, long maxExperience, int proficiencyBonus) {
        this();
        this.id = id;
        this.maxExperience = maxExperience;
        this.proficiencyBonus = proficiencyBonus;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public long getMaxExperience() {
        return maxExperience;
    }

    public void setMaxExperience(long maxExperience) {
        this.maxExperience = maxExperience;
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public void setProficiencyBonus(int proficiencyBonus) {
        this.proficiencyBonus = proficiencyBonus;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @PrePersist
    protected void onCreate() {
        updated = created = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return getId().toString();
    }

}
