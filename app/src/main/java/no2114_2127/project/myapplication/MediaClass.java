package no2114_2127.project.myapplication;

public class MediaClass {
    public static byte[] imageClass;
    public static VideoMedioClass videoMedioClass;

    public MediaClass() {
        // 기본 생성자
    }

    public static byte[] getImageClass() {
        return imageClass;
    }

    public static void setImageClass(byte[] imageClass) {
        MediaClass.imageClass = imageClass;
    }

    public static VideoMedioClass getVideoClass() {
        return videoMedioClass;
    }

    public static void setVideoClass(VideoMedioClass videoMedioClass) {
        MediaClass.videoMedioClass = videoMedioClass;
    }
}
