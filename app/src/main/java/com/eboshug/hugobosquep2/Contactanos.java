package com.eboshug.hugobosquep2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.navigation.NavigationView;

public class Contactanos extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    RadioGroup radioGroup;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    RadioButton rd1;
    RadioButton rd2;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactanos);

        radioGroup = findViewById(R.id.group);
        rd1=(RadioButton)findViewById(R.id.op1);
        rd2=(RadioButton)findViewById(R.id.op2);
        Button buttonApply = findViewById(R.id.button);
        buttonApply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            checkButton();
            }
        });

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
    }
    public void checkButton(){
        int radioId = radioGroup.getCheckedRadioButtonId();
        rd1=(RadioButton)findViewById(R.id.op1);
        rd2=(RadioButton)findViewById(R.id.op2);
        if (rd1.isChecked()){
            Intent intent = new Intent(this, ContactoSimpleActivity.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        }
        else if (rd2.isChecked()){
            Intent intent = new Intent(this, ReclamacionActivity.class);
            startActivity(intent);
            overridePendingTransition(0, 0);

        }

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