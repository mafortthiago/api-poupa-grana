package com.mafort.poupagrana.domain.item;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String type;
    private float value;
    private Date created_at;
    private String user_id;

    public Item(ItemResponseDTO data) {
        this.description = data.description();
        this.type = data.type();
        this.value = data.value();
        this.created_at = data.created_at();
        this.user_id = data.user_id();
    }

    public void update(ItemResponseDTO data) {
        this.description = data.description();
        this.type = data.type();
        this.value = data.value();
        this.created_at = data.created_at();
    }
}