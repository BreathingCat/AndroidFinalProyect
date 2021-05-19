package com.eboshug.hugobosquep2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class VideoGameDetail extends AppCompatActivity {

    TextView titulo;
    TextView precio;
    ImageView caratula;
    TextView descripcion;
    FloatingActionButton fab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);

        this.titulo = findViewById(R.id.title);
        this.precio = findViewById(R.id.precio);
        this.caratula = findViewById(R.id.caratula);
        this.descripcion = findViewById(R.id.description);
        this.fab = findViewById(R.id.fab);

        Intent intent = getIntent();
        VideoGame game = (VideoGame) intent.getSerializableExtra("game");

        this.titulo.setText(game.getNombre());
        this.precio.setText(String.valueOf(game.getPrecio()) + " €");
        this.caratula.setImageResource(game.getImg_id());
        this.descripcion.setText(game.getDescripcion());

        this.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

    }
}
