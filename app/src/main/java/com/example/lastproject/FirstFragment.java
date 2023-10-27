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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class FirstFragment extends Fragment {


    int score;
    TextView timeText;
    TextView scoreText;

    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;

    ImageView[] imageViews;

    Handler handler;
    Runnable runnable;


    public FirstFragment() {
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
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        timeText = view.findViewById(R.id.timeText);
        //button = view.findViewById(R.id.button);
        score=0;
        scoreText = view.findViewById(R.id.scoreText);
        imageView = view.findViewById(R.id.imageView);
        imageView2 = view.findViewById(R.id.imageView2);
        imageView3 = view.findViewById(R.id.imageView3);
        imageView4 = view.findViewById(R.id.imageView4);



        imageViews = new ImageView[]{imageView,imageView2,imageView3,imageView4};

        for (ImageView image : imageViews){
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    increaseScore(view);
                }
            });
        }
        hideImages();
        new CountDownTimer(3000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timeText.setText(" " + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                timeText.setText("TIME OFF");
                handler.removeCallbacks(runnable);
                if (score>1){
                    NavDirections navDirections = FirstFragmentDirections.actionFirstFragmentToSecondFragment();
                    Navigation.findNavController(view).navigate(navDirections);
                }
                else {
                    NavDirections navDirections = FirstFragmentDirections.actionFirstFragmentToRestartFragment();
                    Navigation.findNavController(view).navigate(navDirections);
                }
            }
        }.start();



    }
    public void increaseScore(View view){
        score++;
        scoreText.setText(" " + score);
    }
    public void hideImages() {

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
}