package com.example.badiem.HelperClass.HomeAdapter;

public class HistoryHelpersClass {
    String username,actionname,datetime;

    public HistoryHelpersClass( String username,String actionname, String datetime) {
        this.username = username;
        this.actionname = actionname;
        this.datetime = datetime;
    }

    public HistoryHelpersClass() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getActionname() {
        return actionname;
    }

    public void setActionname(String actionname) {
        this.actionname = actionname;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
