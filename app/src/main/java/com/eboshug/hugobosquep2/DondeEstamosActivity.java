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

import com.google.android.gms.maps.MapView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class DondeEstamosActivity extends AppCompatActivity implements OnMapReadyCallback, NavigationView.OnNavigationItemSelectedListener  {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private MapView mapView;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donde_estamos);

        this.toolbar = findViewById(R.id.customToolbar);
        toolbar.setTitle("Donde estamos");
        setSupportActionBar(toolbar);

        this.drawerLayout = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, this.drawerLayout, this.toolbar,0,0
        );
        this.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        this.navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng tienda = new LatLng(38.871716531768605, -77.05514474726354);
        mMap.addMarker(new MarkerOptions()
                .position(tienda)
                .title("Donde estamos :)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tienda,15));
        // Zoom in, animating the camera.
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15), 100000, null);
    }


    @Override
    public void onBackPressed() {
        if(this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);;
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {

            case R.id.inicio:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
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