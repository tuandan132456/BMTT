package com.example.badiem;

public class shareData {
    private static shareData instance;
    public static String str="";
    private shareData(){

    }

    public static shareData getInstance(){
        if (instance == null){
            instance = new shareData();
        }
        return instance;
    }

    public static String getStr() {
        return str;
    }

    public static void setStr(String str) {
        shareData.str = str;
    }
}
