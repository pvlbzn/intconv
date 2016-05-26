package com.pvlbzn.intconv.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.pvlbzn.intconv.Message;
import com.pvlbzn.intconv.R;
import com.pvlbzn.intconv.adapter.ChatAdapter;

import java.util.ArrayList;

public class ChatFragment extends Fragment implements MessageInterface {

  // Logging
  private static final String TAG = "ChatFragment";

  // An empty constructor
  public ChatFragment() {}

  // Global references
  private View root = null;
  private ArrayList<Message> al = null;
  private ChatAdapter ca = null;

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate a layout
    root = inflater.inflate(R.layout.fragment_chat, container, false);
    return root;
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    // Create an array list which will store all the messages.
    al = new ArrayList<>();
    // Create a custom ArrayAdapter which is layout-aware of the different sources.
    ca = new ChatAdapter(getContext(), al, (ViewGroup) view.getParent());

    // Find a list view and attach ChatAdapter to it.
    ListView lv = (ListView) root.findViewById(R.id.chat_list_view);
    lv.setAdapter(ca);
  }

  /* MessageInterface implementation. */

  public void receiveMessage(String msg, int sender) {
    // Create a new message object from user input, add it to the array list,
    // which expects to receive Message type. Notify data set about change.
    Message m = null;
    if (sender == Message.USER) m = new Message(Message.USER, "user", msg);
    if (sender == Message.REMOTE) m = new Message(Message.REMOTE, "remote", msg);
    if (m != null) al.add(m);
    ca.notifyDataSetChanged();
  }
}
