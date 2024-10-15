package com.vitorsanches.mochi.modules.genre;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;

    public List<Genre> list() {
        return genreRepository.findAll();
    }

    public Optional<Genre> findById(Long id) { return genreRepository.findById(id); }
}
