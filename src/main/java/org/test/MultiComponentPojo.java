package org.test;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "MultiComponentPojo")
public class MultiComponentPojo extends AbstractTimestampEntity implements Serializable {

    private static final long serialVersionUID = 1255101517423727556L;

    public enum EnumTypeField {
        TEST1, TEST2
    };

    @NotNull
    @Size(max = 5)
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "integerField")
    private Integer integerField;

    @Column(name = "doubleField")
    private Double doubleField;

    @Column(name = "booleanField")
    private Boolean booleanField;

    @Column(name = "dateField")
    private LocalDate dateField;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "enumField")
    private EnumTypeField enumField;

    @ManyToOne
    @JoinColumn(name = "objectField")
    private Ability objectField;

    @ManyToOne
    @JoinColumn(name = "regionId")
    private Region region;

    public MultiComponentPojo() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIntegerField() {
        return integerField;
    }

    public void setIntegerField(Integer integerField) {
        this.integerField = integerField;
    }

    public Double getDoubleField() {
        return doubleField;
    }

    public void setDoubleField(Double doubleField) {
        this.doubleField = doubleField;
    }

    public Boolean getBooleanField() {
        return booleanField;
    }

    public void setBooleanField(Boolean booleanField) {
        this.booleanField = booleanField;
    }

    public LocalDate getDateField() {
        return dateField;
    }

    public void setDateField(LocalDate dateField) {
        this.dateField = dateField;
    }

    public EnumTypeField getEnumField() {
        return enumField;
    }

    public void setEnumField(EnumTypeField enumField) {
        this.enumField = enumField;
    }

    public Ability getObjectField() {
        return objectField;
    }

    public void setObjectField(Ability objectField) {
        this.objectField = objectField;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((booleanField == null) ? 0 : booleanField.hashCode());
        result = prime * result + ((dateField == null) ? 0 : dateField.hashCode());
        result = prime * result + ((doubleField == null) ? 0 : doubleField.hashCode());
        result = prime * result + ((enumField == null) ? 0 : enumField.hashCode());
        result = prime * result + ((integerField == null) ? 0 : integerField.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((objectField == null) ? 0 : objectField.hashCode());
        result = prime * result + ((region == null) ? 0 : region.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof MultiComponentPojo)) {
            return false;
        }
        MultiComponentPojo other = (MultiComponentPojo) obj;
        if (booleanField == null) {
            if (other.booleanField != null) {
                return false;
            }
        } else if (!booleanField.equals(other.booleanField)) {
            return false;
        }
        if (dateField == null) {
            if (other.dateField != null) {
                return false;
            }
        } else if (!dateField.equals(other.dateField)) {
            return false;
        }
        if (doubleField == null) {
            if (other.doubleField != null) {
                return false;
            }
        } else if (!doubleField.equals(other.doubleField)) {
            return false;
        }
        if (enumField != other.enumField) {
            return false;
        }
        if (integerField == null) {
            if (other.integerField != null) {
                return false;
            }
        } else if (!integerField.equals(other.integerField)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (objectField == null) {
            if (other.objectField != null) {
                return false;
            }
        } else if (!objectField.equals(other.objectField)) {
            return false;
        }
        if (region == null) {
            if (other.region != null) {
                return false;
            }
        } else if (!region.equals(other.region)) {
            return false;
        }
        return true;
    }

}
