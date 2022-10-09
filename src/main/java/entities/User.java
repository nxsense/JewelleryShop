package entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * User entity
 *
 * @author author
 * @version 1.0
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    Long id;

    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "surname", nullable = false)
    String surname;
    @Column(name = "email", nullable = false, unique = true)
    String email;
    @Column(name = "password", nullable = false)
    String password;
    @Column(name = "username", nullable = false, unique = true)
    String username;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "roleid", referencedColumnName = "id")})
    private List<Role> roles;
}
