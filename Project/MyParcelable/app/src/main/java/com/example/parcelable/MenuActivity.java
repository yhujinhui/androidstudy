package com.example.parcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        button=findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent passedintent=getIntent();
//        받아주는 인텐트를 사용하겠다는 의미
        processIntent(passedintent);
    }
    private void processIntent(Intent intent){
        if(intent!=null){
            ArrayList<String> names= (ArrayList<String>)intent.getSerializableExtra("names");
//            객체 받음
            if(names!=null){
                Toast.makeText(getApplicationContext(),"전달받은 이름 리스트 개수 : "+names.size(),Toast.LENGTH_SHORT).show();
            }
        }
    }
}
