package com.pvlbzn.intconv.activity;

import com.pvlbzn.intconv.R;
import com.pvlbzn.intconv.fragment.ChatFragment;
import com.pvlbzn.intconv.fragment.MessageInterface;
import com.pvlbzn.intconv.message.Message;
import com.pvlbzn.intconv.message.Sanitizer;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;

/*
 * CommunicationActivity class is a parent class for chat UI fragment.
 * Input UI implemented in XML layout, chat messages implemented in
 * ChatFragment class.
 */
public class CommunicationActivity extends AppCompatActivity {

  private final String TAG = "CommunicationActivity";

  private MessageInterface cfInterface;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Assign a layout.
    setContentView(R.layout.activity_communication);
    // Add ChatFragment to the View
    ChatFragment cf = new ChatFragment();
    // Cast chat fragment down to an interface.
    cfInterface = (MessageInterface) cf;

    // Attach a fragment to an activity.
    getSupportFragmentManager().beginTransaction().add(R.id.chat_container, cf).commit();

    // Find views
    final Button b = (Button) findViewById(R.id.send_button);
    final EditText uInput = (EditText) findViewById(R.id.user_input);

    // Hook up the send button.
    if (b != null && uInput != null) {
      b.setOnClickListener(
          new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              // Get user message.
              String umsg = uInput.getText().toString();
              // Clean input field.
              uInput.setText("");
              uInput.setHint(R.string.input_placeholder);
              // Sanitize it and show.
              cfInterface.receiveMessage(Sanitizer.process(umsg), Message.USER);
              // Send it to the server, and store response in local variable.
              new SendTask().execute(umsg);
            }
          });
    } else {
      // This shouldn't happen.
      Log.e(TAG, "button or edit text is null");
    }
  }

  private class SendTask extends AsyncTask<String, Void, String> {

    // TODO: WATCH OUT FOR AN ENDPOINT
    private final String endpoint = "192.168.1.69";
    private final int port = 24000;

    String answer = null;

    @Override
    protected String doInBackground(String... s) {
      connect(s[0]);
      return "";
    }

    private void connect(String msg) {
      try {
        // Emulate network processing
        Thread.sleep(800);

        Socket sock = new Socket(endpoint, port);
        PrintStream out = new PrintStream(sock.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));

        out.print(msg + "\n");
        answer = in.readLine();

        // Flush and close.
        out.flush();
        out.close();
        in.close();
        sock.close();
      } catch (IOException ioe) {
        Log.e(TAG, ioe.toString());
        answer = "Connection failed.";
      } catch (InterruptedException ie) {
        Log.e(TAG, ie.toString());
        answer = "Connection Interrupted.";
      }
    }

    @Override
    protected void onPostExecute(String s) {
      super.onPostExecute(s);
      cfInterface.receiveMessage(answer, Message.REMOTE);
    }
  }

}
