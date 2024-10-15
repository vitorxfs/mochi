package com.vitorsanches.mochi.modules.genre;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("genre")
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @GetMapping
    ResponseEntity<List<Genre>> list() {
        return new ResponseEntity<List<Genre>>(genreService.list(), HttpStatus.OK);
    }

}
