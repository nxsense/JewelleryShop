package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

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
