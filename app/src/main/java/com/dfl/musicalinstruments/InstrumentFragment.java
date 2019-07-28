package com.dfl.musicalinstruments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class InstrumentFragment extends Fragment {

    private static final String KEY_POSITION = "POSITION";
    private int positionCurrent = -1;

    //para dispositivos normales
    public static InstrumentFragment getInstance(int position) {
        InstrumentFragment fragment = new InstrumentFragment();
        Bundle argument = new Bundle();
        argument.putInt(KEY_POSITION, position);
        fragment.setArguments(argument);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null)
            positionCurrent = savedInstanceState.getInt(KEY_POSITION);
        return inflater.inflate(R.layout.fragment_instrument, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle argument = getArguments();
        if (argument != null)
            updateView(argument.getInt(KEY_POSITION));
        else if (positionCurrent != -1)
            updateView(positionCurrent);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_POSITION, positionCurrent);
    }

    public void updateView(int position) {
        String[] information = getResources().getStringArray(R.array.information_instruments);
        String[] informationTitle = getResources().getStringArray(R.array.class_instruments);

        TextView informationText = Objects.requireNonNull(getActivity()).findViewById(R.id.textInformative);
        informationText.setText(information[position]);
        Drawable imageOne = null;
        Drawable imageTwo = null;
        switch (position) {
            case 0:
                imageOne = ContextCompat.getDrawable(Objects.requireNonNull(getContext()), R.drawable.guitarra);
                imageTwo = ContextCompat.getDrawable(getContext(), R.drawable.violin);
                break;
            case 1:
                imageOne = ContextCompat.getDrawable(Objects.requireNonNull(getContext()), R.drawable.conga);
                imageTwo = ContextCompat.getDrawable(getContext(), R.drawable.tamboras);
                break;
            case 2:
                imageOne = ContextCompat.getDrawable(Objects.requireNonNull(getContext()), R.drawable.clarinete);
                imageTwo = ContextCompat.getDrawable(getContext(), R.drawable.saxofon);
                break;
            case 3:
                imageOne = ContextCompat.getDrawable(Objects.requireNonNull(getContext()), R.drawable.teclado);
                imageTwo = ContextCompat.getDrawable(getContext(), R.drawable.bajo_electrico);
                break;
        }
        ((ImageView) getActivity().findViewById(R.id.imageViewOne)).setImageDrawable(imageOne);
        ((ImageView) getActivity().findViewById(R.id.imageViewTwo)).setImageDrawable(imageTwo);
        getActivity().setTitle(getActivity().getString(R.string.set_title) + " " + informationTitle[position]);
    }
}
