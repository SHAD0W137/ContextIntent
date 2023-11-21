package com.example.contextintent;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contextintent.databinding.ThirdactivityBinding;

import java.util.zip.Inflater;

public class ThirdActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThirdactivityBinding binding = ThirdactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        Person user = intent.getParcelableExtra("info");
        binding.NameTV.setText(user.getName() + " " + user.getSurname());
    }
}
