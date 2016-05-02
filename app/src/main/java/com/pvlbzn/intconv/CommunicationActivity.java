package com.pvlbzn.intconv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pvlbzn.intconv.fragments.ChatFragment;


public class CommunicationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Assign a layout.
        setContentView(R.layout.activity_communication);

        // Show software keyboard from the beginning.
        // showKeyboard();

        // Add Chat to the View
        ChatFragment cf = new ChatFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.chat_container, cf)
                .commit();
    }

    /*
    * Because of *I have no idea what* this approach doesn't work properly. Task solved using
    * AndroidManifest statement.
    private void showKeyboard() {
        InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        in.showSoftInput((View)findViewById(android.R.id.content), InputMethodManager.SHOW_IMPLICIT);
    }
    */



}
