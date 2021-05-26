package com.eboshug.hugobosquep2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class VideoGameDetail extends AppCompatActivity{

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    TextView titulo;
    TextView precio;
    ImageView caratula;
    TextView descripcion;
    FloatingActionButton fab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);

        this.toolbar = findViewById(R.id.customToolbar);
        toolbar.setTitle("App Title");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

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

        GameDataHelper videogameHelper = new GameDataHelper(this);

        this.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videogameHelper.addToShoppingList(game);
                Toast.makeText(VideoGameDetail.this, "Added " + game.getNombre() + " to your shopping list", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.shopAction:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
