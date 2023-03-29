package org.kiptoo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.kiptoo.enums.OrderStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "orders")
public class Order extends AbstractEntity {
    @NotNull
    @Column(name = "total_price",precision = 10,scale = 2,nullable = false)
    private BigDecimal price;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private OrderStatus status;
    @Column(name = "shipped")

    private ZonedDateTime shipped;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(unique = true)
    private Payment payment;
    @Embedded
    private  Address shipmentAddress;
    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private Set<OrderItem> orderItems;
    @OneToOne
    private Cart cart;

    public Order(@NotNull BigDecimal price,@NotNull OrderStatus status, ZonedDateTime shipped, Payment payment, Address shipmentAddress, Set<OrderItem> orderItems, Cart cart) {
        this.price = price;
        this.status = status;
        this.shipped = shipped;
        this.payment = payment;
        this.shipmentAddress = shipmentAddress;
        this.orderItems = orderItems;
        this.cart = cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return getPrice().equals(order.getPrice()) && getStatus() == order.getStatus() && Objects.equals(getShipped(), order.getShipped()) && Objects.equals(getPayment(), order.getPayment()) && Objects.equals(getShipmentAddress(), order.getShipmentAddress()) && Objects.equals(getOrderItems(), order.getOrderItems()) && Objects.equals(getCart(), order.getCart());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrice(), getStatus(), getShipped(), getPayment(), getShipmentAddress(), getOrderItems(), getCart());
    }
}