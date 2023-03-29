package org.kiptoo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
    @Column(name = "address_1")
    private String address1;
    @Column(name = "address_2")
    private String address2;
    @Column(name = "city")

    private String city;
    @NotNull
    @Size(max = 10)
    @Column(name = "postcode",length = 10,nullable = false)
    private String postcode;
    @NotNull
    @Size(max = 2)
    @Column(name = "country",length = 2,nullable = false)
    private String country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getAddress1(), address.getAddress1()) && Objects.equals(getAddress2(), address.getAddress2()) && Objects.equals(getCity(), address.getCity()) && getPostcode().equals(address.getPostcode()) && getCountry().equals(address.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddress1(), getAddress2(), getCity(), getPostcode(), getCountry());
    }
}