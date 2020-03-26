package com.example.hello2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    Car car1=new Car(3,100,4);
    SportsCar car2=new SportsCar(10,50,8);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toast.makeText(getApplicationContext(), "프로그래밍을 시작해보자!", Toast.LENGTH_SHORT).show();

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                car1.accelerationPedal();
                car2.accelerationPedal();
                String info="car1: "+car1.getCurrentSpeedText()+"car2: "+car2.getCurrentSpeedText();
                Toast.makeText(getApplicationContext(),info,Toast.LENGTH_SHORT).show();

                car2.openSunRoof();
                Toast.makeText(getApplicationContext(),car2.getSunRoofInfo(),Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                car1.brakePedal();
                car2.brakePedal();
                String info="car1: "+car1.getCurrentSpeedText()+"car2: "+car2.getCurrentSpeedText();
                Toast.makeText(getApplicationContext(),info,Toast.LENGTH_SHORT).show();

                car2.closeSunRoof();
                Toast.makeText(getApplicationContext(),car2.getSunRoofInfo(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
