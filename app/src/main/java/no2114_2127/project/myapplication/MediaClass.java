package no2114_2127.project.myapplication;

public class MediaClass {
    public static ImageClass imageClass;
    public static VideoMedioClass videoMedioClass;

    public MediaClass() {
        // 기본 생성자
    }

    public static ImageClass getImageClass() {
        return imageClass;
    }

    public static void setImageClass(ImageClass imageClass) {
        MediaClass.imageClass = imageClass;
    }

    public static VideoMedioClass getVideoClass() {
        return videoMedioClass;
    }

    public static void setVideoClass(VideoMedioClass videoMedioClass) {
        MediaClass.videoMedioClass = videoMedioClass;
    }
}
