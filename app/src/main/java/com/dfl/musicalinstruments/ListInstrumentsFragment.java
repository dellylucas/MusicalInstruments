package com.dfl.musicalinstruments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Objects;

public class ListInstrumentsFragment extends ListFragment {
    private ISelected implement;
    private int lastCheck = -1;

    public interface ISelected {
        void classSelected(int select);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            implement = (ISelected) context;
        } catch (ClassCastException ex) {
            throw new ClassCastException(context.toString());

        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] class_instruments = getResources().getStringArray(R.array.class_instruments);
        setListAdapter(new ArrayAdapter<>(Objects.requireNonNull(getContext()), android.R.layout.simple_list_item_1, class_instruments));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        implement.classSelected(position);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        getListView().setItemChecked(position, true);
        if (lastCheck != -1)
            getListView().getChildAt(lastCheck).setBackgroundResource(android.R.color.transparent);
        lastCheck = l.getCheckedItemPosition();
        v.setBackgroundResource(android.R.color.holo_blue_light);
    }
}