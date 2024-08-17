package com.apple.shop.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false) //unique = true, columnDefinition = "Text", length = 1000,,,,,,,,
    public String title;

    @Column(nullable = false)
    public Integer price;

    public Item() {}

    public Item(String title, Integer price) {
        this.title = title;
        this.price = price;
    }

    public Item(Long id, String title, Integer price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }
}
