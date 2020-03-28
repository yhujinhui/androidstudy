package com.example.callintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        editText=findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String receiver=editText.getText().toString();
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+receiver));
//                지정한 url을 로드
                startActivity(intent);

                Intent intent2=new Intent();
                ComponentName name=new ComponentName("org.techtown.callintent","org.techtown.callintent.MenuActivity");
//                외부 어플리케이션을 실행을 명시적 호출을 통해 실행
//                패키지명, 패키지명.액티비티명
                intent2.setComponent(name);
                startActivity(intent2);
            }
        });
    }
}
