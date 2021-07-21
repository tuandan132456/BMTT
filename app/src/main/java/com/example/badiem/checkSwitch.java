package com.example.badiem;

public class checkSwitch {
    private static checkSwitch reference;
    public static int check ;
    private checkSwitch(){

    }

    public static checkSwitch getReference(){
        if (reference == null){
            reference = new checkSwitch();
        }
        return reference;
    }

    public static int getCheck() {
        return check;
    }

    public static void setCheck(int check) {
        checkSwitch.check = check;
    }
}
