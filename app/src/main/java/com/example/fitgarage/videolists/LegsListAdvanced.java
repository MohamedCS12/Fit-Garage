package com.example.fitgarage.videolists;

import com.example.fitgarage.R;

public class LegsListAdvanced extends VideoList {

    private String workoutName = "Advanced Legs Workout";
    private final int calPer3600s = 237;

    private VideoNode legs1 = new VideoNode(12, 1, R.raw.legs17, "Jumping Jacks", 1, "30 Seconds");
    private VideoNode legs2 = new VideoNode(12, 2, R.raw.legs18, "Frog Squats", 1, "45 Seconds");
    private VideoNode legs3 = new VideoNode(12, 3, R.raw.legs19, "Single Leg Romanian Deadlift", 1, "45 Seconds");
    private VideoNode legs4 = new VideoNode(12, 4, R.raw.legs7, "Glute Bridge", 1, "45 Seconds");
    private VideoNode legs5 = new VideoNode(12, 5, R.raw.legs20, "Wall Sit", 1, "45 Seconds");
    private VideoNode legs6 = new VideoNode(12, 6, R.raw.legs21, "Bulgarian Split Squats", 1, "45 Seconds");
    private VideoNode legs7 = new VideoNode(12, 7, R.raw.legs22, "Sumo Walk", 1, "45 Seconds");
    private VideoNode legs8 = new VideoNode(12, 8, R.raw.legs14, "Lunges", 1, "45 Seconds");
    private VideoNode legs9 = new VideoNode(12, 9, R.raw.legs16, "Squat with Side Leg Raise", 1, "45 Seconds");
    private VideoNode legs10 = new VideoNode(12, 10, R.raw.legs20, "Wall Sit", 1, "45 Seconds");
    private VideoNode legs11 = new VideoNode(12, 11, R.raw.legs23, "Alternating Assisted Pistol Squats", 1, "45 Seconds");
    private VideoNode legs12 = new VideoNode(12, 12, R.raw.legs14, "Back And Forth Lunges", 1, "45 Seconds");
    private VideoNode legs13 = new VideoNode(12, 13, R.raw.legs9, "Kickbacks", 1, "45 Seconds");
    private VideoNode legs14 = new VideoNode(12, 14, R.raw.legs1, "Elevated Side Squats", 1, "45 Seconds");
    private VideoNode legs15 = new VideoNode(12, 15, R.raw.legs20, "Wall SIt", 1, "45 Seconds");
    private VideoNode legs16 = new VideoNode(12, 15, R.raw.legs14, "Lunges", 1, "45 Seconds");
    private VideoNode legs17 = new VideoNode(12, 15, R.raw.legs24, "Buttkick", 1, "45 Seconds");
    private VideoNode legs18 = new VideoNode(12, 15, R.raw.legs22, "Crab Walk", 1, "45 Seconds");
    private VideoNode legs19 = new VideoNode(12, 15, R.raw.legs25, "Calf Raises", 1, "45 Seconds");
    private VideoNode legs20 = new VideoNode(12, 15, R.raw.legs20, "Wall Sit", 1, "45 Seconds");

    public LegsListAdvanced() {
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
        legs15.next = legs16;
        legs16.next = legs17;
        legs17.next = legs18;
        legs18.next = legs19;
        legs19.next = legs20;

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
