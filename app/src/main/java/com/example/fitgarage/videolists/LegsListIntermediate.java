package com.example.fitgarage.videolists;

import com.example.fitgarage.R;

public class LegsListIntermediate extends VideoList {

    private String workoutName = "Intermediate Legs Workout";
    private final int calPer3600s = 219;

    private VideoNode legs1 = new VideoNode(11, 1, R.raw.legs11, "Burpees", 1, "105 Seconds");
    private VideoNode legs2 = new VideoNode(11, 2, R.raw.legs12, "Backward Lunges + Knee lifts", 1, "105 Seconds");
    private VideoNode legs3 = new VideoNode(11, 3, R.raw.legs13, "X-jumps", 1, "105 Seconds");
    private VideoNode legs4 = new VideoNode(11, 4, R.raw.legs14, "Forward Lunges", 1, "105 Seconds");
    private VideoNode legs5 = new VideoNode(11, 5, R.raw.legs15, "Jump Squats", 1, "105 Seconds");
    private VideoNode legs6 = new VideoNode(11, 6, R.raw.legs14, "Alternating Lunges", 1, "105 Seconds");
    private VideoNode legs7 = new VideoNode(11, 7, R.raw.legs11, "Burpees", 1, "105 Seconds");
    private VideoNode legs8 = new VideoNode(11, 8, R.raw.legs16, "Squats with High Knees", 1, "105 Seconds");
    private VideoNode legs9 = new VideoNode(11, 9, R.raw.legs11, "Burpees", 1, "105 Seconds");
    private VideoNode legs10 = new VideoNode(11, 10, R.raw.legs12, "Backward Lunges + Knee lifts", 1, "105 Seconds");
    private VideoNode legs11 = new VideoNode(11, 11, R.raw.legs13, "X-jumps", 1, "105 Seconds");
    private VideoNode legs12 = new VideoNode(11, 12, R.raw.legs14, "Forward Lunges", 1, "105 Seconds");
    private VideoNode legs13 = new VideoNode(11, 13, R.raw.legs15, "Jump Squats", 1, "105 Seconds");
    private VideoNode legs14 = new VideoNode(11, 14, R.raw.legs14, "Alternating Lunges", 1, "105 Seconds");
    private VideoNode legs15 = new VideoNode(11, 15, R.raw.legs11, "Burpees", 1, "105 Seconds");
    private VideoNode legs16 = new VideoNode(11, 15, R.raw.legs16, "Squats with High Knees", 1, "105 Seconds");

    public LegsListIntermediate() {
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
