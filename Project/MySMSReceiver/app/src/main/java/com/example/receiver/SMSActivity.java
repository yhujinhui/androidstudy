package com.example.receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SMSActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    EditText editText3;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        editText.findViewById(R.id.editText);
        editText2.findViewById(R.id.editText2);
        editText3.findViewById(R.id.editText3);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent passedIntent=getIntent();
        processCommand(passedIntent);
    }
    private void processCommand(Intent intent){
        if(intent!=null){
            String sender=intent.getStringExtra("sender");
            String contents=intent.getStringExtra("contents");
            String receivedDate=intent.getStringExtra("receivedDate");

            editText.setText(sender);
            editText.setText(contents);
            editText.setText(receivedDate);

        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        processCommand(intent);
        super.onNewIntent(intent);
    }
}
