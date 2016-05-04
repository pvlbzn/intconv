package com.pvlbzn.intconv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set an event listener on UI button.
        Button b = (Button) findViewById(R.id.connect_button);
        if (b != null) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openCommunication();
                }
            });
        }
    }

    /* Open a communication via creating a new Intent. */
    private void openCommunication() {
        // Create Intent instance.
        Intent i = new Intent(this, CommunicationActivity.class);
        // Run it.
        startActivity(i);
    }

}
