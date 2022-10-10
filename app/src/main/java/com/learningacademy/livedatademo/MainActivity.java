package com.learningacademy.livedatademo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.learningacademy.livedatademo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private MainActivityViewModel mainActivityViewModel;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        setSupportActionBar(binding.toolbar);

        LiveData<Integer> countLiveData = mainActivityViewModel.getInitialCount();    // this gives us the live data object,
                                                                                    // but to get update with live data we have to observe it...

        countLiveData.observe(this, new Observer<Integer>() {                   // To get update this is the observer.
            @Override
            public void onChanged(Integer integer) {
                Toast.makeText(getApplicationContext(),"Observer Observing ", Toast.LENGTH_LONG).show();
                binding.counter.setText("Count is : " + integer);
            }
        });


        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityViewModel.getCurrentCount();
            }
        });
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}