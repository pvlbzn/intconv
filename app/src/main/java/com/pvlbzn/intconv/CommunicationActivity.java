package com.pvlbzn.intconv;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by pvlbzn on 4/30/16.
 */
public class CommunicationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Assign a layout.
        setContentView(R.layout.activity_communication);

        // Show software keyboard from the beginning.
        // showKeyboard();


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
