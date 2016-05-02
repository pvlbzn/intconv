package com.pvlbzn.intconv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pvlbzn.intconv.fragments.ChatFragment;

/*
 * CommunicationActivity class is a parent class for chat UI. Input UI implemented
 * in XML layout, chat messages implemented in ChatFragment class.
 */
public class CommunicationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Assign a layout.
        setContentView(R.layout.activity_communication);

        // Add Chat to the View
        ChatFragment cf = new ChatFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.chat_container, cf)
                .commit();
    }

}
