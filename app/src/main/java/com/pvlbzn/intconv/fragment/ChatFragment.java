package com.pvlbzn.intconv.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.pvlbzn.intconv.Message;
import com.pvlbzn.intconv.R;
import com.pvlbzn.intconv.adapter.ChatAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class ChatFragment extends Fragment implements MessageInterface {

    // Logging
    private static final String TAG = "ChatFragment";

    // An empty constructor
    public ChatFragment() {
    }

    // View root reference
    private View root = null;
    private ArrayList<Message> al = null;
    private ChatAdapter aa = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate a layout
        root = inflater.inflate(R.layout.fragment_chat, container, false);
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        al = new ArrayList<>();

        // Create an ArrayAdapter
        aa = new ChatAdapter(getContext(), al, (ViewGroup)view.getParent());

        ListView lv = (ListView) root.findViewById(R.id.chat_list_view);
        lv.setAdapter(aa);
    }


    /* MessageInterface implementation. */

    public void receiveMessage(String msg) {
        Log.v(TAG, "Received: " + msg);
        Message m = new Message("user", msg);
        al.add(m);
        aa.notifyDataSetChanged();
    }


}
