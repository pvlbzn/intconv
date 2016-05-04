package com.pvlbzn.intconv.fragment;

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


public class ChatFragment extends Fragment implements MessageInterface {

    // Logging
    private static final String TAG = "ChatFragment";

    // An empty constructor
    public ChatFragment() {
    }

    // View root reference
    private View root = null;
    private ArrayList<String> al = null;
    private ArrayAdapter<String> aa = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate a layout
        root = inflater.inflate(R.layout.fragment_chat, container, false);
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Fake data for test
        /*
        al = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            al.add(String.valueOf(i));
        }

        Log.v(TAG, al.toString());
        */

        al = new ArrayList<>();

        // Create an ArrayAdapter
        aa = new ArrayAdapter<>(getActivity(), R.layout.list_item, al);
        ListView lv = (ListView) root.findViewById(R.id.chat_list_view);
        lv.setAdapter(aa);
    }

    // Add a message to the ArrayList.
    private void addMessage(String msg) {
        al.add(msg);
    }

    /* MessageInterface implementation. */

    public void receiveMessage(String msg) {
        Log.v(TAG, "Received" + msg);
        addMessage(msg);
        aa.notifyDataSetChanged();
    }


}
