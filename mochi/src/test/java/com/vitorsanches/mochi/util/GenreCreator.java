package com.vitorsanches.mochi.util;

import com.vitorsanches.mochi.modules.genre.Genre;

public class GenreCreator {
    public static Genre createGenreToBeSaved() {
        return Genre.builder().name("Fantasy").build();
    }

    public static Genre createValidGenre() {
        return Genre.builder().name("Fantasy").id(1L).build();
    }

    public static Genre createUpdatedGenre() {
        return Genre.builder().name("Fantasy").id(1L).build();
    }
}
