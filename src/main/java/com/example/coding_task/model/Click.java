package com.example.coding_task.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Click {
    @Id
    @GeneratedValue
    Long id;
    @NonNull
    @With
    String metadata;
    @With
    @ManyToOne(optional = false)
    ShortURL shortURL;
}
