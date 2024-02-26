package com.phat_store_mvc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "model")
    private String model;

    @Column(name = "color")
    private String color;

    @Column(name = "amount", nullable = false)
    private int amount;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

//    public Item(String madel, Brand brand, Category category) {
//        this.model = madel;
//        this.brand = brand;
//        this.category = category;
//    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", brand=" + brand.getName() +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", category=" + category.getName() +
                ", amount=" + amount +
                '}';
    }
}
