package org.kiptoo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "order_items")
public class OrderItem  extends AbstractEntity{
    @NotNull
    @Column(name = "quantity",nullable = false)
    private Long quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Order order;

    public OrderItem(@NotNull Long quantity, Product product, Order order) {
        this.quantity = quantity;
        this.product = product;
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return getQuantity().equals(orderItem.getQuantity()) && Objects.equals(getProduct(), orderItem.getProduct()) && Objects.equals(getOrder(), orderItem.getOrder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuantity(), getProduct(), getOrder());
    }
}