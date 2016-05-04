package com.pvlbzn.intconv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pvlbzn.intconv.fragment.ChatFragment;
import com.pvlbzn.intconv.fragment.MessageInterface;

/*
 * CommunicationActivity class is a parent class for chat UI. Input UI implemented
 * in XML layout, chat messages implemented in ChatFragment class.
 */
public class CommunicationActivity extends AppCompatActivity {

    private final String TAG = "CommunicationActivity";

    private MessageInterface cfInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Assign a layout.
        setContentView(R.layout.activity_communication);

        // Add Chat to the View
        ChatFragment cf = new ChatFragment();
        cfInterface = (MessageInterface) cf;
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.chat_container, cf)
                .commit();

        // Find views
        final Button b = (Button) findViewById(R.id.send_button);
        final EditText uInput = (EditText) findViewById(R.id.user_input);

        // Hook up the send button.
        if (b != null && uInput != null) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String msg = uInput.getText().toString();
                    cfInterface.receiveMessage(Sanitizer.process(msg));
                }
            });
        } else {
            // This shouldn't happen.
            Log.e(TAG, "button or edit text is null");
        }
    }

}
