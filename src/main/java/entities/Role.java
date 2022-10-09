package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * User roles
 *
 * @author author
 * @version 1.0
 */
@Entity
@Table(name = "roles")
@Data
public class Role {
    @Id
    int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;
}