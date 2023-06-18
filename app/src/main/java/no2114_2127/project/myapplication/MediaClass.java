package no2114_2127.project.myapplication;

import android.net.Uri;

import java.io.File;

public class MediaClass {
    public static byte[] imageClass;
    public static File videoFile;

    public MediaClass() {
        // 기본 생성자
    }

    public static byte[] getImageClass() {
        return imageClass;
    }

    public static void setImageClass(byte[] imageClass) {
        MediaClass.imageClass = imageClass;
    }

    public static File getVideoFileClass() {
        return videoFile;
    }

    public static void setVideoFileClass(File videoFile) {
        MediaClass.videoFile = videoFile;
    }
}
