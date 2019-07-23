package com.dfl.musicalinstruments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListInstrumentsFragment.ISelected {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.musical_instruments_title);

        if (findViewById(R.id.fragmentContent) != null) {
            InstrumentFragment content = new InstrumentFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContent, content).commit();
        }
    }

    @Override
    public void classSelected(int select) {
        Toast.makeText(this, "Imprimir " + select, Toast.LENGTH_LONG).show();
    }
}
