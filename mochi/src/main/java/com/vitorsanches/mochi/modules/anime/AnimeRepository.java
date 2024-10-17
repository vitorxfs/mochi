package com.vitorsanches.mochi.modules.anime;

import jakarta.annotation.Nullable;
import lombok.NonNull;
import org.hibernate.annotations.Filter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {
    Page<Anime> findAll(@Nullable Specification<Anime> specification, @NonNull Pageable pageable);

}
