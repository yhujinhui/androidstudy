package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(), "onCreate() 호출됨", Toast.LENGTH_SHORT).show();

        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
//onCreate()는 Activity가 최초 생성할 때 호출,강제종료 불가능
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart() 호출됨", Toast.LENGTH_SHORT).show();

    }
//oonStart()는 Activity가 사용자에게 보여지기 직전에 호출,강제종료 불가능
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop() 호출됨", Toast.LENGTH_SHORT).show();

    }
//onStop()은 다른 Activity가 Activity를 완전히 가려서 더 이상 보이지 않았을 때 호출됩니다.
//Activity가 다시 시작되면 onRestart()를 호출하여 onStart() -> onResume()을 통해 활성화됩니다.
//이 때에는 강제종료가 가능한데 Process Kill을 통해서 하는 방법과 onDestroy()를 호출하여 종료하는 방법 2가지로나뉘게 됩니다.

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy() 호출됨", Toast.LENGTH_SHORT).show();
    }
//onDestroy()는 Activity가 삭제되지 직전에 호출됩니다.
//Activity가 받는 마지막 호출 매소드로 finish()를 호출하여 사용하게 됩니다.
//호출된 후에는 Activity가 종료됩니다.

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause() 호출됨", Toast.LENGTH_SHORT).show();

        SharedPreferences pref= getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putString("name","소녀시대");
        editor.commit();
    }
//onPause()는 다른 Activity가 활성화 되었을 때 호출
//다시 Activity가 활성화되면 onResume()이 호출되어 Activity를 활성화 하지만,
//onPause()상태에 있다가 메모리가 부족하면 Process Kill을 하여 메모리를 반환하게 됩니다.
//onPause()는 Activity화면이 조금이라도 남아있을 때 진행되지만 다른 Activity가 기존 Activity를 가려서 보이지 않게 되면 onStop()을 호출합니다.
//이 때에는 강제종료가 가능한데 이 때에는 Process Kill로 종료하는 것입니다.

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume() 호출됨", Toast.LENGTH_SHORT).show();
        SharedPreferences pref= getSharedPreferences("pref", Activity.MODE_PRIVATE);

        if(pref!=null){
            String name=pref.getString("name","");
            Toast.makeText(getApplicationContext(),"복구된 이름 : "+name,Toast.LENGTH_SHORT).show();
        }
    }
}
//onResume()은 Activity가 사용자와 상호작용을 하기 직전에 호출,강제종료 불가능
//스택의 최상위에 위치하여 Activity를 활성화시키는데, 활성화 상태에 있다가 다른 Activity가 활성화되면 onResume()이 실행됩니다.
//실행중 다른 Activity가 활성화되었을 때, 기존 Activity가 화면에 보이면 onPause()에서 처리하고 보이지 않으면 onStop()으로 이어져 처리하게 됩니다.



//onRestart() Activity가 정지된후 (onStop())다시 시작하기 전에 호출출