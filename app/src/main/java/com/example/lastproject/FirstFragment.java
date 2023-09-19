package com.example.lastproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FirstFragment extends Fragment {

    Button button;
    int score;
    TextView timeText;
    TextView scoreText;

    RestartActivity restartActivity;


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
        button = view.findViewById(R.id.button);
        score=0;
        scoreText = view.findViewById(R.id.scoreText);


        new CountDownTimer(5000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timeText.setText("Time : " + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                if (score>5){
                    NavDirections navDirections = FirstFragmentDirections.actionFirstFragmentToSecondFragment();
                    Navigation.findNavController(view).navigate(navDirections);
                }
                else {
                    NavDirections navDirections = FirstFragmentDirections.actionFirstFragmentToRestartActivity();
                    Navigation.findNavController(view).navigate(navDirections);
                }
            }
        }.start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               increaseScore(view);
            }
        });


    }
    public void increaseScore(View view){
        score++;
        scoreText.setText("Score : " + score);
    }


}