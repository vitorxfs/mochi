package com.vitorsanches.mochi.modules.anime.dtos;

import com.vitorsanches.mochi.modules.anime.Season;
import com.vitorsanches.mochi.utils.validators.ValueOfEnum;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.bridge.Message;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnimeCreateDTO {
    @NotEmpty(message = "name cannot be empty")
    private String name;

    @NotNull(message = "episodesCount cannot be null")
    private Integer episodesCount;

    @NotNull(message = "year cannot be null")
    @Min(value=1900, message="year has to be greater than 1900")
    private Integer year;

    @NotNull(message = "season cannot be null")
    @ValueOfEnum(enumClass = Season.class)
    private String season;

    @NotNull(message = "releaseDate cannot be null")
    private Date releaseDate;

    private List<Integer> genres;
}
