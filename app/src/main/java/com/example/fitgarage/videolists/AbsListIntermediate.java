package com.example.fitgarage.videolists;

import com.example.fitgarage.R;

public class AbsListIntermediate extends VideoList {

    private String workoutName = "Intermediate Abs Workout";
    private final int calPer3600s = 390;

    private VideoNode abs1 = new VideoNode(8, 1, R.raw.abs4, "Leg Raises", 1, "30 Seconds");
    private VideoNode abs2 = new VideoNode(8, 5, R.raw.abs7, "Reverse Crunch", 1, "30 Seconds");
    private VideoNode abs3 = new VideoNode(8, 2, R.raw.abs8, "Oblique Crunch Right", 1, "30 Seconds");
    private VideoNode abs4 = new VideoNode(8, 5, R.raw.abs9, "Oblique crunch Left", 1, "30 Seconds");
    private VideoNode abs5 = new VideoNode(8, 3, R.raw.abs10, "Side Plank with Crunch Right", 1, "30 Seconds");
    private VideoNode abs6 = new VideoNode(8, 5, R.raw.abs11, "Side Plank with Dip Right", 1, "30 Seconds");
    private VideoNode abs7 = new VideoNode(8, 4, R.raw.abs12, "Side Plank with Crunch Left", 1, "30 Seconds");
    private VideoNode abs8 = new VideoNode(8, 5, R.raw.abs13, "Side Plank with Dip Left", 1, "30 Seconds");
    private VideoNode abs9 = new VideoNode(8, 1, R.raw.abs14, "Standard Plank", 1, "30 Seconds");
    private VideoNode abs10 = new VideoNode(8, 5, R.raw.abs15, "Bird Dog Right", 1, "30 Seconds");
    private VideoNode abs11 = new VideoNode(8, 2, R.raw.abs16, "Bird Dog Left", 1, "30 Seconds");
    private VideoNode abs12 = new VideoNode(8, 5, R.raw.abs2, "Bicycle Crunches", 1, "30 Seconds");
    private VideoNode abs13 = new VideoNode(8, 3, R.raw.abs18, "Alternative Jackknives", 1, "30 Seconds");
    private VideoNode abs14 = new VideoNode(8, 5, R.raw.abs3, "Crunches", 1, "30 Seconds");

    public AbsListIntermediate() {
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