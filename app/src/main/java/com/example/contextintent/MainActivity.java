package com.example.contextintent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.contextintent.databinding.LoginBinding;
import com.example.contextintent.databinding.LoginBinding;

//MainActivity
public class MainActivity extends AppCompatActivity {
    public static SharedPreferences mPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //привязка к view
        LoginBinding binding = LoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mPref = getPreferences(MODE_PRIVATE);

         LoginPresenter presenter = new LoginPresenter(this,binding,mPref);

        if(presenter.signInPref()){
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }

        binding.signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(presenter.signIn()){
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(intent);
                }
            }
        });


    }
}