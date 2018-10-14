package com.example.ritamartiniano.reminders;

public class Reminder {
    private int mID;
    private String mContent;
    private int mImportant;
    public Reminder(int id,String content, int important){
        mID=id;
        mImportant=important;
        mContent=content;
    }
    public int getId()
    {return mID;}

    public void setId(int id) {
        mID = id;
    }
    public int getImportant() {
        return mImportant;
    }
    public void setImportant(int important) {
        mImportant = important;
    }
    public String getContent() {
        return mContent;
    }
    public void setContent(String content) {
        mContent = content;
    }

}
