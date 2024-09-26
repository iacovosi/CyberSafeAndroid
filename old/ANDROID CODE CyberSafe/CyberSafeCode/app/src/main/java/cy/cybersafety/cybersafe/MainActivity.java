package cy.cybersafety.cybersafe;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(cy.cybersafety.cybersafe.R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(cy.cybersafety.cybersafe.R.id.toolbar);
        setSupportActionBar(toolbar);
        if (savedInstanceState == null) {
            Fragment newFragment = new HomeFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(cy.cybersafety.cybersafe.R.id.content_frame, newFragment);
            ft.addToBackStack(null);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(cy.cybersafety.cybersafe.R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, cy.cybersafety.cybersafe.R.string.navigation_drawer_open, cy.cybersafety.cybersafe.R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(cy.cybersafety.cybersafe.R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(cy.cybersafety.cybersafe.R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;
        Bundle bundle = new Bundle();
        if (id == cy.cybersafety.cybersafe.R.id.home) {
            fragment = new HomeFragment();
        } else if (id == cy.cybersafety.cybersafe.R.id.helpline) {
            bundle.putString("url", "https://hotline.pi.ac.cy/helpline/en/form");
            fragment = new WebViewFragment();
            fragment.setArguments(bundle);
        } else if (id == cy.cybersafety.cybersafe.R.id.hotline) {
            bundle.putString("url", "https://hotline.pi.ac.cy/hotline/en/form");
            fragment = new WebViewFragment();
            fragment.setArguments(bundle);
        }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(cy.cybersafety.cybersafe.R.id.content_frame, fragment);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(cy.cybersafety.cybersafe.R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
