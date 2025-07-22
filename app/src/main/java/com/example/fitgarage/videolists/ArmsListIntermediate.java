package com.example.fitgarage.videolists;

import com.example.fitgarage.R;

public class ArmsListIntermediate extends VideoList {

    private String workoutName = "Intermediate Arm Workout";
    private final int calPer3600s = 600;

    private VideoNode arms1 = new VideoNode(2, 1, R.raw.lowplank, "Low Plank", 1, "45 seconds");
    private VideoNode arms2 = new VideoNode(2, 2, R.raw.plankupanddown, "Plank Up and Down", 1, "25 Times");
    private VideoNode arms3 = new VideoNode(2, 3, R.raw.shouldertaps, "Shoulder Taps", 1, "45 seconds");
    private VideoNode arms4 = new VideoNode(2, 4, R.raw.regularpushups, "Regular Push-ups", 1, "20 Times");
    private VideoNode arms5 = new VideoNode(2, 5, R.raw.shouldertaps, "Shoulder Taps", 1, "45 seconds");
    private VideoNode arms6 = new VideoNode(2, 6, R.raw.shadowboxing, "Shadow Boxing", 1, "30 seconds");
    private VideoNode arms7 = new VideoNode(2, 7, R.raw.leftliftup, "Left Lift Up", 1, "12 Times");
    private VideoNode arms8 = new VideoNode(2, 8, R.raw.rightliftup, "Right Lift Up", 1, "12 Times");
    private VideoNode arms9 = new VideoNode(2, 9, R.raw.backpushups, "Back Push Ups", 1, "20 Times");
    private VideoNode arms10 = new VideoNode(2, 10, R.raw.lowplank, "Low Plank", 1, "45 seconds");
    private VideoNode arms11 = new VideoNode(2, 11, R.raw.plankupanddown, "Plank Up and Down", 1, "25 Times");
    private VideoNode arms12 = new VideoNode(2, 12, R.raw.shouldertaps, "Shoulder Taps", 1, "45 seconds");

    public ArmsListIntermediate() {
        arms1.next = arms2;
        arms2.next = arms3;
        arms3.next = arms4;
        arms4.next = arms5;
        arms5.next = arms6;
        arms6.next = arms7;
        arms7.next = arms8;
        arms8.next = arms9;
        arms9.next = arms10;
        arms10.next = arms11;
        arms11.next = arms12;
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

