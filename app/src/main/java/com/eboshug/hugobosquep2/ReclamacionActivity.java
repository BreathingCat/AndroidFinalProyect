package com.eboshug.hugobosquep2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.VideoView;

import com.google.android.material.navigation.NavigationView;

public class ReclamacionActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ImageView imagen;
    VideoView video;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    EditText email;
    EditText name;
    EditText body;
    Button buttonSend;
    Button buttonGaleria;
    Button buttonPic;
    Button buttonVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclamacion);


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
                intent.putExtra(Intent.EXTRA_EMAIL, "reclamaciones@piumgames.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, newBody);
                //intent.putExtra(Intent.EXTRA_STREAM, )
                intent.setType("text/plain");

                startActivity(Intent.createChooser(intent, "Enviar Email"));

            }
        });

        buttonGaleria = findViewById(R.id.buttonGaleria);
        buttonGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGalley(v);
            }
        });

        buttonPic = findViewById(R.id.buttonCamara);
        buttonPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture(v);
            }
        });

        buttonVideo = findViewById(R.id.buttonVideo);
        buttonVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeVideo(v);
            }
        });
    }

    static final int REQUEST_VIDEO_CAPTURE = 3;
    static final int REQUEST_GALLERY = 2;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    public void takePicture(View v){
        Intent takeNewPicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takeNewPicture.resolveActivity(getPackageManager()) != null){
            try{
                startActivityForResult(takeNewPicture, REQUEST_IMAGE_CAPTURE);
            }catch (ActivityNotFoundException e){}
        }
    }

    public void openGalley(View v){
        Intent takePicture = new Intent(Intent.ACTION_PICK);
        takePicture.setType("image/*");
        startActivityForResult(takePicture, REQUEST_GALLERY);
    }

    public void takeVideo(View v){
        Intent takePicture = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takePicture.resolveActivity(getPackageManager()) != null){
            try {
                startActivityForResult(takePicture, REQUEST_VIDEO_CAPTURE);
            } catch (ActivityNotFoundException e){}

        }
    }


    @Override
    protected void onActivityResult (int code, int resultCode, Intent data){
        super.onActivityResult(code, resultCode,data);
        if (code == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imagen.setImageBitmap(imageBitmap);
            imagen.setVisibility(View.VISIBLE);
            video.setVisibility(View.INVISIBLE);
        }else if (code == REQUEST_GALLERY && resultCode == RESULT_OK){
            Uri videoUri = data.getData();
            imagen.setImageURI(videoUri);
            imagen.setVisibility(View.VISIBLE);
            video.setVisibility(View.INVISIBLE);
        }
        else if (code == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK){
            Uri videoUri = data.getData();
            imagen.setImageURI(videoUri);
            imagen.setVisibility(View.INVISIBLE);
            video.setVisibility(View.VISIBLE);
            video.start();
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