package com.example.fitgarage.videolists;

import com.example.fitgarage.R;

public class VideoList {

    private String name = "Test Videos";
    private final int calPer3600s = 1;

    private VideoNode video1 = new VideoNode(0,1, R.raw.trial, "Shenli", 2, "Test 1");
    private VideoNode video2 = new VideoNode(0,2, R.raw.video2, "Jianxin",1, "Test 2");

    public int getCal() {
        return calPer3600s;
    }

    public VideoList() {
        video1.next = video2;
    }

    public VideoNode getHead() {
        return video1;
    }

    public String getListName() {
        return this.name;
    }
}
