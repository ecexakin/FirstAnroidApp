package com.example.lastproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;


public class FourthFragment extends Fragment {

    TextView timeTextFourth;
    TextView scoreTextFourth;
    ImageView imageView22;
    ImageView imageView23;
    ImageView imageView24;
    ImageView imageView25;
    int score;
    ImageView[] imageViews;
    Handler handler;
    Runnable runnable;

    public FourthFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageView22 = view.findViewById(R.id.imageView22);
        imageView23 = view.findViewById(R.id.imageView23);
        imageView24 = view.findViewById(R.id.imageView24);
        imageView25 = view.findViewById(R.id.imageView25);

        imageViews = new ImageView[]{imageView22,imageView23,imageView24,imageView25};

        scoreTextFourth = view.findViewById(R.id.scoreTextFourth);
        timeTextFourth = view.findViewById(R.id.timeTextFourth);
        score = 0;

        for (ImageView image : imageViews){
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    increaseScore(view);
                }
            });
        }
        hideImages();
        new CountDownTimer(5000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timeTextFourth.setText("" + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                if (score>5){
                    NavDirections navDirections = FourthFragmentDirections.actionFourthFragmentToFifthFragment();
                    Navigation.findNavController(view).navigate(navDirections);
                }
                else {
                    NavDirections navDirections = FourthFragmentDirections.actionFourthFragmentToRestartActivity();
                    Navigation.findNavController(view).navigate(navDirections);
                }
            }
        }.start();

    }
    public void hideImages(){

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {

                for (ImageView image : imageViews) {
                    image.setVisibility(View.INVISIBLE);

                }

                Random random = new Random();
                int i = random.nextInt(4);
                imageViews[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this,1000);

            }
        };


        handler.post(runnable);
    }

    public void increaseScore(View view){
        score++;
        scoreTextFourth.setText(" "+ score);
    }
}