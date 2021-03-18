package com.ahmed.archeticturepatterns.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ahmed.archeticturepatterns.pogo.MovieModel;

public class MovieViewModel extends ViewModel {
    MutableLiveData<MovieModel>mutableLiveData=new MutableLiveData<>();


    public void getMovie(){
        MovieModel movieModel=getMovieFromDb();
        mutableLiveData.setValue(movieModel);
    }
    private MovieModel getMovieFromDb() {
        return new MovieModel("Cast Away", "23/3", "very Sad movie", 1);
    }

}
