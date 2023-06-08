package no2114_2127.project.myapplication;

public class AwardClass {
    private String awardTitle;
    private String awardText;
    private String awardName;

    public AwardClass() {
        // 기본 생성자
    }

    public AwardClass(String awardTitle, String awardText, String awardName) {
        this.awardTitle = awardTitle;
        this.awardText = awardText;
        this.awardName = awardName;
    }

    public String getAwardTitle() {
        return awardTitle;
    }

    public void setAwardTitle(String awardTitle) {
        this.awardTitle = awardTitle;
    }

    public String getAwardText() {
        return awardText;
    }

    public void setAwardText(String awardText) {
        this.awardText = awardText;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }
}
