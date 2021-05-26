package com.eboshug.hugobosquep2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class InfoActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ViewPager viewPager;
    private SectionPageAdapter adapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        this.viewPager = findViewById(R.id.viewPager);
        this.adapter = new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new NovedadesFragment(), "Novedades");
        adapter.addFragment(new OfertasFragment(), "Ofertas");
        adapter.addFragment(new PS4Fragment(), "PS4");
        adapter.addFragment(new XBOXFragment(), "Xbox");
        viewPager.setAdapter(adapter);

        this.tabLayout = (TabLayout) findViewById(R.id.tabbar);
        tabLayout.setupWithViewPager(viewPager);

        this.toolbar = findViewById(R.id.customToolbar);
        toolbar.setTitle("Catalogo");
        setSupportActionBar(toolbar);

        this.drawerLayout = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, this.drawerLayout, this.toolbar,0,0
        );
        this.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        this.navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        tabLayout.getTabAt(adapter.getIndexOfTab(getIntent().getStringExtra("tab"))).select();
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
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                break;

            case R.id.carrito:
                intent = new Intent(this, CarritoActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                break;

            case R.id.novedades:
                this.tabLayout.getTabAt(this.adapter.getIndexOfTab("Novedades")).select();
                break;

            case R.id.ofertas:
                this.tabLayout.getTabAt(this.adapter.getIndexOfTab("Ofertas")).select();
                break;

            case R.id.ps4:
                this.tabLayout.getTabAt(this.adapter.getIndexOfTab("PS4")).select();
                break;

            case R.id.xbox:
                this.tabLayout.getTabAt(this.adapter.getIndexOfTab("Xbox")).select();
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
                overridePendingTransition(0, 0);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    class SectionPageAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragmentList = new ArrayList<>();
        private List<String> titleList = new ArrayList<>();

        public void addFragment(Fragment fragment, String title) {
            this.fragmentList.add(fragment);
            this.titleList.add(title);
        }

        public int getIndexOfTab(String title) {
            return this.titleList.indexOf(title);
        }

        public SectionPageAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return this.titleList.get(position);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return this.fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return this.fragmentList.size();
        }
    }
}
