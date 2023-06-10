package no2114_2127.project.myapplication;

public class AwardClass {
    private String awardTitle;
    private String awardText;
    private String awardToName;
    private String awardDate;
    private String awardFromName;

    public AwardClass() {
        // Default constructor
    }

    public AwardClass(String awardTitle, String awardText, String awardToName, String awardDate, String awardFromName) {
        this.awardTitle = awardTitle;
        this.awardText = awardText;
        this.awardToName = awardToName;
        this.awardDate = awardDate;
        this.awardFromName = awardFromName;
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

    public String getAwardToName() {
        return awardToName;
    }

    public void setAwardToName(String awardToName) {
        this.awardToName = awardToName;
    }

    public String getAwardDate() {
        return awardDate;
    }

    public void setAwardDate(String awardDate) {
        this.awardDate = awardDate;
    }

    public String getAwardFromName() {
        return awardFromName;
    }

    public void setAwardFromName(String awardFromName) {
        this.awardFromName = awardFromName;
    }
}