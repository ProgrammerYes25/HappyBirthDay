package no2114_2127.project.myapplication;

public class CerdClass {
    private static CakeClass cakeClass;
    private static PolaroidClass polaroidClass;
    private static VideoClass videoClass;
    private static AwardClass awardClass;

    public CerdClass() {
        // 기본 생성자
    }

    public CerdClass(CakeClass cakeClass, PolaroidClass polaroidClass, VideoClass videoClass, AwardClass awardClass) {
        this.cakeClass = cakeClass;
        this.polaroidClass = polaroidClass;
        this.videoClass = videoClass;
        this.awardClass = awardClass;
    }

    public CakeClass getCakeClass() {
        return cakeClass;
    }

    public void setCakeClass(CakeClass cakeClass) {
        this.cakeClass = cakeClass;
    }

    public PolaroidClass getPolaroidClass() {
        return polaroidClass;
    }

    public void setPolaroidClass(PolaroidClass polaroidClass) {
        this.polaroidClass = polaroidClass;
    }

    public VideoClass getVideoClass() {
        return videoClass;
    }

    public void setVideoClass(VideoClass videoClass) {
        this.videoClass = videoClass;
    }

    public AwardClass getAwardClass() {
        return awardClass;
    }

    public void setAwardClass(AwardClass awardClass) {
        this.awardClass = awardClass;
    }
}
