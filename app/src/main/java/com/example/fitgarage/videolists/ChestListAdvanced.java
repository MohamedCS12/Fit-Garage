package com.example.fitgarage.videolists;

import com.example.fitgarage.R;
public class ChestListAdvanced extends VideoList {

    private String workoutName = "Advanced Chest Workout";
    private final int calPer3600s = 350;

    private VideoNode chest1 = new VideoNode(6, 1, R.raw.armcircles, "Arm Circles Stretches", 1, "20 seconds");
    private VideoNode chest2 = new VideoNode(6, 2, R.raw.forwardelbow, "Forward Elbow Stretches", 1, "20 Seconds");
    private VideoNode chest3 = new VideoNode(6, 3, R.raw.kneelingpylo, "Kneeling Pylo Push-ups", 1, "20 seconds");
    private VideoNode chest4 = new VideoNode(6, 4, R.raw.uneven, "Uneven Push-ups Left Arm", 1, "12 Times");
    private VideoNode chest5 = new VideoNode(6, 5, R.raw.uneven, "Uneven Push-ups Right Arm", 1, "12 Times");
    private VideoNode chest6 = new VideoNode(6, 6, R.raw.uneven, "Uneven Push-ups Left Arm", 1, "12 Times");
    private VideoNode chest7 = new VideoNode(6, 7, R.raw.uneven, "Uneven Push-ups Right Arm", 1, "12 Times");
    private VideoNode chest8 = new VideoNode(6, 8, R.raw.triceps, "Left Triceps Stretches", 1, "20 Seconds");
    private VideoNode chest9 = new VideoNode(6, 9, R.raw.triceps, "Right Triceps Stretches", 1, "20 Seconds");
    private VideoNode chest10 = new VideoNode(6, 10, R.raw.spiderman, "SpiderMan Pushups", 1, "20 Times");
    private VideoNode chest11 = new VideoNode(6, 11, R.raw.tricepspushups, "Triceps Pushups", 1, "15 Times");
    private VideoNode chest12 = new VideoNode(6, 12, R.raw.deflictpushup, "Deflict Stretch", 1, "16 Times");
    private VideoNode chest13 = new VideoNode(6, 13, R.raw.widearmplanks, "Wide Arm planks", 1, "30 Seconds");
    private VideoNode chest14 = new VideoNode(6, 14, R.raw.triceps, "Left Triceps Stretch", 1, "30 Seconds");
    private VideoNode chest15 = new VideoNode(6, 13, R.raw.triceps, "Right Triceps Sretch", 1, "30 Seconds");
    private VideoNode chest16 = new VideoNode(6, 14, R.raw.widearmplanks, "Right Chest Stretch", 1, "30 Seconds");

    public ChestListAdvanced() {
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
        chest14.next = chest15;
        chest15.next = chest16;
    }

    public int getChar() {
        return calPer3600s;
    }

    @Override
    public VideoNode getHead() {
        return chest1;
    }

    @Override
    public String getListName() {
        return this.workoutName;
    }
}
