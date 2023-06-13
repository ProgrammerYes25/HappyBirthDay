package no2114_2127.project.myapplication;

import android.net.Uri;

public class VideoMedioClass {
    private Uri videoUri;

    public VideoMedioClass() {
        // 기본 생성자
    }

    public VideoMedioClass(Uri videoUri) {
        this.videoUri = videoUri;
    }

    public Uri getVideoUri() {
        return videoUri;
    }

    public void setVideoUri(Uri videoUri) {
        this.videoUri = videoUri;
    }


}
