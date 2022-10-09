package entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

/**
 * Order entity
 *
 * @author author
 * @version 1.0
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "orders")

public class Order {
    @Id
    int id;

    @Column(name = "userid")
    int userId;

    @Column(name = "itemid")
    int itemId;

    @Column(name = "completed")
    boolean completed;
}
