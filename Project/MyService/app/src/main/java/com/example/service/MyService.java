package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
//액티비티등 사용자 인터페이스가 없어도 백그라운드에서 실행되는 동작이 필요할 때가 있습니다.
//예를 들면 배경음악이라든지 안드로이드 사용량 모니터링이라든지, 주기적으로 특정 웹사이트에서 데이터를 읽어 온다든지...
//이러한 기능을 안드로이드에서는 Service (서비스) 를 통해서 제공합니다.

public class MyService extends Service {
    private static final String TAG="MyService";
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG,"onCreate() 호출");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand() 호출");
        if (intent == null) {
            return Service.START_STICKY;
            // Service가 강제 종료되었을 경우 시스템이 다시 Service를 재시작 시켜 주지만 intent 값을 null로 초기화 시켜서 재시작 합니다
        }else{
            processCommand(intent);
        }
        return super.onStartCommand(intent, flags, startId);
    }
//다른 컴포넌트에서 startService()를 호출하여서 서비스가 시작되면 이 메소드가 호출됩니다.
//작업이 완료되었을 경우 stopSelf() 나 stopService() 를 호출하여 서비스를 종료하여야 합니다.
//그렇지 않으면 무한 실행됩니다.

    private void processCommand(Intent intent){
        String commend=intent.getStringExtra("command");
        String name=intent.getStringExtra("name");

        Log.d(TAG,"전달받은 데이터 : "+commend+","+name);

        try{
            Thread.sleep(5000);
        }catch (Exception e){}

        Intent showIntent=new Intent(getApplicationContext(),MainActivity.class);
        showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK| //화면이 없는데서 화면이 있는걸 띄울수 있음
                            Intent.FLAG_ACTIVITY_SINGLE_TOP| //만들어진 엑티비티가 있다면 재활용
                            Intent.FLAG_ACTIVITY_CLEAR_TOP);//
        showIntent.putExtra("command","show");
        showIntent.putExtra("name",name+"from service");
        startActivity(showIntent);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestory() 호출");
    }
    // 서비스가 종료될 때 실행

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    // Service 객체와 (화면단 Activity 사이에서)
    // 통신(데이터를 주고받을) 때 사용하는 메서드
    // 데이터를 전달할 필요가 없으면 return null;
}
