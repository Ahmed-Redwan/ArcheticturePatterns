package com.ahmed.archeticturepatterns.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ahmed.archeticturepatterns.R;
import com.ahmed.archeticturepatterns.databinding.ActivityMainBinding;
import com.ahmed.archeticturepatterns.pogo.MovieModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MovieView {
    MoviePresenter moviePresenter;
    MovieViewModel viewModel;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.btnMVCgetData.setOnClickListener(this::onClick);
        binding.btnMVPgetData.setOnClickListener(this::onClick);
        binding.btnMVVMgetData.setOnClickListener(this::onClick);

        //implement MVVM architecture design.
        // must implement these in build.gradle(Module:ArchitecturePatterns.app):
//        def lifecycle_version = "2.3.0"
//        def arch_version = "2.1.0"
//
//        // ViewModel
//        implementation "androidx.lifecycle:lifecycle-viewmodel:$lifecycle_version"
//        // LiveData
//        implementation "androidx.lifecycle:lifecycle-livedata:$lifecycle_version"

        viewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        viewModel.mutableLiveData.observe(this, new Observer<MovieModel>() {
            @Override
            public void onChanged(MovieModel movieModel) {
                binding.textview.setText("MVVM" + movieModel.getName());
            }
        });


        //implement MVP architecture design.
        moviePresenter = new MoviePresenter(this);
    }


    //implement mvc architecture design.
    public MovieModel getMovieFromDb() {
        return new MovieModel("Cast Away", "23/3", "very Sad movie", 1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //MVC
            case R.id.btn_MVCgetData:
                binding.textview.setText("mvc" + getMovieFromDb().getName());
                break;
            //MVP
            case R.id.btn_MVPgetData:
                moviePresenter.getMovie();
                break;
            //MVVM
            case R.id.btn_MVVMgetData:
                viewModel.getMovie();
                break;
        }
    }

    //implement MVP architecture design.
    @Override
    public void onGetMovieName(MovieModel movieModel) {
        binding.textview.setText("mvp" + movieModel.getName());
    }
}