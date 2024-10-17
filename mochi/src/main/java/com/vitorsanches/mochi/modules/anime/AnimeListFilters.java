package com.vitorsanches.mochi.modules.anime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnimeListFilters {
    private String name;
    private Double minScore;
//    private Integer genreId;
    private Set<Integer> genreIds;
}
