package com.vitorsanches.mochi.modules.anime;

import com.vitorsanches.mochi.exceptions.BadRequestException;
import com.vitorsanches.mochi.modules.anime.dtos.AnimeCreateDTO;
import com.vitorsanches.mochi.modules.anime.dtos.mappers.AnimeCreateMapper;
import com.vitorsanches.mochi.modules.genre.Genre;
import com.vitorsanches.mochi.modules.genre.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnimeService {
    private final AnimeRepository animeRepository;
    private final GenreService genreService;

    public Page<Anime> list(Pageable pageable) { return animeRepository.findAll(pageable); }

    public Page<Anime> list(Pageable pageable, AnimeListFilters filters) {
        Specification<Anime> specification = AnimeSpecification.filterBy(filters);
        return animeRepository.findAll(specification, pageable);
    }

    public Anime create(AnimeCreateDTO animeDto) {
        Anime anime = AnimeCreateMapper.toEntity(animeDto);

        List<Genre> genres = animeDto.getGenres().stream().map((Integer genreId) -> {
            Optional<Genre> genre = genreService.findById(Long.valueOf(genreId));
            if (genre.isEmpty()) {
                throw new BadRequestException(String.format("genre with id %d does not exist", genreId));
            }
            return genre.get();
        }).toList();


        anime.setGenres(new HashSet<Genre>(genres));

        return animeRepository.save(anime);
    }
}
