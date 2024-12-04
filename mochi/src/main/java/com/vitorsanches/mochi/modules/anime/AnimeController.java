package com.vitorsanches.mochi.modules.anime;

import com.vitorsanches.mochi.modules.anime.dtos.AnimeCreateDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("animes")
@RequiredArgsConstructor
public class AnimeController {
    private final AnimeService animeService;

    @GetMapping
    ResponseEntity<Page<Anime>> list(Pageable pageable, AnimeListFilters filters) {
        return new ResponseEntity<Page<Anime>>(animeService.list(pageable, filters), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Anime> create(@RequestBody @Valid AnimeCreateDTO animeDto) {
        return new ResponseEntity<Anime>(animeService.create(animeDto), HttpStatus.CREATED);
    }

}
