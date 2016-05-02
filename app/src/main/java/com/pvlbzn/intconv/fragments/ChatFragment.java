package com.pvlbzn.intconv.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.pvlbzn.intconv.R;

import java.util.ArrayList;


public class ChatFragment extends Fragment {

    // Logging
    private static final String TAG = "ChatFragment";

    // An empty constructor
    public ChatFragment() {
    }

    // View root reference
    View root = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate a layout
        root = inflater.inflate(R.layout.fragment_chat, container, false);
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Fake data
        ArrayList<String> al = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            al.add(String.valueOf(i));
        }

        Log.v(TAG, al.toString());

        // Create an ArrayAdapter
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(getActivity(), R.layout.list_item, al);
        ListView lv = (ListView) root.findViewById(R.id.chat_list_view);
        lv.setAdapter(itemsAdapter);
    }
}
