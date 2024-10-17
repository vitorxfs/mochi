package com.vitorsanches.mochi.modules.anime;

import com.vitorsanches.mochi.modules.genre.Genre;
import com.vitorsanches.mochi.utils.CriteriaUtils;
import jakarta.persistence.criteria.*;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.Specification;

import javax.management.Attribute;
import java.util.HashSet;
import java.util.Set;

public class AnimeSpecification {
    public static Specification<Anime> filterBy(AnimeListFilters filters) {
        return Specification
                .where(byName(filters.getName()))
                .and(byMinScore(filters.getMinScore()))
                .and(byGenres(filters.getGenreIds()));
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

    private static Specification<Anime> byGenres(Set<Integer> genreIds) {
        return (root, query, cb) -> {
            if (genreIds == null || genreIds.isEmpty()) {
                return cb.conjunction();
            }

            Join<Anime, ?> join = CriteriaUtils.getJoin(root, "genres", JoinType.INNER);

            assert query != null;
            query.groupBy(root.get("id")).having(cb.equal(cb.count(join), genreIds.size()));

            return join.get("id").in(genreIds);
        };
    }


}
