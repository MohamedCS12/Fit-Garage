package com.example.fitgarage.videolists;

import com.example.fitgarage.R;

public class AbsListAdvanced extends VideoList {

    private String workoutName = "Advanced Core Workout";
    private final int calPer3600s = 288;

    private VideoNode abs1 = new VideoNode(9,1, R.raw.abs19, "Full Body Crunch", 1, "45 Seconds");
    private VideoNode abs2 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");
    private VideoNode abs3 = new VideoNode(9,1, R.raw.abs19, "Full Body Crunch", 1, "45 Seconds");
    private VideoNode abs4 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");
    private VideoNode abs5 = new VideoNode(9,1, R.raw.abs19, "Full Body Crunch", 1, "45 Seconds");
    private VideoNode abs6 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");

    private VideoNode abs7 = new VideoNode(9,2, R.raw.abs20, "Spiderman Plank", 1, "45 Seconds");
    private VideoNode abs8 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");
    private VideoNode abs9 = new VideoNode(9,2, R.raw.abs20, "Spiderman Plank", 1, "45 Seconds");
    private VideoNode abs10 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");
    private VideoNode abs11 = new VideoNode(9,2, R.raw.abs20, "Spiderman Plank", 1, "45 Seconds");
    private VideoNode abs12 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");

    private VideoNode abs13 = new VideoNode(9,3, R.raw.abs2, "Bicycle Crunch", 1,"45 Seconds");
    private VideoNode abs14 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");
    private VideoNode abs15 = new VideoNode(9,3, R.raw.abs2, "Bicycle Crunch", 1,"45 Seconds");
    private VideoNode abs16 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");
    private VideoNode abs17 = new VideoNode(9,3, R.raw.abs2, "Bicycle Crunch", 1,"45 Seconds");
    private VideoNode abs18 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");

    private VideoNode abs19 = new VideoNode(9,4, R.raw.abs21, "Heel Touches", 1,"45 Seconds");
    private VideoNode abs20 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");
    private VideoNode abs21 = new VideoNode(9,4, R.raw.abs21, "Heel Touches", 1,"45 Seconds");
    private VideoNode abs22 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");
    private VideoNode abs23 = new VideoNode(9,4, R.raw.abs21, "Heel Touches", 1,"45 Seconds");
    private VideoNode abs24 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");

    private VideoNode abs25 = new VideoNode(9,1, R.raw.abs22, "Knee Drives", 1, "45 Seconds");
    private VideoNode abs26 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");
    private VideoNode abs27 = new VideoNode(9,1, R.raw.abs22, "Knee Drives", 1, "45 Seconds");
    private VideoNode abs28 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");
    private VideoNode abs29 = new VideoNode(9,1, R.raw.abs22, "Knee Drives", 1, "45 Seconds");
    private VideoNode abs30 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");

    private VideoNode abs31 = new VideoNode(9,2, R.raw.abs7, "Reverse Crunch", 1, "45 Seconds");
    private VideoNode abs32 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");
    private VideoNode abs33 = new VideoNode(9,2, R.raw.abs7, "Reverse Crunch", 1, "45 Seconds");
    private VideoNode abs34 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");
    private VideoNode abs35 = new VideoNode(9,2, R.raw.abs7, "Reverse Crunch", 1, "45 Seconds");
    private VideoNode abs36 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");

    private VideoNode abs37 = new VideoNode(9,3, R.raw.abs3, "Crunches", 1,"45 Seconds");
    private VideoNode abs38 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");
    private VideoNode abs39 = new VideoNode(9,3, R.raw.abs3, "Crunches", 1,"45 Seconds");
    private VideoNode abs40 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");
    private VideoNode abs41 = new VideoNode(9,3, R.raw.abs3, "Crunches", 1,"45 Seconds");
    private VideoNode abs42 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");

    private VideoNode abs43 = new VideoNode(9,3, R.raw.abs8, "Oblique Crunch Right", 1,"45 Seconds");
    private VideoNode abs44 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");
    private VideoNode abs45 = new VideoNode(9,3, R.raw.abs8, "Oblique Crunch Right", 1,"45 Seconds");
    private VideoNode abs46 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");
    private VideoNode abs47 = new VideoNode(9,3, R.raw.abs8, "Oblique Crunch Right", 1,"45 Seconds");
    private VideoNode abs48 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");

    private VideoNode abs49 = new VideoNode(9,3, R.raw.abs9, "Oblique Crunch Left", 1,"45 Seconds");
    private VideoNode abs50 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");
    private VideoNode abs51 = new VideoNode(9,3, R.raw.abs9, "Oblique Crunch Left", 1,"45 Seconds");
    private VideoNode abs52 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");
    private VideoNode abs53 = new VideoNode(9,3, R.raw.abs9, "Oblique Crunch Left", 1,"45 Seconds");
    private VideoNode abs54 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");

    private VideoNode abs55 = new VideoNode(9,3, R.raw.abs14, "Standard Plank", 1,"45 Seconds");
    private VideoNode abs56 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");
    private VideoNode abs57 = new VideoNode(9,3, R.raw.abs14, "Standard Plank", 1,"45 Seconds");
    private VideoNode abs58 = new VideoNode(9,5, R.raw.abs5, "Rest", 1,"15 Seconds");
    private VideoNode abs59 = new VideoNode(9,3, R.raw.abs14, "Standard Plank", 1,"45 Seconds");

    public AbsListAdvanced() {
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
        abs15.next = abs16;
        abs16.next = abs17;
        abs17.next = abs18;
        abs18.next = abs19;
        abs19.next = abs20;
        abs20.next = abs21;
        abs21.next = abs22;
        abs22.next = abs23;
        abs23.next = abs24;
        abs24.next = abs25;
        abs25.next = abs26;
        abs26.next = abs27;
        abs27.next = abs28;
        abs28.next = abs29;
        abs29.next = abs30;
        abs30.next = abs31;
        abs31.next = abs32;
        abs32.next = abs33;
        abs33.next = abs34;
        abs34.next = abs35;
        abs35.next = abs36;
        abs36.next = abs37;
        abs37.next = abs38;
        abs38.next = abs39;
        abs39.next = abs40;
        abs40.next = abs41;
        abs41.next = abs42;
        abs42.next = abs43;
        abs43.next = abs44;
        abs44.next = abs45;
        abs45.next = abs46;
        abs46.next = abs47;
        abs47.next = abs48;
        abs48.next = abs49;
        abs49.next = abs50;
        abs50.next = abs51;
        abs51.next = abs52;
        abs52.next = abs53;
        abs53.next = abs54;
        abs54.next = abs55;
        abs55.next = abs56;
        abs56.next = abs57;
        abs57.next = abs58;
        abs58.next = abs59;
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
