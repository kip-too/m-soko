package org.kiptoo.entities;

import io.smallrye.common.constraint.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.kiptoo.enums.CartStatus;

import javax.inject.Inject;
import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "carts")
public class Cart  extends  AbstractEntity{

    @ManyToOne
    private  Customer customer;
    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private  CartStatus status;

    public Cart(Customer customer, @NotNull CartStatus status) {
        this.customer = customer;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(getCustomer(), cart.getCustomer()) && getStatus() == cart.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomer(), getStatus());
    }
}