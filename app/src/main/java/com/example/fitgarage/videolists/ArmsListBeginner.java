package com.example.fitgarage.videolists;

import com.example.fitgarage.R;

public class ArmsListBeginner extends VideoList {

    private String workoutName = "Beginner Arms Workout";
    private final int calPer3600s = 500;

    private VideoNode arms1 = new VideoNode(1, 1, R.raw.lowplank, "Low Plank", 1, "30 seconds");
    private VideoNode arms2 = new VideoNode(1, 2, R.raw.plankupanddown, "Plank Up and Down", 1, "20 Times");
    private VideoNode arms3 = new VideoNode(1, 3, R.raw.shouldertaps, "Shoulder Taps", 1, "30 seconds");
    private VideoNode arms4 = new VideoNode(1, 4, R.raw.pseudopushups, "Pseudo Push-ups", 1, "20 Times");
    private VideoNode arms5 = new VideoNode(1, 5, R.raw.lowplank, "Low Plank", 1, "30 seconds");
    private VideoNode arms6 = new VideoNode(1, 6, R.raw.plankupanddown, "Plank Up and Down", 1, "20 Times");
    private VideoNode arms7 = new VideoNode(1, 7, R.raw.shouldertaps, "Shoulder Taps", 1, "30 seconds");
    private VideoNode arms8 = new VideoNode(1, 8, R.raw.regularpushups, "Regular Pushups", 1, "12 Times");

    public ArmsListBeginner() {
        arms1.next = arms2;
        arms2.next = arms3;
        arms3.next = arms4;
        arms4.next = arms5;
        arms5.next = arms6;
        arms6.next = arms7;
        arms7.next = arms8;
    }

    @Override
    public VideoNode getHead() {
        return arms1;
    }

    @Override
    public String getListName() {
        return this.workoutName;
    }

    public int getChar() {
        return calPer3600s;
    }
}
