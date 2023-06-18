package no2114_2127.project.myapplication;

import android.net.Uri;

import java.io.File;

public class VideoMedioClass {
    private static File videoFile;

    public VideoMedioClass() {
        // 기본 생성자
    }

    public VideoMedioClass(File videoFile) {
        this.videoFile = videoFile;
    }

    public File getVideoUri() {
        return videoFile;
    }

    public void setVideoUri(File videoFile) {
        this.videoFile = videoFile;
    }


}
