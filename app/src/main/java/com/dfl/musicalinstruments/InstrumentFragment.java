package com.dfl.musicalinstruments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Objects;

public class InstrumentFragment extends Fragment {

    private static final String LLAVE_POSICION = "POSICION";
    private int posicionActual = -1;

    public static InstrumentFragment getInstance(int posicion) {
        InstrumentFragment fragment = new InstrumentFragment();
        Bundle argumentos = new Bundle();
        argumentos.putInt(LLAVE_POSICION, posicion);
        fragment.setArguments(argumentos);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null)
            posicionActual = savedInstanceState.getInt(LLAVE_POSICION);
        return inflater.inflate(R.layout.fragment_instrument, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle argumentos = getArguments();
        if (argumentos != null)
            actualizasVista(argumentos.getInt(LLAVE_POSICION));
        else if (posicionActual != -1)
            actualizasVista(posicionActual);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(LLAVE_POSICION, posicionActual);
    }

    public void actualizasVista(int posicion) {
        TextView textoInformativo = (TextView) Objects.requireNonNull(getActivity()).findViewById(R.id.textInformative);
        textoInformativo.setText("aaa");


    }
}
