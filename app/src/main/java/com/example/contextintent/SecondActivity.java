package com.example.contextintent;

import static android.os.storage.StorageManager.ACTION_CLEAR_APP_CACHE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contextintent.databinding.ActivityMainBinding;

import java.util.zip.Inflater;

public class SecondActivity extends AppCompatActivity {
    static Person user;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button move = binding.move;
        EditText name = binding.name;
        EditText surname = binding.surname;

        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                user = new Person(name.getText().toString(), surname.getText().toString());
                intent.putExtra("info", user);
                startActivity(intent);
            }
        });
        binding.CASH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "На все мои попытки очистить кэш Android Studio ответил 'NEIN' поэтому кэш мы идём чистить вручную", Toast.LENGTH_LONG).show();
            }
        });

    }
}
