package com.androidjg.jogodagarrafa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView garrafa;
    private Random random = new Random();
    private int ultimaDirecao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        garrafa = findViewById(R.id.garrafa);

        garrafa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int novaDirecao = random.nextInt(3600);
                float eixoX = garrafa.getWidth() / 2;
                float eixoY = garrafa.getHeight() / 2;

                Animation girar = new RotateAnimation(ultimaDirecao,novaDirecao,eixoX,eixoY);
                girar.setDuration(4000);
                girar.setFillAfter(true);

                ultimaDirecao = novaDirecao;
                garrafa.startAnimation(girar);
            }
        });

    }
}