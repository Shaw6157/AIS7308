package com.ais.demodrawerfrag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, UserFragment.OnFragmentInteractionListener{
    DrawerLayout lyt_drawer;
    FrameLayout lyt_fragments;
    Toolbar mToolbar;

    TextView tv_text;
    Button btn_mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.nav_toolbar);
        setSupportActionBar(mToolbar);

        lyt_drawer = findViewById(R.id.lyt_drawer);
        NavigationView lvNavigationView = findViewById(R.id.nav_view);
        lvNavigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, lyt_drawer, mToolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        lyt_drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.lyt_fragments,
                    new MailFragment()).commit();
            lvNavigationView.setCheckedItem(R.id.nav_mail);
        }

        //parameter demo start
        lyt_fragments = findViewById(R.id.lyt_fragments);
        tv_text = findViewById(R.id.tv_text);
        btn_mail = findViewById(R.id.btn_mail);

        btn_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tv_text.getText().toString();
                openFragment(text);
            }
        });
    }

    private void openFragment(String s) {
        UserFragment fragment = UserFragment.newInstance(s);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right,
                R.anim.enter_from_right, R.anim.exit_to_right);
        transaction.addToBackStack(null);
        transaction.replace(R.id.lyt_fragments, fragment, "user details").commit();
    }

    @Override
    public void onBackPressed() {
        if (lyt_drawer.isDrawerOpen(GravityCompat.START)) {
            lyt_drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_mail:
                getSupportFragmentManager().beginTransaction().replace(R.id.lyt_fragments,
                        new MailFragment()).commit();
                break;
            case R.id.nav_share:
                getSupportFragmentManager().beginTransaction().replace(R.id.lyt_fragments,
                        new ShareFragment()).commit();
                break;
            case R.id.nav_shopping:
                getSupportFragmentManager().beginTransaction().replace(R.id.lyt_fragments,
                        new ShoppingFragment()).commit();
                break;
            case R.id.nav_sim:
                break;
            case R.id.nav_user:
                getSupportFragmentManager().beginTransaction().replace(R.id.lyt_fragments,
                        new UserFragment()).commit();
                break;
            default:
                break;
        }

        lyt_drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onFragmentInteraction(String str) {
        tv_text.setText(str);
        onBackPressed();
    }
}
