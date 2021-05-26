package com.eboshug.hugobosquep2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

public class CarritoActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        this.toolbar = findViewById(R.id.customToolbar);
        toolbar.setTitle("App Title");
        setSupportActionBar(toolbar);

        this.drawerLayout = findViewById(R.id.drawerLayoutCarrito);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, this.drawerLayout, this.toolbar,0,0
        );
        this.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        GameDataHelper db = new GameDataHelper(this);

        this.navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        this.recyclerView = findViewById(R.id.recyclerViewCarrito);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setAdapter(new RecyclerAdapter(db.getShoppingList(), this));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));

        db.close();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {

            case R.id.inicio:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.carrito:
                this.drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.novedades:
                intent = new Intent(this, InfoActivity.class);
                intent.putExtra("tab", "Novedades");
                startActivity(intent);
                overridePendingTransition(0, 0);
                break;

            case R.id.ofertas:
                intent = new Intent(this, InfoActivity.class);
                intent.putExtra("tab", "Ofertas");
                startActivity(intent);
                overridePendingTransition(0, 0);
                break;

            case R.id.ps4:
                intent = new Intent(this, InfoActivity.class);
                intent.putExtra("tab", "PS4");
                startActivity(intent);
                overridePendingTransition(0, 0);
                break;

            case R.id.xbox:
                intent = new Intent(this, InfoActivity.class);
                intent.putExtra("tab", "Xbox");
                startActivity(intent);
                overridePendingTransition(0, 0);
                break;

            case R.id.donde_estamos:
                intent = new Intent(this, DondeEstamosActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                break;

            case R.id.contacto:
                break;
        }

        this.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
