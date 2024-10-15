package com.vitorsanches.mochi.modules.anime;

import com.vitorsanches.mochi.exceptions.BadRequestException;
import com.vitorsanches.mochi.modules.anime.dtos.AnimeCreateDTO;
import com.vitorsanches.mochi.modules.genre.Genre;
import com.vitorsanches.mochi.modules.genre.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnimeService {
    private final AnimeRepository animeRepository;
    private final GenreService genreService;

    public Page<Anime> list(Pageable pageable) {
        return animeRepository.findAll(pageable);
    }

    public Anime create(AnimeCreateDTO animeDto) {
        List<Genre> genres = animeDto.getGenres().stream().map((Integer genreId) -> {
            Optional<Genre> genre = genreService.findById(Long.valueOf(genreId));
            if (genre.isEmpty()) {
                throw new BadRequestException(String.format("genre with id %d does not exist", genreId));
            }
            return genre.get();
        }).toList();

        Anime anime = Anime.builder()
                .name(animeDto.getName())
                .episodesCount(animeDto.getEpisodesCount())
                .genres(new HashSet<Genre>(genres))
                .score(0.0)
                .reviewsCount(0)
                .build();

        return animeRepository.save(anime);
    }
}
