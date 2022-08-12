package com.example.pruebatv3;

import java.util.ArrayList;
import java.util.List;

public final class MovieList {
    public static ArrayList<android.graphics.Movie> list;
    private static Movie buildMovieInfo(
            String categoria,
            String titulo,
            String descripcion,
            String videoUrl,
            String poster
    ){
        Movie movie=new Movie();
        movie.setTitulo(titulo);
        movie.setDescripcion(descripcion);
        movie.setCategoria(categoria);
        movie.setVideoUrl(videoUrl);
        movie.setPoster(poster);
        return movie;
    }
}