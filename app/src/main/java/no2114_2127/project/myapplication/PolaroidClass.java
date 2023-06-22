package no2114_2127.project.myapplication;

import android.widget.GridView;

import com.google.firebase.firestore.CollectionReference;

public class PolaroidClass {
    private String photoImage;
    private int polaroidImage;
    private String polaroidText;

    public PolaroidClass() {
        // 기본 생성자
    }

    public PolaroidClass(String photoImage, int polaroidImage, String polaroidText) {
        this.photoImage = photoImage;
        this.polaroidImage = polaroidImage;
        this.polaroidText = polaroidText;
    }
    public PolaroidClass(String photoImage, String polaroidImage, String polaroidText) {
        this.photoImage = photoImage;
        this.polaroidImage = Integer.parseInt(polaroidImage);
        this.polaroidText = polaroidText;
    }

    public String getPhotoImage() {
        return photoImage;
    }

    public void setPhotoImage(String photoImage) {
        this.photoImage = photoImage;
    }

    public int getPolaroidImage() {
        return polaroidImage;
    }

    public void setPolaroidImage(int polaroidImage) {
        this.polaroidImage = polaroidImage;
    }

    public String getPolaroidText() {
        return polaroidText;
    }

    public void setPolaroidText(String polaroidText) {
        this.polaroidText = polaroidText;
    }
}