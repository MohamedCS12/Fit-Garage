package com.example.fitgarage.videolists;

import com.example.fitgarage.R;

public class ChestListBeginner extends VideoList {

    private String workoutName = "Beginner Chest Workout";
    private final int calPer3600s = 225;

    private VideoNode chest1 = new VideoNode(4, 1, R.raw.inclinepushup, "Incline Push-ups", 1, "18 Times");
    private VideoNode chest2 = new VideoNode(4, 2, R.raw.regularpushup, "Regular Pushups", 1, "12 Times");
    private VideoNode chest3 = new VideoNode(4, 3, R.raw.widepushup, "Wide Push-ups", 1, "10 Times");
    private VideoNode chest4 = new VideoNode(4, 4, R.raw.deflictpushup, "Deficit Push-ups", 1, "8 Times");
    private VideoNode chest5 = new VideoNode(4, 5, R.raw.widepushup, "Wide Push-ups", 1, "10 Times");
    private VideoNode chest6 = new VideoNode(4, 6, R.raw.inclinepushup, "Incline Push-ups", 1, "10 Times");
    private VideoNode chest7 = new VideoNode(4, 7, R.raw.regularpushup, "Regular Pushups", 1, "10 Times");
    private VideoNode chest8 = new VideoNode(4, 8, R.raw.kneelingpushup, "Kneeling Push-ups", 1, "12 Times");
    private VideoNode chest9 = new VideoNode(4, 9, R.raw.halfrangepushup, "HalfRanged Kneel Pushups", 1, "20 Seconds");
    private VideoNode chest10 = new VideoNode(4, 10, R.raw.leftrighttricepsstretch, "Left Triceps Stretch", 1, "20 Seconds");
    private VideoNode chest11 = new VideoNode(4, 11, R.raw.leftrighttricepsstretch, "Right Triceps Stretch", 1, "20 Seconds");
    private VideoNode chest12 = new VideoNode(4, 12, R.raw.frontdeltsstretch, "Front Delts Stretch", 1, "20 Seconds");
    private VideoNode chest13 = new VideoNode(4, 13, R.raw.leftrightcheststretch, "Left Chest Stretch", 1, "20 Seconds");
    private VideoNode chest14 = new VideoNode(4, 14, R.raw.leftrightcheststretch, "Right Chest Stretch", 1, "20 Seconds");

    public ChestListBeginner() {
        chest1.next = chest2;
        chest2.next = chest3;
        chest3.next = chest4;
        chest4.next = chest5;
        chest5.next = chest6;
        chest6.next = chest7;
        chest7.next = chest8;
        chest8.next = chest9;
        chest9.next = chest10;
        chest10.next = chest11;
        chest11.next = chest12;
        chest12.next = chest13;
        chest13.next = chest14;
    }

    @Override
    public VideoNode getHead() {
        return chest1;
    }

    @Override
    public String getListName() {
        return this.workoutName;
    }

    public int getChar() {
        return calPer3600s;
    }
}