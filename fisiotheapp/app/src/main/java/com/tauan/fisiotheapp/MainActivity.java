package com.tauan.fisiotheapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

     public void entrar(View view){
         Intent entrarIntent = new Intent(this, ContentActivity.class);
         startActivity(entrarIntent);
    }
}