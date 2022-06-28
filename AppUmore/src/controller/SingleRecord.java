/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author leokk
 */
class SingleRecord {
    private Integer mood;
    private String activity;

    public SingleRecord(Integer mood, String activity) {
        this.mood = mood;
        this.activity = activity;
    }

    public Integer getMood() {
        return mood;
    }

    public String getActivity() {
        return activity;
    }

    protected void setMood(Integer mood) {
        this.mood = mood;
    }

    protected void setActivity(String activity) {
        this.activity = activity;
    }
    
    
}
