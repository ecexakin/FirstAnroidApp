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


public class SecondFragment extends Fragment {

    TextView timeTextSecond;
    TextView scoreTextSecond;
    int score;
    Button button2;
    RestartActivity restartActivity;

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
        button2 = view.findViewById(R.id.button2);

        new CountDownTimer(5000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timeTextSecond.setText("Tıme : " + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                if (score>10){
                    NavDirections navDirections = SecondFragmentDirections.actionSecondFragmentToThirdFragment();
                    Navigation.findNavController(view).navigate(navDirections);
                }
                else {
                    NavDirections navDirections = SecondFragmentDirections.actionSecondFragmentToRestartActivity();
                    Navigation.findNavController(view).navigate(navDirections);
                }
            }
        }.start();

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseScore(view);
            }
        });

    }
    public void increaseScore(View view){
        score++;
        scoreTextSecond.setText("Score" + score);
    }

}