package org.kiptoo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.kiptoo.enums.PaymentStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "payments")
public class Payment extends AbstractEntity{
    @Column(name = "paypal_payment_id")
    private String paypalPaymentId;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PaymentStatus status;
    @NotNull
    @Column(name = "amount",nullable = false)
    private BigDecimal amount;

    public Payment(String paypalPaymentId,@NotNull PaymentStatus status,@NotNull BigDecimal amount) {
        this.paypalPaymentId = paypalPaymentId;
        this.status = status;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(getPaypalPaymentId(), payment.getPaypalPaymentId()) && getStatus() == payment.getStatus() && getAmount().equals(payment.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaypalPaymentId(), getStatus(), getAmount());
    }
}