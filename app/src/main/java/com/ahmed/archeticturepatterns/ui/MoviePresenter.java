package com.ahmed.archeticturepatterns.ui;


import com.ahmed.archeticturepatterns.pogo.MovieModel;

public class MoviePresenter {
    MovieView view;

    public MoviePresenter(MovieView view) {
        this.view = view;
    }


    public MovieModel getMovieFromDb() {
        return new MovieModel("Cast Away", "23/3", "very Sad movie", 1);
    }

    public void getMovie(){
        view.onGetMovieName(getMovieFromDb());
    }
}
