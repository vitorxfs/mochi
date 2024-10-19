package com.vitorsanches.mochi.modules.anime;

import com.vitorsanches.mochi.modules.genre.Genre;
import com.vitorsanches.mochi.utils.validators.ValueOfEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
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

    private Integer year;

    @Enumerated(EnumType.STRING)
    private Season season;

    private Date releaseDate;

    @CreationTimestamp
    private Date createdAt;

    @CreationTimestamp
    private Date updatedAt;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Genre> genres;
}
