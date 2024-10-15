package com.vitorsanches.mochi.modules.anime.dtos;

import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnimeCreateDTO {
    @NotEmpty(message = "name cannot be empty")
    private String name;
    private Integer episodesCount;
    private List<Integer> genres;
}
