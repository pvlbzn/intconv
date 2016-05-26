package com.pvlbzn.intconv.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.pvlbzn.intconv.message.Message;
import com.pvlbzn.intconv.R;

import java.util.ArrayList;

public class ChatAdapter extends ArrayAdapter<Message> {

  // Logging
  private final String TAG = "ChatAdapter";

  // Constructor, which will set ArrayList for Message type as a data source.
  public ChatAdapter(Context context, ArrayList<Message> msg, ViewGroup parent) {
    super(context, 0, msg);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    // Get message at position.
    Message m = getItem(position);

    // If source is an user inflate "end-hand side" layout. If source is
    // a remote source inflate "start-hand side" layout. This condition
    // is pretty much the main reason for a custom ArrayAdapter.
    if (m.source == Message.USER) {
      convertView =
          LayoutInflater.from(getContext()).inflate(R.layout.list_item_output, parent, false);
    } else if (m.source == Message.REMOTE) {
      convertView =
          LayoutInflater.from(getContext()).inflate(R.layout.list_item_input, parent, false);
    }

    // Find text view in layout which was set before. Both layouts have
    // a list_item_text ID for a convenience.
    TextView t = (TextView) convertView.findViewById(R.id.list_item_text);
    if (t != null) {
      t.setText(m.msg);
    } else {
      Log.e(TAG, "TextView is null");
    }

    return convertView;
  }
}
