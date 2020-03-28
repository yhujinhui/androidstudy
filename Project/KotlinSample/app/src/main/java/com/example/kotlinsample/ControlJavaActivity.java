package com.example.kotlinsample;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ControlJavaActivity extends AppCompatActivity {

    EditText numberField;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_control);

        numberField=findViewById(R.id.numberField);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number=Integer.parseInt(numberField.getText().toString());

                if(number%2==0){
                    ToastUtilJava.toastShort(number+"는 2의 배수입니다.");
                } else if(number%3==0){
                    ToastUtilJava.toastShort(number+"는 3의 배수입니다.");
                }else{
                    ToastUtil.toastShort(""+number);
                }

                switch (number){
                    case 4:
                        button.setText("실행-4");break;
                    case 9:
                        button.setText("실행-9");break;
                    default:
                        button.setText("실행");
                }
            }
        });
    }
}
