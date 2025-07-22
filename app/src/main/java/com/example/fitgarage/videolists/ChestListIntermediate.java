package com.example.fitgarage.videolists;

import com.example.fitgarage.R;

public class ChestListIntermediate extends VideoList {

    private String workoutName = "Intermediate Chest Workout";
    private final int calPer3600s = 300;

    private VideoNode chest1 = new VideoNode(5, 1, R.raw.kneeling, "Kneeling Push-ups", 1, "10 Times");
    private VideoNode chest2 = new VideoNode(5, 2, R.raw.regularpushup, "Regular Pushups", 1,  "20 Times");
    private VideoNode chest3 = new VideoNode(5, 3, R.raw.diamond, "Diamond Push-ups", 1, "15 Times");
    private VideoNode chest4 = new VideoNode(5, 4, R.raw.uneven, "Uneven Push-ups", 1, "10 Times");
    private VideoNode chest5 = new VideoNode(5, 5, R.raw.uneven, "Uneven Push-ups", 1, "10 Times");
    private VideoNode chest6 = new VideoNode(5, 6, R.raw.kneelingpylo, "Kneeling Push-ups", 1, "16 Seconds");
    private VideoNode chest7 = new VideoNode(5, 7, R.raw.deflictpushup, "Deflict Pushups", 1, "12 Times");
    private VideoNode chest8 = new VideoNode(5, 8, R.raw.kneelingpushup, "Kneeling Push-ups", 1, "10 Times");
    private VideoNode chest9 = new VideoNode(5, 9, R.raw.regularpushup, "Regular Pushups", 1, "15 Times");
    private VideoNode chest10 = new VideoNode(5, 10, R.raw.kneelingpushup, "Kneeling Pushups", 1, "10 Times");
    private VideoNode chest11 = new VideoNode(5, 11, R.raw.leftrighttricepsstretch, "Left Triceps Stretch", 1, "20 Seconds");
    private VideoNode chest12 = new VideoNode(5, 12, R.raw.leftrighttricepsstretch, "Right Triceps Stretch", 1, "20 Seconds");
    private VideoNode chest13 = new VideoNode(5, 13, R.raw.leftrightcheststretch, "Left Chest Stretch", 1, "20 Seconds");
    private VideoNode chest14 = new VideoNode(5, 14, R.raw.leftrightcheststretch, "Right Chest Stretch", 1, "20 Seconds");

    public ChestListIntermediate() {
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
