package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

/**
 * Item entity
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
@Table(name = "items")
public class Item {

    @Id
    int id;

    @Column(name = "type")
    String type;

    @Column(name = "price")
    int price;

    @Column(name = "metal")
    String metal;

    @Column(name = "weight")
    float weight;

    @Column(name = "available")
    boolean available;
}
