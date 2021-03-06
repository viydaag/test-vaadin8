package org.test;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "User")
@NamedQuery(name = User.findByUsername, query = "SELECT u FROM User u WHERE u.username = :username")
public class User extends AbstractTimestampEntity implements Serializable {

    private static final long serialVersionUID = -8735932805533401960L;

    public static final String findByUsername = "User.findByUsername";

    public enum UserStatus {
        WAITING_FOR_APPROBATION("En attente"), ACTIVE("Actif"), INACTIVE("Désactivé");

        private String value;

        private UserStatus(String name) {
            this.value = name;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return getValue();
        }
    };

    @NotNull
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private AccessRole role;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$", message="Doit suivre le pattern \"aaaa@domaine.xxx\"")
    @Column(name = "email", nullable = false)
    private String email;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = false)
    private UserStatus status;

    public User() {
        super();
    }

    public User(String username, String password, AccessRole role, String name, String email, UserStatus status) {
        this();
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.email = email;
        this.status = status;
    }

    public User(String username) {
        this();
        this.username = username;
        this.password = "";
        this.status = UserStatus.ACTIVE;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccessRole getRole() {
        return role;
    }

    public void setRole(AccessRole role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public boolean isActive() {
        return getStatus() == UserStatus.ACTIVE;
    }

    public boolean isAdmin() {
        return getRole().getName().equals("administrator");
    }

    public boolean isInactive() {
        return getStatus() == UserStatus.INACTIVE;
    }

    @Override
    @PrePersist
    protected void onCreate() {
        super.onCreate();
        this.status = UserStatus.WAITING_FOR_APPROBATION;
    }
}
