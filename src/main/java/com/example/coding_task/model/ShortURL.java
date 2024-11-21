package com.example.coding_task.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class ShortURL {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    @Column(unique = true)
    private String shortUrl;
    @NonNull
    @Column
    private String fullUrl;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Click> clicks = newHashSet();

    public void addClick(Click click) {
        clicks.add(click.withShortURL(this));
    }
}
