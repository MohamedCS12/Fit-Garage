package com.example.fitgarage.videolists;

import com.example.fitgarage.R;

public class AbsListBeginner extends VideoList {

    private String workoutName = "Beginner Abs Workout";
    private final int calPer3600s = 330;

    private VideoNode abs1 = new VideoNode(7, 1, R.raw.abs1, "Russian Twist", 1, "30 Seconds");
    private VideoNode abs2 = new VideoNode(7, 5, R.raw.abs5, "Rest", 1, "30 Seconds");
    private VideoNode abs3 = new VideoNode(7, 2, R.raw.abs2, "Bicycle Crunches", 1, "30 Seconds");
    private VideoNode abs4 = new VideoNode(7, 5, R.raw.abs5, "Rest", 1, "30 Seconds");
    private VideoNode abs5 = new VideoNode(7, 3, R.raw.abs3, "Standard Crunches", 1, "30 Seconds");
    private VideoNode abs6 = new VideoNode(7, 5, R.raw.abs5, "Rest", 1, "30 Seconds");
    private VideoNode abs7 = new VideoNode(7, 4, R.raw.abs4, "Leg Raises", 1, "30 Seconds");
    private VideoNode abs8 = new VideoNode(7, 5, R.raw.abs5, "Rest", 1, "30 Seconds");
    private VideoNode abs9 = new VideoNode(7, 1, R.raw.abs1, "Russian Twist", 1, "30 Seconds");
    private VideoNode abs10 = new VideoNode(7, 5, R.raw.abs5, "Rest", 1, "30 Seconds");
    private VideoNode abs11 = new VideoNode(7, 2, R.raw.abs2, "Bicycle Crunches", 1, "30 Seconds");
    private VideoNode abs12 = new VideoNode(7, 5, R.raw.abs5, "Rest", 1, "30 Seconds");
    private VideoNode abs13 = new VideoNode(7, 3, R.raw.abs3, "Standard Crunches", 1, "30 Seconds");
    private VideoNode abs14 = new VideoNode(7, 5, R.raw.abs5, "Rest", 1, "30 Seconds");
    private VideoNode abs15 = new VideoNode(7, 4, R.raw.abs4, "Leg Raises", 1, "30 Seconds");

    public AbsListBeginner() {
        abs1.next = abs2;
        abs2.next = abs3;
        abs3.next = abs4;
        abs4.next = abs5;
        abs5.next = abs6;
        abs6.next = abs7;
        abs7.next = abs8;
        abs8.next = abs9;
        abs9.next = abs10;
        abs10.next = abs11;
        abs11.next = abs12;
        abs12.next = abs13;
        abs13.next = abs14;
        abs14.next = abs15;
    }

    @Override
    public VideoNode getHead() {
        return abs1;
    }

    @Override
    public String getListName() {
        return this.workoutName;
    }

    public int getChar() {
        return calPer3600s;
    }
}