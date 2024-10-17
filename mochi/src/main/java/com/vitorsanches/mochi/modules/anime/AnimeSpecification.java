package com.vitorsanches.mochi.modules.anime;

import com.vitorsanches.mochi.modules.genre.Genre;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.Set;

public class AnimeSpecification {
    public static Specification<Anime> filterBy(AnimeListFilters filters) {
        return Specification
                .where(byName(filters.getName()))
                .and(byMinScore(filters.getMinScore()))
                .and(byGenres(filters.getGenreId()));
    }

    private static Specification<Anime> byName(String name) {
        return (root, query, cb) -> name == null || name.isEmpty()
                ? cb.conjunction()
                : cb.like(cb.lower(root.get("name")), cb.lower(cb.literal("%"+name+"%")));
    }

    private static Specification<Anime> byMinScore(Double score) {
        return (root, query, cb) -> score == null || score >= 10.0 || score <= 0
                ? cb.conjunction()
                : cb.greaterThanOrEqualTo(root.get("score"), score);
    }

    private static Specification<Anime> byGenres(Integer genreId) {
        return (root, query, cb) -> genreId == null || genreId <= 0
                ? cb.conjunction()
                : cb.equal(root.get("genres").get("id"), genreId);
    }
}
