package com.vitorsanches.mochi.util;

import com.vitorsanches.mochi.modules.anime.Anime;
import com.vitorsanches.mochi.modules.anime.dtos.AnimeCreateDTO;

import java.util.List;
import java.util.Set;

public class AnimeCreator {
    public static AnimeCreateDTO createAnimeDTO() {
        return AnimeCreateDTO.builder()
                .name("Hajime no Ipoo")
                .episodesCount(12)
                .genres(List.of(1))
                .build();
    }

    public static Anime createValidAnime() {
        return Anime.builder()
                .name("Hajime no Ipoo")
                .id(1L)
                .episodesCount(12)
                .genres(Set.of(GenreCreator.createValidGenre()))
                .build();
    }

    public static Anime createUpdatedAnime() {
        return Anime.builder().name("Hajime no Ipoo 2").id(1L).build();
    }
}
