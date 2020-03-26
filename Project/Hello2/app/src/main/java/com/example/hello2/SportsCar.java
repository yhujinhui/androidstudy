package com.example.hello2;

public class SportsCar extends Car {
    private boolean isOpenSunRoof=false;
    public SportsCar(int acceleration, int maxSpeed, int brakeSpeed){
        super(acceleration,maxSpeed,brakeSpeed);
    }
    public void openSunRoof(){
        isOpenSunRoof=true;
    }
    public void closeSunRoof(){
        isOpenSunRoof=false;
    }
    public String getSunRoofInfo(){
        if(isOpenSunRoof){
            return "선루프를 열었더니 상쾌하다.";
        }else{
            return "선루프는 닫혀있다.";
        }
    }

    @Override
    public String getCurrentSpeedText() {
        return "스포츠카 입니다"+super.getCurrentSpeedText();
    }
}
