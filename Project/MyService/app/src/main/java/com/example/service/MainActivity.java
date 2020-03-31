package com.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button button;
        final EditText editText;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editText);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editText.getText().toString();

                Intent intent=new Intent(getApplicationContext(),MyService.class);
                intent.putExtra("command","show");
                intent.putExtra("name",name);
                startService(intent);
            }
        });
        Intent passedIntent=getIntent();
        processCommand(passedIntent);
    }
    @Override
    protected void onNewIntent(Intent intent) {
        processCommand(intent);

        super.onNewIntent(intent);
    }
    private void processCommand(Intent intent){
        if(intent!=null){
            String command=intent.getStringExtra("command");
            String name=intent.getStringExtra("name");

            Toast.makeText(getApplicationContext(),"서비스로부터 전달받은 데이터 : "+command+","+name,Toast.LENGTH_SHORT).show();
        }
    }
}
