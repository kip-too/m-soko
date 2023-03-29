package org.kiptoo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.kiptoo.enums.ProductStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "products")
public class Product extends AbstractEntity{
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;
    @NotNull
    @Column(name = "description", nullable = false)
    private String description;
    @NotNull
    @Column(name = "price",precision = 10,scale = 2,nullable = false)
    private BigDecimal price;
    @NotNull
    @Column(name = "status",nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductStatus status;
    @Column(name = "sales_counter")
    private Integer salesCounter;
    @OneToMany(fetch =FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinTable(name = "products_reviews", joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name="reviews_id")
    )
    @ToString.Exclude
    private Set<Review> reviews = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(@NotNull String name,@NotNull String description,@NotNull BigDecimal price,@NotNull ProductStatus status, Integer salesCounter, Set<Review> reviews, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = status;
        this.salesCounter = salesCounter;
        this.reviews = reviews;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getName().equals(product.getName()) && getDescription().equals(product.getDescription()) && getPrice().equals(product.getPrice()) && getStatus() == product.getStatus() && Objects.equals(getSalesCounter(), product.getSalesCounter()) && Objects.equals(getReviews(), product.getReviews()) && Objects.equals(getCategory(), product.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getPrice(), getStatus(), getSalesCounter(), getReviews(), getCategory());
    }
}