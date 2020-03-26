package com.example.hello2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int clickcount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(),"프로그래밍을 시작해보자!", Toast.LENGTH_LONG).show();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickcount++;
                if(clickcount%2==0) {
                    Toast.makeText(getApplicationContext(), "clickCount : " + clickcount, Toast.LENGTH_SHORT).show();
                }else if(clickcount%3==0){
                    Toast.makeText(getApplicationContext(), "Hello, World!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
