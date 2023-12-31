package com.example.lastproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lastproject.databinding.ActivityRestartBinding;

public class RestartActivity extends AppCompatActivity {
    private ActivityRestartBinding binding;
    Button restartButton;
    FirstFragment firstFragment;
    SecondFragment secondFragment;
    Button homeButton;

    ThirdFragment thirdFragment;
    FourthFragment fourthFragment;
    FifthFragment fifthFragment;
    Fragment fragment;
    HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityRestartBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        restartButton = view.findViewById(R.id.restart);
        homeButton = view.findViewById(R.id.homeButton);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restart(view,fragment);
            }
        });
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               home(v);
            }
        });

    }

    public void restart(View view, Fragment fragment){
        if (fragment ==firstFragment ){
            Intent intent = new Intent(this , FirstFragment.class);
            startActivity(intent);
            finish();
        } else if (fragment==secondFragment) {
            Intent intent = new Intent(this,SecondFragment.class);
            startActivity(intent);
            finish();
        }
        else if (fragment==thirdFragment){
            Intent intent = new Intent(this,ThirdFragment.class);
            startActivity(intent);
            finish();
        } else if (fragment==fourthFragment) {
            Intent intent = new Intent(this,FourthFragment.class);
            startActivity(intent);
            finish();

        } else if (fragment==fifthFragment) {
            Intent intent = new Intent(this,FifthFragment.class);
            startActivity(intent);
            finish();
        }

    }

    public void home(View v){
        Intent intent2 = new Intent(this,HomeFragment.class);
        startActivity(intent2);
        finish();
    }

}