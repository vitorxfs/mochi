package com.vitorsanches.mochi.modules.anime;

import com.vitorsanches.mochi.modules.genre.Genre;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "name cannot be empty")
    private String name;

    @ColumnDefault("1")
    private Integer episodesCount;

    @ColumnDefault("0")
    private Double score;

    @ColumnDefault("0")
    private Integer reviewsCount;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Genre> genres;
}
