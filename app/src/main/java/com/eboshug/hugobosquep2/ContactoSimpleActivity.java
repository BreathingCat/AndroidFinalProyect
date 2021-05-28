package com.eboshug.hugobosquep2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class ContactoSimpleActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    EditText email;
    EditText name;
    EditText body;
    Button buttonSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_simple);

        this.toolbar = findViewById(R.id.customToolbar);
        toolbar.setTitle("Contactanos");
        setSupportActionBar(toolbar);

        this.drawerLayout = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, this.drawerLayout, this.toolbar,0,0
        );
        this.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        this.navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        email = findViewById(R.id.editEmail);
        name = findViewById(R.id.editNombre);
        body = findViewById(R.id.editConsulta);

        buttonSend = findViewById(R.id.button);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    String subject = "CONTACTO DE " + name.getText().toString();
                    String newBody = "EMAIL: " + email.getText().toString() + "\n\nDUDA: " + body.getText().toString();

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_EMAIL, "dudas@piumgames.com");
                    intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                    intent.putExtra(Intent.EXTRA_TEXT, newBody);
                    intent.setType("text/plain");

                    startActivity(Intent.createChooser(intent, "Enviar Email"));

            }
        });
    }

    @Override
    public void onBackPressed() {
        if(this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {

            case R.id.inicio:
                this.drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.carrito:
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
                intent = new Intent(this, Contactanos.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                break;
        }

        this.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
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
}