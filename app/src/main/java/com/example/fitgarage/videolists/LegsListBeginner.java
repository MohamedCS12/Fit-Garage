package com.example.fitgarage.videolists;

import com.example.fitgarage.R;

public class LegsListBeginner extends VideoList {

    private String workoutName = "Beginner Legs Workout";
    private final int calPer3600s = 198;

    private VideoNode legs1 = new VideoNode(10, 1, R.raw.legs1, "Squats", 1, "30 Seconds");
    private VideoNode legs2 = new VideoNode(10, 2, R.raw.legs2, "Side Step Squats", 1, "30 Seconds");
    private VideoNode legs3 = new VideoNode(10, 3, R.raw.legs3, "Squat + Side Leg Lift", 1,"30 Seconds");
    private VideoNode legs4 = new VideoNode(10, 4, R.raw.legs4, "Kneeling Squats", 1, "30 Seconds");
    private VideoNode legs5 = new VideoNode(10, 5, R.raw.legs5, "Kneeling Lean Back", 1, "30 Seconds");
    private VideoNode legs6 = new VideoNode(10, 6, R.raw.legs4, "Kneeling Squats + 3 pulses", 1, "30 Seconds");
    private VideoNode legs7 = new VideoNode(10, 7, R.raw.legs6, "Inner Thigh Lift Left", 1, "30 Seconds");
    private VideoNode legs8 = new VideoNode(10, 8, R.raw.legs6, "Inner Thigh Lift Hold", 1, "30 Seconds");
    private VideoNode legs9 = new VideoNode(10, 9, R.raw.legs6, "Inner Thigh Lift Right", 1, "30 Seconds");
    private VideoNode legs10 = new VideoNode(10, 10, R.raw.legs6, "Inner Thigh Lift Hold", 1, "30 Seconds");
    private VideoNode legs11 = new VideoNode(10, 11, R.raw.legs7, "Glute Bridge", 1, "30 Seconds");
    private VideoNode legs12 = new VideoNode(10, 12, R.raw.legs7, "Wide Glute Bridge Pulses", 1, "30 Seconds");
    private VideoNode legs13 = new VideoNode(10, 13, R.raw.legs8, "Marching GLute", 1, "30 Seconds");
    private VideoNode legs14 = new VideoNode(10, 14, R.raw.legs9, "Donkey Kick", 1, "30 Seconds");
    private VideoNode legs15 = new VideoNode(10, 15, R.raw.legs10, "Frog Hold", 1, "30 Seconds");

    public LegsListBeginner() {
        legs1.next = legs2;
        legs2.next = legs3;
        legs3.next = legs4;
        legs4.next = legs5;
        legs5.next = legs6;
        legs6.next = legs7;
        legs7.next = legs8;
        legs8.next = legs9;
        legs9.next = legs10;
        legs10.next = legs11;
        legs11.next = legs12;
        legs12.next = legs13;
        legs13.next = legs14;
        legs14.next = legs15;
    }

    @Override
    public VideoNode getHead() {
        return legs1;
    }

    @Override
    public String getListName() {
        return this.workoutName;
    }

    public int getChar() {
        return calPer3600s;
    }
}

