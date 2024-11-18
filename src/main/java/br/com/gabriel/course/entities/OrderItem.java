package br.com.gabriel.course.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_order_item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@IdClass(OrderItemId.class)
public class OrderItem implements Serializable {

    @Id
    @ManyToOne
    @JsonBackReference
    private Order order;

    @Id
    @ManyToOne
    @JsonBackReference
    private Product product;

    private Integer quantity;
    private Double price;

    public Double getSubTotal() {
        return price * quantity;
    }
}
