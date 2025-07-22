package com.example.fitgarage.videolists;

public class VideoNode {

    int workoutNo;
    int videoNo;
    public String name;
    public int time;
    public int url;
    public String note;
    public VideoNode next;

    VideoNode(int workoutNo, int videoNo, int url, String name, int time, String note) {
        this.workoutNo = workoutNo;
        this.videoNo = videoNo;
        this.name = name;
        this.url = url;
        this.time = time;
        this.note = note;
        this.next = null;
    }
}
