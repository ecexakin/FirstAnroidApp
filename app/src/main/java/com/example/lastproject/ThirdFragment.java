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


public class ThirdFragment extends Fragment {

    TextView timeTextThird;
    TextView scoreTextThird;
    int score;
    RestartActivity restartActivity;

    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
    ImageView imageView13;
    ImageView imageView14;
    ImageView imageView15;
    ImageView imageView16;
    ImageView imageView17;


    ImageView[] imageViews;

    Handler handler;
    Runnable runnable;


    public ThirdFragment() {
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
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        timeTextThird = view.findViewById(R.id.timeTextThird);
        scoreTextThird = view.findViewById(R.id.scoreTextThird);
        score=0;
        imageView15 = view.findViewById(R.id.imageView15);
        imageView16 = view.findViewById(R.id.imageView16);
        imageView17 = view.findViewById(R.id.imageView17);
        imageView10 = view.findViewById(R.id.imageView10);
        imageView11 = view.findViewById(R.id.imageView11);
        imageView12 = view.findViewById(R.id.imageView12);
        imageView13 = view.findViewById(R.id.imageView13);
        imageView14 = view.findViewById(R.id.imageView14);

        imageViews = new ImageView[]{imageView17,imageView16,imageView15,imageView14,imageView13,imageView12,imageView11,imageView10};

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
                timeTextThird.setText(" "+ millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                timeTextThird.setText("Tıme Off");
                handler.removeCallbacks(runnable);
                if (score>1){
                    NavDirections navDirections = ThirdFragmentDirections.actionThirdFragmentToFourthFragment();
                    Navigation.findNavController(view).navigate(navDirections);
                }
                else {
                    NavDirections navDirections = ThirdFragmentDirections.actionThirdFragmentToRestartFragment();
                    Navigation.findNavController(view).navigate(navDirections);
                }
            }
        }.start();

    }
    public void increaseScore(View view){
        score++;
        scoreTextThird.setText(" " + score);
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
                int i = random.nextInt(8);
                imageViews[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this,1000);

            }
        };


        handler.post(runnable);



    }

}