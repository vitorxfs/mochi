package com.vitorsanches.mochi.modules.anime;

import com.vitorsanches.mochi.exceptions.BadRequestException;
import com.vitorsanches.mochi.modules.anime.dtos.AnimeCreateDTO;
import com.vitorsanches.mochi.modules.genre.Genre;
import com.vitorsanches.mochi.modules.genre.GenreService;
import com.vitorsanches.mochi.util.AnimeCreator;
import com.vitorsanches.mochi.util.GenreCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
class AnimeServiceTest {
    @InjectMocks
    private AnimeService animeService;

    @Mock
    private AnimeRepository animeRepository;
    @Mock
    private GenreService genreService;

    @BeforeEach
    void setUp() {
        PageImpl<Anime> animePage = new PageImpl<>(List.of(AnimeCreator.createValidAnime()));
        BDDMockito.when(animeRepository.findAll(ArgumentMatchers.any(PageRequest.class))).thenReturn(animePage);
        BDDMockito.when(animeRepository.save(ArgumentMatchers.any(Anime.class)))
                .thenReturn(AnimeCreator.createValidAnime());
        BDDMockito.when(genreService.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(GenreCreator.createValidGenre()));
    }

    @Test
    @DisplayName("list should return list of anime when successful")
    void findAll() {
        Page<Anime> animePage = animeService.list(PageRequest.of(0,1));

        Assertions.assertThat(animePage).isNotNull();
        Assertions.assertThat(animePage.toList()).isNotEmpty().hasSize(1);
    }

    @Test
    @DisplayName("create should return anime when successful")
    void create() {
        AnimeCreateDTO animeDto = AnimeCreator.createAnimeDTO();
        Anime anime = animeService.create(animeDto);

        Assertions.assertThat(anime).isNotNull();
        Assertions.assertThat(anime.getGenres().iterator().next()).isNotNull().isInstanceOf(Genre.class);
    }

    @Test
    @DisplayName("create should throw BadRequestException when genre is not found")
    void createThrowsWhenGenreNotFound() {
        BDDMockito.when(genreService.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.empty());
        AnimeCreateDTO animeDto = AnimeCreator.createAnimeDTO();

        Assertions.assertThatExceptionOfType(BadRequestException.class)
                .isThrownBy(() -> animeService.create(animeDto));
    }

}