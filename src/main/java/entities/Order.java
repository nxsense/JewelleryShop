package entities;


import jakarta.persistence.*;
import lombok.*;

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
