package no2114_2127.project.myapplication;

import android.net.Uri;

public class VideoClass {
    private String videoString;

    public VideoClass() {
        // 기본 생성자
    }

    public VideoClass(String videoString) {
        this.videoString = videoString;
        // 기본 생성자
    }

    public void setVideoName(String videoString) {
        this.videoString = videoString;
    }

    public String getVideoName() {
        return videoString;
    }

}
