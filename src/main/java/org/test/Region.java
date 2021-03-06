package org.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.eclipse.persistence.annotations.PrivateOwned;

@Entity
@Table(name = "Region")
public class Region extends AbstractTimestampEntity implements Serializable {

    private static final long serialVersionUID = -6174866486503922786L;

    @NotNull
    @Size(max = 5)
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "region", cascade = { CascadeType.ALL })
    @PrivateOwned
    private List<MultiComponentPojo> pojos = new ArrayList<>();

    public Region() {
        super();
    }

    public Region(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MultiComponentPojo> getPojos() {
        return pojos;
    }

    public void setPojos(List<MultiComponentPojo> pojos) {
        this.pojos = pojos;
    }

    @Override
    public String toString() {
        return getName();
    }

}
