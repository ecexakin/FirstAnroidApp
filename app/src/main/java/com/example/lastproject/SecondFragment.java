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


public class SecondFragment extends Fragment {

    TextView timeTextSecond;
    TextView scoreTextSecond;
    int score;
    Button button2;
    RestartActivity restartActivity;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;

    ImageView[] imageViews;

    Handler handler;
    Runnable runnable;

    public SecondFragment() {
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
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        timeTextSecond = view.findViewById(R.id.timeTextSecond);
        scoreTextSecond = view.findViewById(R.id.scoreTextSecond);
        score=0;
        imageView5 = view.findViewById(R.id.imageView5);
        imageView6 = view.findViewById(R.id.imageView6);
        imageView7 = view.findViewById(R.id.imageView7);
        imageView8 = view.findViewById(R.id.imageView8);
        imageView9 = view.findViewById(R.id.imageView9);

        imageViews = new ImageView[]{imageView5,imageView6,imageView7,imageView8,imageView9};
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
                timeTextSecond.setText(" " + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                timeTextSecond.setText("TIME OFF");
                handler.removeCallbacks(runnable);

                if (score>1){
                    NavDirections navDirections = SecondFragmentDirections.actionSecondFragmentToThirdFragment();
                    Navigation.findNavController(view).navigate(navDirections);
                }
                else {
                    NavDirections navDirections =SecondFragmentDirections.actionSecondFragmentToRestartFragment();
                    Navigation.findNavController(view).navigate(navDirections);
                }
            }
        }.start();



    }
    public void increaseScore(View view){
        score++;
        scoreTextSecond.setText("" + score);
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
                int i = random.nextInt(5);
                imageViews[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this,1000);

            }
        };


        handler.post(runnable);



    }

}