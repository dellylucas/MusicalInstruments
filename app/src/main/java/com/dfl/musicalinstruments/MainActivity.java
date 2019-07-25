package com.dfl.musicalinstruments;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListInstrumentsFragment.ISelected {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.fragmentContent) != null) {
            InstrumentFragment content = new InstrumentFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContent, content).commit();
        }
        if (getResources().getBoolean(R.bool.portrait_only))
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        onCreate(savedInstanceState);
    }

    @Override
    public void classSelected(int select) {
        Toast.makeText(this, "Imprimir " + (select + 1), Toast.LENGTH_SHORT).show();
    }
}
