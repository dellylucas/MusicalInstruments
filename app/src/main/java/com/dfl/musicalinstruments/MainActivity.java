package com.dfl.musicalinstruments;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListInstrumentsFragment.ISelected {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.container_phone) != null) {
            if (savedInstanceState != null)
                return;
            ListInstrumentsFragment content = new ListInstrumentsFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.container_phone, content).commit();
        }
        if (getResources().getBoolean(R.bool.portrait_only))
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    //esto es para cambiar horientacion no reinicia actividad
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        onCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (findViewById(R.id.container_phone) != null)
            setTitle(this.getResources().getString(R.string.main_title));
    }

    @Override
    public void classSelected(int select) {
        InstrumentFragment fragment = (InstrumentFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContentTablet);
        if (fragment != null)
            fragment.updateView(select);
        else
            getSupportFragmentManager().beginTransaction().replace(R.id.container_phone, InstrumentFragment.getInstance(select)).addToBackStack(null).commit();
    }

    public void onClickPlay(View view) {
        Toast.makeText(this, this.getResources().getString(R.string.play_sound_text), Toast.LENGTH_SHORT).show();
    }

    public void onClickFavorite(View view) {
        Toast.makeText(this, this.getResources().getString(R.string.add_favorite_text), Toast.LENGTH_SHORT).show();
    }
}