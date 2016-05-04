package com.pvlbzn.intconv.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.pvlbzn.intconv.Message;
import com.pvlbzn.intconv.R;

import java.util.ArrayList;


public class ChatAdapter extends ArrayAdapter<Message> {

    private final String TAG = "ChatAdapter";

    public ChatAdapter(Context context, ArrayList<Message> msg, ViewGroup parent) {
        super(context, 0, msg);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message m = getItem(position);

        Log.v(TAG, "Received: " + m.msg + " From: " + m.sender);

        // TODO: Move to constants
        if (m.sender.equals("user")) {
            if (convertView == null) {
                Log.v(TAG, "USER");
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_output, parent, false);
            }
        } else if (m.sender.equals("remote")) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_input, parent, false);
            }
        }

        TextView t = (TextView) convertView.findViewById(R.id.list_item_text);
        t.setText(m.msg);

        return convertView;
    }

}
