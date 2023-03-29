package org.kiptoo.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class Review extends  AbstractEntity{
    @NotNull
    @Column(name = "title", nullable = false)
    private String title;
    @NotNull
    @Column(name = "description",nullable = false)
    private String description;
    @NotNull
    @Column(name = "rating",nullable = false)
    private Long rating;

    public Review(@NotNull String title,@NotNull String description,@NotNull Long rating) {
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return getTitle().equals(review.getTitle()) && getDescription().equals(review.getDescription()) && getRating().equals(review.getRating());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getDescription(), getRating());
    }
}