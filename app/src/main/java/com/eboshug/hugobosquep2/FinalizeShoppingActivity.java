package com.eboshug.hugobosquep2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;


public class FinalizeShoppingActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button buy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalize_shopping);

        this.toolbar = findViewById(R.id.customToolbar);
        toolbar.setTitle("Finalizar compra");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        EditText mail = findViewById(R.id.inputMail);

        GameDataHelper db = new GameDataHelper(this);
        List<VideoGame> carrito = db.getShoppingList();

        float precioFinal = 0;
        String juegos = "";

        for (int i = 0; i < carrito.size(); i++) {
            precioFinal = precioFinal + carrito.get(i).getPrecio();
            juegos = juegos + ", " + carrito.get(i).getNombre();
        }

        this.buy = findViewById(R.id.buttonBuy);
        float finalPrecioFinal = precioFinal;

        String finalJuegos = juegos;
        this.buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, mail.getText());
                intent.putExtra(Intent.EXTRA_SUBJECT, "Factura de compra en PiumGames");
                intent.putExtra(Intent.EXTRA_TEXT, "Precio = " + Float.toString(finalPrecioFinal) + "\nItems: " + finalJuegos);
                startActivity(Intent.createChooser(intent, "Send email"));
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
                Intent intent = new Intent(this, CarritoActivity.class);
                startActivity(intent);
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
