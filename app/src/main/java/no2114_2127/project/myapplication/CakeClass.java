package no2114_2127.project.myapplication;

public class CakeClass {
    private String rollingPaper;
    private String from;
    private int decoImage;
    private int letterPaper;

    public CakeClass() {
        // 기본 생성자
    }

    public CakeClass(String rollingPaper, String from, int decoImage, int letterPaper) {
        this.rollingPaper = rollingPaper;
        this.from = from;
        this.decoImage = decoImage;
        this.letterPaper = letterPaper;
    }
    
    public String getRollingPaper() {
        return rollingPaper;
    }

    public void setRollingPaper(String rollingPaper) {
        this.rollingPaper = rollingPaper;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public int getDecoImage() {
        return decoImage;
    }

    public void setDecoImage(int decoImage) {
        this.decoImage = decoImage;
    }

    public int getLetterPaper() {
        return letterPaper;
    }

    public void setLetterPaper(int letterPaper) {
        this.letterPaper = letterPaper;
    }
}
