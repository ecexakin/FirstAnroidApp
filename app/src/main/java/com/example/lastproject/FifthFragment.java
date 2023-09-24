package com.example.lastproject;

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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class FifthFragment extends Fragment {


    TextView timeTextFifth;
    TextView scoreTextFifth;
    int score;
    ImageView imageView27;
    ImageView imageView28;
    ImageView imageView29;
    ImageView imageView30;
    ImageView[] imageViews;
    Handler handler;
    Runnable runnable;

    public FifthFragment() {
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
        return inflater.inflate(R.layout.fragment_fifth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageView27 = view.findViewById(R.id.imageView27);
        imageView28 = view.findViewById(R.id.imageView28);
        imageView29= view.findViewById(R.id.imageView29 );
        imageView30  =view.findViewById(R.id.imageView30);

        imageViews = new ImageView[]{imageView29,imageView27,imageView28,imageView30};

        score = 0;
        timeTextFifth = view.findViewById(R.id.timeTextFifth);
        scoreTextFifth = view.findViewById(R.id.scoreTextFifth);

        hideImages();
        for (ImageView image : imageViews){
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    increaseScore(view);
                }
            });
        }
        new CountDownTimer(5000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timeTextFifth.setText("" + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                NavDirections navDirections = FifthFragmentDirections.actionFifthFragmentToRestartActivity();
                Navigation.findNavController(view).navigate(navDirections);
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
        scoreTextFifth.setText("" + score);
    }
}