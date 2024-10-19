package com.vitorsanches.mochi.modules.anime.dtos.mappers;

import com.vitorsanches.mochi.modules.anime.Anime;
import com.vitorsanches.mochi.modules.anime.Season;
import com.vitorsanches.mochi.modules.anime.dtos.AnimeCreateDTO;
import com.vitorsanches.mochi.modules.genre.Genre;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class AnimeCreateMapper {
    public static Anime toEntity(AnimeCreateDTO dto) {
        return Anime.builder()
            .name(dto.getName())
            .episodesCount(dto.getEpisodesCount())
            .score(0.0)
            .reviewsCount(0)
            .year(dto.getYear())
            .season(Season.valueOf(dto.getSeason()))
            .releaseDate(dto.getReleaseDate())
            .build();
    }
}
