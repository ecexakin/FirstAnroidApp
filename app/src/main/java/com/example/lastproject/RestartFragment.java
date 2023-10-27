package com.example.lastproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class RestartFragment extends Fragment {

    Button restartsec;
    FirstFragment firstFragment;
    SecondFragment secondFragment;
    Button homesec;

    ThirdFragment thirdFragment;
    FourthFragment fourthFragment;
    FifthFragment fifthFragment;
    Fragment fragment;
    HomeFragment homeFragment;


    public RestartFragment() {
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
        return inflater.inflate(R.layout.fragment_restart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        restartsec = view.findViewById(R.id.restartsec);
        homesec= view.findViewById(R.id.homesec);

        restartsec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                restart(fragment,view);
            }
        });
        homesec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home(fragment,view);
            }
        });

    }
    public void restart(Fragment fragment,View view){
        if (fragment == fifthFragment){
            NavDirections navDirections = RestartFragmentDirections.actionRestartFragmentToFirstFragment();
            Navigation.findNavController(view).navigate(navDirections);
        } else if (fragment == secondFragment) {
            NavDirections navDirections = RestartFragmentDirections.actionRestartFragmentToSecondFragment();
            Navigation.findNavController(view).navigate(navDirections);
        }
        else if (fragment == thirdFragment) {
            NavDirections navDirections = RestartFragmentDirections.actionRestartFragmentToThirdFragment();
            Navigation.findNavController(view).navigate(navDirections);
        }
        else if (fragment == fourthFragment) {
            NavDirections navDirections = RestartFragmentDirections.actionRestartFragmentToFourthFragment();
            Navigation.findNavController(view).navigate(navDirections);
        }
        else if (fragment == fifthFragment) {
            NavDirections navDirections = RestartFragmentDirections.actionRestartFragmentToFifthFragment();
            Navigation.findNavController(view).navigate(navDirections);
        }
    }
    public void home(Fragment fragment , View view) {
     /*   if (fragment == fifthFragment){

        } else if (fragment == secondFragment) {
            NavDirections navDirections = RestartFragmentDirections.actionRestartFragmentToHomeFragment();
            Navigation.findNavController(view).navigate(navDirections);
        }
        else if (fragment == thirdFragment) {
            NavDirections navDirections = RestartFragmentDirections.actionRestartFragmentToThirdFragment();
            Navigation.findNavController(view).navigate(navDirections);
        }
        else if (fragment == fourthFragment) {
            NavDirections navDirections = RestartFragmentDirections.actionRestartFragmentToFourthFragment();
            Navigation.findNavController(view).navigate(navDirections);
        }
        else if (fragment == fifthFragment) {
            NavDirections navDirections = RestartFragmentDirections.actionRestartFragmentToFifthFragment();
            Navigation.findNavController(view).navigate(navDirections);
        }
    }*/
        NavDirections navDirections = RestartFragmentDirections.actionRestartFragmentToHomeFragment();
        Navigation.findNavController(view).navigate(navDirections);
    }


}